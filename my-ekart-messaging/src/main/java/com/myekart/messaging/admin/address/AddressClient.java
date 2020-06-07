package com.myekart.messaging.admin.address;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myekart.utilities.config.feignclient.FeignClientConfig;

@FeignClient(value = "addressClient", url = "${service.admin}" , configuration = FeignClientConfig.class, decode404 = false)
public interface AddressClient {

	@PostMapping("/users/{user_id}/address/add")
	ResponseEntity<AddressResponse> addNewAddress(@PathVariable("user_id") String userId,
			@RequestBody AddressRequest request);

	@DeleteMapping("/users/{user_id}/address/{address_id}/delete")
	ResponseEntity<AddressResponse> deleteAddress(@PathVariable("user_id") String userId,
			@PathVariable("address_id") String addressId);

	@GetMapping("/users/{user_id}/address/fetch-all-address")
	ResponseEntity<AddressListResponse> fetchAllAddressesForUser(@PathVariable("user_id") String userId);

	@GetMapping("/users/{user_id}/address/{address_id}/fetch-address")
	ResponseEntity<AddressResponse> fetchAddress(@PathVariable("user_id") String userId,
			@PathVariable("address_id") String addressId);
}
