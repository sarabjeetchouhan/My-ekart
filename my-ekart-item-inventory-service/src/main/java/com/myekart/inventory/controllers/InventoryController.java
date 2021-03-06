package com.myekart.inventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myekart.inventory.item.exception.InventoryItemException;
import com.myekart.inventory.item.service.InventoryItemService;
import com.myekart.messaging.inventory.InventoryItemFilterRequest;
import com.myekart.messaging.inventory.InventoryItemRequest;
import com.myekart.messaging.inventory.InventoryListResponse;
import com.myekart.messaging.inventory.InventoryResponse;
import com.myekart.messaging.order.OrderRequest;
import com.myekart.messaging.order.OrderResponse;
import com.myekart.utilities.config.exception.ApplicationExceptionHandler;

@RestController
@RequestMapping("/inventory")
public class InventoryController extends ApplicationExceptionHandler {

	@Autowired
	private InventoryItemService inventoryItemService;

	@PostMapping("/add")
	public ResponseEntity<InventoryResponse> addItem(@RequestBody InventoryItemRequest request)
			throws InventoryItemException {
		return new ResponseEntity<InventoryResponse>(inventoryItemService.addItem(request), HttpStatus.CREATED);
	}

	@PostMapping("/filter")
	public ResponseEntity<InventoryListResponse> filterItems(@RequestBody InventoryItemFilterRequest request)
			throws InventoryItemException {
		return new ResponseEntity<>(inventoryItemService.fetchItemFilter(request), HttpStatus.OK);
	}

	@PostMapping("/validate-order")
	public ResponseEntity<OrderResponse> validateOrder(@RequestBody OrderRequest request)
			throws InventoryItemException {
		return new ResponseEntity<OrderResponse>(inventoryItemService.validateOrder(request), HttpStatus.CREATED);
	}

}
