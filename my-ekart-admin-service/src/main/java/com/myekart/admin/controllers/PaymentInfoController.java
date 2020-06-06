package com.myekart.admin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myekart.admin.paymentInfo.exception.PaymentInfoException;
import com.myekart.admin.paymentInfo.service.PaymentInfoService;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoResponse;

@RestController
@RequestMapping("/users/{user_id}/payment-info")
public class PaymentInfoController {

	@Autowired
	private PaymentInfoService paymentInfoService;

	@PostMapping("/add")
	public ResponseEntity<PaymentInfoResponse> addNewPaymentInfo(@PathVariable("user_id") String userId,
			@RequestBody PaymentInfoRequest request) throws PaymentInfoException {
		request.setUserId(userId);
		return new ResponseEntity<>(paymentInfoService.addPaymentDetails(request), HttpStatus.CREATED);
	}

	@DeleteMapping("/{payment_info_id}/delete")
	public ResponseEntity<PaymentInfoResponse> deletePaymentInfo(@PathVariable("user_id") String userId,
			@PathVariable("payment_info_id") String paymentInfoId) throws PaymentInfoException {
		return new ResponseEntity<>(paymentInfoService.delete(userId, paymentInfoId), HttpStatus.OK);
	}
}
