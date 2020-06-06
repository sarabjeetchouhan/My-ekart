package com.myekart.admin.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myekart.admin.user.entity.User;
import com.myekart.admin.user.exception.UserException;
import com.myekart.admin.user.repositories.UserRespository;
import com.myekart.admin.user.util.UserMapper;
import com.myekart.messaging.admin.user.UserConstant;
import com.myekart.messaging.admin.user.UserRequest;
import com.myekart.messaging.admin.user.UserResponse;
import com.myekart.utilities.commons.CommonUtils;
import com.myekart.utilities.config.exception.ResponseStatus;
import com.myekart.utilities.enums.StatusCd;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRespository;

	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = UserException.class)
	public UserResponse createUser(UserRequest request) throws UserException {
		UserResponse response = new UserResponse();
		validateUser(request.getUserName());
		User user = userMapper.requestToEntity(request);
		String userId = CommonUtils.generateId();
		user.setUserId(userId);
		user.setPassword(CommonUtils.encrypt(request.getPassword()));
		user.setStatusCd(StatusCd.ACTIVE.status());
		userRespository.save(user);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS, request.getFirstName() + " added successfully"));
		return response;
	}

	private void validateUser(String userName) throws UserException {
		User user = userRespository.findByUserName(userName);
		if (user != null) {
			throw new UserException(UserConstant.USER_ALREADY_EXIST);
		}
	}

	@Override
	public UserResponse fetchUserDetails(String username) throws UserException {
		UserResponse response = new UserResponse();
		User user = userRespository.findByUserName(username);
		if (user == null) {
			throw new UserException(UserConstant.USER_NOT_FOUND_WITH_USERNAME, username);
		}
		response.setMessage(userMapper.entityToRequest(user));
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

}
