package com.myekart.inventory.item.service;

import com.myekart.inventory.item.exception.InventoryItemException;
import com.myekart.messaging.inventory.InventoryItemFilterRequest;
import com.myekart.messaging.inventory.InventoryItemRequest;
import com.myekart.messaging.inventory.InventoryListResponse;
import com.myekart.messaging.inventory.InventoryResponse;
import com.myekart.messaging.order.OrderRequest;
import com.myekart.messaging.order.OrderResponse;

public interface InventoryItemService {

	InventoryResponse addItem(InventoryItemRequest request) throws InventoryItemException;

	InventoryListResponse fetchItemFilter(InventoryItemFilterRequest filterRequest) throws InventoryItemException;

	OrderResponse validateOrder(OrderRequest request) throws InventoryItemException;

}
