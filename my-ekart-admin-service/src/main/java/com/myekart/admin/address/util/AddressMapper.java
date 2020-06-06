package com.myekart.admin.address.util;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myekart.admin.address.entity.Address;
import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.utilities.commons.MappingHelper;

@Component
public class AddressMapper implements MappingHelper<AddressRequest, Address> {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public Address requestToEntity(AddressRequest req) {
		return mapper.map(req, Address.class);
	}

	@Override
	public AddressRequest entityToRequest(Address entity) {
		return mapper.map(entity, AddressRequest.class);
	}

}
