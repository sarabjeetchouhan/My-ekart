package com.myekart.order.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myekart.order.entity.OrderedItems;

@Repository
public interface OrderItemsRepository extends PagingAndSortingRepository<OrderedItems, Long> {

}
