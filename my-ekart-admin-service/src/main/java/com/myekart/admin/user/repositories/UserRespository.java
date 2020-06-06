package com.myekart.admin.user.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myekart.admin.user.entity.User;

@Repository
public interface UserRespository extends PagingAndSortingRepository<User, Long> {

	User findByUserName(String username);
}
