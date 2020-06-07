package com.myekart.order.service;

import com.myekart.messaging.order.OrderListResponse;
import com.myekart.messaging.order.OrderRequest;
import com.myekart.messaging.order.OrderResponse;
import com.myekart.order.exception.OrderException;
import com.myekart.utilities.enums.OrderStatus;

public interface OrderService {

	OrderResponse createOrder(OrderRequest request) throws OrderException;

	OrderListResponse fetchAllOrders(String userId);

	OrderResponse checkOrderStatus(String orderId) throws OrderException;

	OrderResponse updateOrderStatus(String orderId, OrderStatus orderStatus) throws OrderException;
}
