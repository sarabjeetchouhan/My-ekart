package com.myekart.admin.paymentInfo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myekart.admin.paymentInfo.entity.PaymentInfo;

@Repository
public interface PaymentInfoRepository extends PagingAndSortingRepository<PaymentInfo, Long> {

	PaymentInfo findByUserIdAndUpiId(String userId, String upiId);

	PaymentInfo findByUserIdAndCardNumber(String userId, String cardNumber);

	PaymentInfo findByUserIdAndPayeeAccountNumber(String userId, String payeeAccountNumber);

	PaymentInfo findByUserIdAndPaymentInfoIdAndStatusCd(String userId, String paymentInfoId, String statusCd);

}