package com.myekart.messaging.admin.paymentInfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myekart.utilities.config.feignclient.FeignClientConfig;

@FeignClient(name = "paymentInfoClient", url = "${service.admin}", configuration = FeignClientConfig.class, decode404 = false)
public interface PaymentInfoClient {

	@PostMapping("/users/{user_id}/payment-info/add")
	ResponseEntity<PaymentInfoResponse> addNewPaymentInfo(@PathVariable("user_id") String userId,
			@RequestBody PaymentInfoRequest request);

	@DeleteMapping("/users/{user_id}/payment-info/{payment_info_id}/delete")
	ResponseEntity<PaymentInfoResponse> deletePaymentInfo(@PathVariable("user_id") String userId,
			@PathVariable("payment_info_id") String paymentInfoId);

	@GetMapping("/users/{user_id}/payment-info/fetch-all-payment-info")
	ResponseEntity<PaymentInfoListResponse> fetchAllPaymentInfo(@PathVariable("user_id") String userId);

	@GetMapping("/users/{user_id}/payment-info/{payment_info_id}/fetch-payment-info")
	ResponseEntity<PaymentInfoResponse> fetchPaymentInfo(@PathVariable("user_id") String userId,
			@PathVariable("payment_info_id") String paymentInfoId);
}
