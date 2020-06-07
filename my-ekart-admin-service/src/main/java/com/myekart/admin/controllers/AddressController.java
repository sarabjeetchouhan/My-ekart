package com.myekart.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myekart.admin.address.exception.AddressException;
import com.myekart.admin.address.service.AddressService;
import com.myekart.messaging.admin.address.AddressListResponse;
import com.myekart.messaging.admin.address.AddressRequest;
import com.myekart.messaging.admin.address.AddressResponse;
import com.myekart.utilities.config.exception.ApplicationExceptionHandler;

@RestController
@RequestMapping("/users/{user_id}/address")
public class AddressController extends ApplicationExceptionHandler {

	@Autowired
	private AddressService addressService;

	@PostMapping("/add")
	public ResponseEntity<AddressResponse> addNewAddress(@PathVariable("user_id") String userId,
			@RequestBody AddressRequest request) throws AddressException {
		request.setUserId(userId);
		return new ResponseEntity<AddressResponse>(addressService.addNewAddress(request), HttpStatus.CREATED);
	}

	@DeleteMapping("/{address_id}/delete")
	public ResponseEntity<AddressResponse> deleteAddress(@PathVariable("user_id") String userId,
			@PathVariable("address_id") String addressId) throws AddressException {
		return new ResponseEntity<AddressResponse>(addressService.deleteAddress(userId, addressId), HttpStatus.OK);
	}

	@GetMapping("/fetch-all-address")
	public ResponseEntity<AddressListResponse> fetchAllAddressesForUser(@PathVariable("user_id") String userId) {
		return new ResponseEntity<AddressListResponse>(addressService.fetchAllAddressesForUser(userId), HttpStatus.OK);
	}

	@GetMapping("/{address_id}/fetch-address")
	public ResponseEntity<AddressResponse> fetchAddress(@PathVariable("user_id") String userId,
			@PathVariable("address_id") String addressId) throws AddressException {
		return new ResponseEntity<AddressResponse>(addressService.fetchAddress(userId, addressId), HttpStatus.OK);
	}
}
