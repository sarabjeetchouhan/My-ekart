package com.myekart.order.util;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myekart.messaging.order.OrderRequest;
import com.myekart.order.entity.Orders;
import com.myekart.utilities.commons.MappingHelper;

@Component
public class OrderMapper implements MappingHelper<OrderRequest, Orders> {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public Orders requestToEntity(OrderRequest req) {
		return mapper.map(req, Orders.class);
	}

	@Override
	public OrderRequest entityToRequest(Orders entity) {
		return mapper.map(entity, OrderRequest.class);
	}

}
