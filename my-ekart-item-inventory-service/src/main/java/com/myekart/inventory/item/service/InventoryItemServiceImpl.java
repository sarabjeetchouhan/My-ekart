package com.myekart.inventory.item.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myekart.inventory.item.entity.InventoryItem;
import com.myekart.inventory.item.exception.InventoryItemException;
import com.myekart.inventory.item.repositories.InventoryItemRepository;
import com.myekart.inventory.item.util.InventoryItemMapper;
import com.myekart.messaging.inventory.InventoryItemFilterRequest;
import com.myekart.messaging.inventory.InventoryItemRequest;
import com.myekart.messaging.inventory.InventoryListResponse;
import com.myekart.messaging.inventory.InventoryResponse;
import com.myekart.messaging.order.OrderItemsRequest;
import com.myekart.messaging.order.OrderRequest;
import com.myekart.messaging.order.OrderResponse;
import com.myekart.utilities.commons.CommonUtils;
import com.myekart.utilities.config.exception.ResponseStatus;
import com.myekart.utilities.enums.StatusCd;

@Service("inventoryItemService")
public class InventoryItemServiceImpl implements InventoryItemService {

	@Autowired
	private InventoryItemRepository inventoryItemRepository;

	@Autowired
	private InventoryItemMapper inventoryItemMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = InventoryItemException.class)
	public InventoryResponse addItem(InventoryItemRequest request) throws InventoryItemException {
		InventoryResponse response = new InventoryResponse();
		InventoryItem item = inventoryItemMapper.requestToEntity(request);
		item.setItemId(CommonUtils.generateId());
		item.setStatusCd(StatusCd.IN_STOCK.status());
		InventoryItemRequest savedItem = inventoryItemMapper.entityToRequest(inventoryItemRepository.save(item));
		response.setMessage(savedItem);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS, request.getItemName() + " added to inventory"));
		return response;
	}

	@Override
	public InventoryListResponse fetchItemFilter(InventoryItemFilterRequest filterRequest)
			throws InventoryItemException {
		InventoryListResponse response = new InventoryListResponse();
		Specification<InventoryItem> specification = new Specification<InventoryItem>() {

			/** The Constant serialVersionUID. */
			private static final long serialVersionUID = 2462181805276819444L;

			@Override
			public Predicate toPredicate(Root<InventoryItem> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>();
				if (StringUtils.isNotEmpty(filterRequest.getCategory())) {
					predicates.add(cb.equal(root.get("category"), filterRequest.getCategory()));
				}

				if (StringUtils.isNotEmpty(filterRequest.getSubCategory())) {
					predicates.add(cb.equal(root.get("subCategory"), filterRequest.getSubCategory()));
				}
				if (StringUtils.isNotEmpty(filterRequest.getName())) {
					predicates.add(cb.equal(root.get("itemName"), filterRequest.getName()));
				}
				if (filterRequest.getFromPrice() != null) {
					predicates.add(cb.greaterThan(root.get("price"), filterRequest.getFromPrice()));
				}
				if (filterRequest.getToPrice() != null) {
					predicates.add(cb.lessThan(root.get("price"), filterRequest.getToPrice()));
				}
				predicates.add(cb.notEqual(root.get("statusCd"), StatusCd.DELETED.status()));
				List<Order> orders = new ArrayList<>();
				if (filterRequest.isSortByCategory()) {
					orders.add(cb.asc(root.get("category")));
				}
				if (filterRequest.isSortBySubCategory()) {
					orders.add(cb.asc(root.get("subCategory")));
				}
				if (filterRequest.isSortByName()) {
					orders.add(cb.asc(root.get("itemName")));
				}
				if (filterRequest.isSortByprice()) {
					orders.add(cb.asc(root.get("price")));
				}
				query.orderBy(orders);
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
		Pageable page = PageRequest.of(0, filterRequest.getPageSize() != 0 ? filterRequest.getPageSize() : 100);
		Page<InventoryItem> pageData = inventoryItemRepository.findAll(specification, page);
		List<InventoryItem> results = pageData.toList();
		if (CollectionUtils.isNotEmpty(results)) {
			response.setResults(
					results.stream().map(o -> inventoryItemMapper.entityToRequest(o)).collect(Collectors.toList()));
		} else {
			response.setResults(Collections.emptyList());
		}
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	@Override
	public OrderResponse validateOrder(OrderRequest request) throws InventoryItemException {
		OrderResponse response = new OrderResponse();
		BigDecimal bill = validateOrderItemsAndCalculateBill(request.getOrderItems());
		request.setTotalBill(bill);
		response.setMessage(request);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	private BigDecimal validateOrderItemsAndCalculateBill(List<OrderItemsRequest> orderItems)
			throws InventoryItemException {
		List<String> errors = new ArrayList<String>();
		BigDecimal bill = BigDecimal.ZERO;
		for (OrderItemsRequest orderItem : orderItems) {
			InventoryItem item = inventoryItemRepository.findByItemIdAndStatusCd(orderItem.getItemId(),
					StatusCd.IN_STOCK.status());
			if (item == null) {
				String message = orderItem.getItemName() + "[Not found]";
				errors.add(message);
			} else if (item.getAvailableQuantity() == 0) {
				String message = orderItem.getItemName() + "[Out of stock]";
				errors.add(message);
			} else if (orderItem.getQuantity() > item.getAvailableQuantity()) {
				String message = orderItem.getItemName() + "[Only " + item.getAvailableQuantity() + " are in stock]";
				errors.add(message);
			} else {
				int remainingQuantity = item.getAvailableQuantity() - orderItem.getQuantity();
				item.setAvailableQuantity(remainingQuantity);
				bill = bill.add(item.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
				inventoryItemRepository.save(item);
			}
		}
		if (CollectionUtils.isNotEmpty(errors)) {
			StringBuilder errorMessage = new StringBuilder();
			errors.forEach(err -> errorMessage.append(err).append("\n"));
			throw new InventoryItemException(errorMessage.toString());
		}
		return bill;

	}

}
