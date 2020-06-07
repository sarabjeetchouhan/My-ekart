package com.myekart.admin.address.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myekart.admin.address.entity.Address;
import com.myekart.admin.address.exception.AddressException;
import com.myekart.admin.address.repositories.AddressRepository;
import com.myekart.admin.address.util.AddressMapper;
import com.myekart.messaging.admin.address.AddressListResponse;
import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.messaging.admin.address.AddressResponse;
import com.myekart.utilities.commons.CommonUtils;
import com.myekart.utilities.config.exception.ResponseStatus;
import com.myekart.utilities.enums.StatusCd;

@Service("addressService")
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AddressMapper addressMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = AddressException.class)
	public AddressResponse addNewAddress(AddressRequest request) throws AddressException {
		AddressResponse response = new AddressResponse();
		Address address = addressMapper.requestToEntity(request);
		address.setAddressId(CommonUtils.generateId());
		address.setStatusCd(StatusCd.ACTIVE.status());
		Address save = addressRepository.save(address);
		response.setMessage(addressMapper.entityToRequest(save));
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		response.getStatus().setMessage("New address added successfully");
		return response;
	}

	@Override
	public AddressResponse deleteAddress(String userId, String addressId) throws AddressException {
		AddressResponse response = new AddressResponse();
		Address address = addressRepository.findByUserIdAndAddressIdAndStatusCd(userId, addressId,
				StatusCd.ACTIVE.status());
		if (address == null) {
			throw new AddressException("Address not found");
		}
		address.setStatusCd(StatusCd.DELETED.status());
		addressRepository.save(address);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		response.getStatus().setMessage("New address deleted successfully");
		return response;
	}

	@Override
	public AddressListResponse fetchAllAddressesForUser(String userId) {
		AddressListResponse response = new AddressListResponse();
		List<Address> addresses = addressRepository.findByUserIdAndStatusCd(userId, StatusCd.ACTIVE.status());
		if (CollectionUtils.isNotEmpty(addresses)) {
			response.setResults(
					addresses.stream().map(a -> addressMapper.entityToRequest(a)).collect(Collectors.toList()));
		} else {
			response.setResults(Collections.emptyList());
		}
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	@Override
	public AddressResponse fetchAddress(String userId, String addressId) throws AddressException {
		AddressResponse response = new AddressResponse();
		Address address = addressRepository.findByUserIdAndAddressIdAndStatusCd(userId, addressId,
				StatusCd.ACTIVE.status());
		if (address == null) {
			throw new AddressException("Address not found");
		}
		response.setMessage(addressMapper.entityToRequest(address));
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

}
