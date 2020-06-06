package com.myekart.admin.user.service;

import com.myekart.admin.user.exception.UserException;
import com.myekart.messaging.admin.user.UserRequest;
import com.myekart.messaging.admin.user.UserResponse;

public interface UserService {

	UserResponse createUser(UserRequest request) throws UserException;

	UserResponse fetchUserDetails(String username) throws UserException;
}
