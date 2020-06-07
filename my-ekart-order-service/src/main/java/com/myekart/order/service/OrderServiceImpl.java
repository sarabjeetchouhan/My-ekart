package com.myekart.order.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myekart.messaging.admin.address.AddressClient;
import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.messaging.admin.address.AddressResponse;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoClient;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoResponse;
import com.myekart.messaging.order.OrderItemsRequest;
import com.myekart.messaging.order.OrderListResponse;
import com.myekart.messaging.order.OrderRequest;
import com.myekart.messaging.order.OrderResponse;
import com.myekart.order.entity.Orders;
import com.myekart.order.entity.OrderedItems;
import com.myekart.order.exception.OrderException;
import com.myekart.order.repositories.OrderItemsRepository;
import com.myekart.order.repositories.OrderRepository;
import com.myekart.order.util.OrderItemMapper;
import com.myekart.order.util.OrderMapper;
import com.myekart.utilities.commons.CommonUtils;
import com.myekart.utilities.config.exception.ResponseStatus;
import com.myekart.utilities.enums.OrderStatus;
import com.myekart.utilities.enums.StatusCd;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderItemMapper orderItemMapper;

	@Autowired
	private AddressClient addressClient;

	@Autowired
	private PaymentInfoClient paymentInfoClient;

	@Autowired
	private OrderItemsRepository orderItemsRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = OrderException.class)
	public OrderResponse createOrder(OrderRequest request) throws OrderException {
		OrderResponse response = new OrderResponse();
		Orders orders = orderMapper.requestToEntity(request);
		orders.setOrderId(CommonUtils.generateId());
		orders.setStatusCd(OrderStatus.ORDER_PLACED.deliveryStatus());
		orders.setOrderDate(new Date());
		enhanceWithPaymentInfo(orders, request);
		enhanceWithAddressDetails(orders, request);
		orderRepository.save(orders);
		enhanceWithOrderItems(orders.getOrderId(), request.getOrderItems());
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS,
				"Order Placed successfully. Please note done order id :  " + orders.getOrderId()));
		return response;
	}

	private void enhanceWithOrderItems(String orderId, List<OrderItemsRequest> orderItems) {
		List<OrderedItems> items = orderItems.stream().map(item -> prepareOrderItem(item, orderId))
				.collect(Collectors.toList());
		orderItemsRepository.saveAll(items);
	}

	private OrderedItems prepareOrderItem(OrderItemsRequest item, String orderId) {
		OrderedItems orderItem = orderItemMapper.requestToEntity(item);
		orderItem.setOrderId(orderId);
		orderItem.setOrderItemId(CommonUtils.generateId());
		orderItem.setStatusCd(StatusCd.ACTIVE.status());
		return orderItem;
	}

	private void enhanceWithAddressDetails(Orders orders, OrderRequest request) throws OrderException {
		AddressRequest addressRequest = request.getAddress();
		if (addressRequest != null) {
			if (StringUtils.isNotEmpty(addressRequest.getAddressId())) {
				orders.setAddressId(addressRequest.getAddressId());
			} else {
				AddressResponse addressResponse = addressClient.addNewAddress(orders.getUserId(), addressRequest)
						.getBody();
				if (addressResponse != null && addressResponse.getMessage() != null) {
					orders.setAddressId(addressResponse.getMessage().getAddressId());
				}
			}

		} else {
			throw new OrderException("Address detail must not be empty");
		}

	}

	private void enhanceWithPaymentInfo(Orders orders, OrderRequest request) throws OrderException {
		PaymentInfoRequest paymentInfo = request.getPaymentInfo();
		if (paymentInfo != null) {
			if (StringUtils.isNotEmpty(paymentInfo.getPaymentInfoId())) {
				orders.setPaymentInfoId(paymentInfo.getPaymentInfoId());
				orders.setPaymentMode(paymentInfo.getPaymentMode());
			} else {
				PaymentInfoResponse response = paymentInfoClient.addNewPaymentInfo(orders.getUserId(), paymentInfo)
						.getBody();
				if (response != null && response.getMessage() != null) {
					orders.setPaymentInfoId(response.getMessage().getPaymentInfoId());
					orders.setPaymentMode(response.getMessage().getPaymentMode());
				}
			}
		} else {
			throw new OrderException("Payment information must not be empty");
		}

	}

	@Override
	public OrderListResponse fetchAllOrders(String userId) {
		OrderListResponse response = new OrderListResponse();
		List<Orders> orders = orderRepository.findByUserId(userId);
		if (CollectionUtils.isNotEmpty(orders)) {
			List<OrderRequest> results = orders.stream().map(o -> orderMapper.entityToRequest(o))
					.collect(Collectors.toList());
			Map<String, OrderRequest> orderMap = results.stream()
					.collect(Collectors.toMap(OrderRequest::getOrderId, o -> o));
			enhanceOrderListWithAddressDetailsAndPaymentInfo(orderMap, orders, userId);
			response.setResults(orderMap.values().stream().collect(Collectors.toList()));
		} else {
			response.setResults(Collections.emptyList());
		}
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	private void enhanceOrderListWithAddressDetailsAndPaymentInfo(Map<String, OrderRequest> orderMap,
			List<Orders> orders, String userId) {
		List<AddressRequest> addresses = addressClient.fetchAllAddressesForUser(userId).getBody().getResults();
		List<PaymentInfoRequest> paymentInfos = paymentInfoClient.fetchAllPaymentInfo(userId).getBody().getResults();
		Map<String, AddressRequest> addressMap = addresses.stream()
				.collect(Collectors.toMap(AddressRequest::getAddressId, a -> a));
		Map<String, PaymentInfoRequest> paymentInfoMap = paymentInfos.stream()
				.collect(Collectors.toMap(PaymentInfoRequest::getPaymentInfoId, p -> p));
		orders.forEach(o -> {
			AddressRequest addressRequest = addressMap.get(o.getAddressId());
			PaymentInfoRequest paymentInfoRequest = paymentInfoMap.get(o.getPaymentInfoId());
			orderMap.get(o.getOrderId()).setAddress(addressRequest);
			orderMap.get(o.getOrderId()).setPaymentInfo(paymentInfoRequest);
		});

	}

	@Override
	public OrderResponse checkOrderStatus(String orderId) throws OrderException {
		OrderResponse response = new OrderResponse();
		Orders orders = orderRepository.findByOrderId(orderId);
		if (orders == null) {
			throw new OrderException("Order not found with id: " + orderId);
		}
		OrderRequest orderRequest = orderMapper.entityToRequest(orders);
		enhanceOrderWithAddressAndPaymentInfo(orderRequest, orders.getAddressId(), orders.getPaymentInfoId());
		response.setMessage(orderRequest);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	private void enhanceOrderWithAddressAndPaymentInfo(OrderRequest orderRequest, String addressId,
			String paymentInfoId) {
		AddressRequest addressRequest = addressClient.fetchAddress(orderRequest.getUserId(), addressId).getBody()
				.getMessage();
		PaymentInfoRequest paymentInfoRequest = paymentInfoClient
				.fetchPaymentInfo(orderRequest.getUserId(), paymentInfoId).getBody().getMessage();
		orderRequest.setAddress(addressRequest);
		orderRequest.setPaymentInfo(paymentInfoRequest);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = OrderException.class)
	public OrderResponse updateOrderStatus(String orderId, OrderStatus orderStatus) throws OrderException {
		OrderResponse response = new OrderResponse();
		Orders order = orderRepository.findByOrderId(orderId);
		if (order == null) {
			throw new OrderException("Order not found with id: " + orderId);
		}
		order.setStatusCd(orderStatus.deliveryStatus());
		orderRepository.save(order);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS, "Order updated successfully"));
		return response;
	}

}
