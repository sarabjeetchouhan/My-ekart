package com.myekart.order.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myekart.order.entity.Orders;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Orders, Long> {

	List<Orders> findByUserId(String userId);

	Orders findByOrderId(String orderId);
}
