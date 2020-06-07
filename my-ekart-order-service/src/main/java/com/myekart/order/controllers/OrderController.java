package com.myekart.order.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myekart.messaging.order.OrderListResponse;
import com.myekart.messaging.order.OrderRequest;
import com.myekart.messaging.order.OrderResponse;
import com.myekart.order.exception.OrderException;
import com.myekart.order.service.OrderService;
import com.myekart.utilities.config.exception.ApplicationExceptionHandler;
import com.myekart.utilities.enums.OrderStatus;

@RestController
@RequestMapping("/orders")
public class OrderController extends ApplicationExceptionHandler {

	@Autowired
	private OrderService orderService;

	@PostMapping("/create")
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) throws OrderException {
		return new ResponseEntity<OrderResponse>(orderService.createOrder(request), HttpStatus.CREATED);
	}

	@GetMapping("/{user_id}/fetch-all-orders")
	public ResponseEntity<OrderListResponse> fetchAllOrders(@PathVariable("user_id") String userId) {
		return new ResponseEntity<OrderListResponse>(orderService.fetchAllOrders(userId), HttpStatus.OK);
	}

	@GetMapping("/{order_id}/order-status")
	public ResponseEntity<OrderResponse> checkOrderStatus(@PathVariable("order_id") String orderId)
			throws OrderException {
		return new ResponseEntity<OrderResponse>(orderService.checkOrderStatus(orderId), HttpStatus.OK);
	}

	@PatchMapping("/{order_id}/update-order-status")
	public ResponseEntity<OrderResponse> updateOrderStatus(@PathVariable("order_id") String orderId,
			@RequestParam("order_status") OrderStatus orderStatus) throws OrderException {
		return new ResponseEntity<OrderResponse>(orderService.updateOrderStatus(orderId, orderStatus), HttpStatus.OK);
	}
}
