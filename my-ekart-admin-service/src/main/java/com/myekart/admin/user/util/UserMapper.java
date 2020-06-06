package com.myekart.admin.user.util;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myekart.admin.user.entity.User;
import com.myekart.messaging.admin.user.UserRequest;
import com.myekart.utilities.commons.MappingHelper;

@Component
public class UserMapper implements MappingHelper<UserRequest, User> {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public User requestToEntity(UserRequest req) {
		return mapper.map(req, User.class);
	}

	@Override
	public UserRequest entityToRequest(User user) {
		return mapper.map(user, UserRequest.class);
	}

}
