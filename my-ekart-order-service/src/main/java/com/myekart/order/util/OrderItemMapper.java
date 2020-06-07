package com.myekart.order.util;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myekart.messaging.order.OrderItemsRequest;
import com.myekart.order.entity.OrderedItems;
import com.myekart.utilities.commons.MappingHelper;

@Component
public class OrderItemMapper implements MappingHelper<OrderItemsRequest, OrderedItems> {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public OrderedItems requestToEntity(OrderItemsRequest req) {
		return mapper.map(req, OrderedItems.class);
	}

	@Override
	public OrderItemsRequest entityToRequest(OrderedItems entity) {
		return mapper.map(entity, OrderItemsRequest.class);
	}

}
