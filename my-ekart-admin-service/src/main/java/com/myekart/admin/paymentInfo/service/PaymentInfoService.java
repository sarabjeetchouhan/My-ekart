package com.myekart.admin.paymentInfo.service;

import com.myekart.admin.paymentInfo.exception.PaymentInfoException;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoListResponse;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoResponse;

public interface PaymentInfoService {

	PaymentInfoResponse addPaymentDetails(PaymentInfoRequest request) throws PaymentInfoException;

	PaymentInfoResponse delete(String userId, String paymentInfoId) throws PaymentInfoException;

	PaymentInfoListResponse fetchAllPaymentInfo(String userId);

	PaymentInfoResponse fetchPaymentInfo(String userId, String paymentInfoId) throws PaymentInfoException;
}
