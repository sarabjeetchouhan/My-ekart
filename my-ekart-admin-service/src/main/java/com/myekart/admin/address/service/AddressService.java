package com.myekart.admin.address.service;

import com.myekart.admin.address.exception.AddressException;
import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.messaging.admin.address.AddressResponse;

public interface AddressService {

	AddressResponse addNewAddress(AddressRequest request) throws AddressException;

	AddressResponse deleteAddress(String userId, String addressId) throws AddressException;

}
