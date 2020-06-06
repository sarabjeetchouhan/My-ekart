package com.myekart.inventory.item.util;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myekart.inventory.item.entity.InventoryItem;
import com.myekart.messaging.inventory.InventoryItemRequest;
import com.myekart.utilities.commons.MappingHelper;

@Component
public class InventoryItemMapper implements MappingHelper<InventoryItemRequest, InventoryItem> {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public InventoryItem requestToEntity(InventoryItemRequest req) {
		return mapper.map(req, InventoryItem.class);
	}

	@Override
	public InventoryItemRequest entityToRequest(InventoryItem entity) {
		return mapper.map(entity, InventoryItemRequest.class);
	}
}
