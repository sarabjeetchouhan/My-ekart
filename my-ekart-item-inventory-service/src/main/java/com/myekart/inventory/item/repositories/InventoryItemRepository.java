package com.myekart.inventory.item.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myekart.inventory.item.entity.InventoryItem;

@Repository("inventoryItemRepository")
public interface InventoryItemRepository
		extends PagingAndSortingRepository<InventoryItem, Long>, JpaSpecificationExecutor<InventoryItem> {

}
