package com.myekart.admin.paymentInfo.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myekart.admin.paymentInfo.entity.PaymentInfo;
import com.myekart.admin.paymentInfo.exception.PaymentInfoException;
import com.myekart.admin.paymentInfo.repository.PaymentInfoRepository;
import com.myekart.admin.paymentInfo.util.PaymentInfoMapper;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoListResponse;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoResponse;
import com.myekart.utilities.commons.CommonUtils;
import com.myekart.utilities.config.exception.ResponseStatus;
import com.myekart.utilities.enums.PaymentMode;
import com.myekart.utilities.enums.StatusCd;

@Service("SavedPaymentDetailsService")
public class PaymentInfoServiceImpl implements PaymentInfoService {

	@Autowired
	private PaymentInfoRepository paymentInfoRepository;

	@Autowired
	private PaymentInfoMapper paymentInfoMapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, rollbackFor = PaymentInfoException.class)
	public PaymentInfoResponse addPaymentDetails(PaymentInfoRequest request) throws PaymentInfoException {
		PaymentInfoResponse response = new PaymentInfoResponse();
		if (!isExist(request)) {
			PaymentInfo paymentInfo = paymentInfoMapper.requestToEntity(request);
			paymentInfo.setPaymentInfoId(CommonUtils.generateId());
			paymentInfo.setStatusCd(StatusCd.ACTIVE.status());
			PaymentInfo save = paymentInfoRepository.save(paymentInfo);
			response.setMessage(paymentInfoMapper.entityToRequest(save));
		}
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	private boolean isExist(PaymentInfoRequest request) {
		if (PaymentMode.UPI.channel() == request.getPaymentMode()) {
			return paymentInfoRepository.findByUserIdAndUpiId(request.getUserId(), request.getUpiId()) != null;
		} else if (PaymentMode.CARD.channel() == request.getPaymentMode()) {
			return paymentInfoRepository.findByUserIdAndCardNumber(request.getUserId(),
					request.getCardNumber()) != null;
		} else if (PaymentMode.ACCOUNT_TRANSFER.channel() == request.getPaymentMode()) {
			return paymentInfoRepository.findByUserIdAndPayeeAccountNumber(request.getUserId(),
					request.getPayeeAccountNumber()) != null;
		}
		return false;
	}

	@Override
	public PaymentInfoResponse delete(String userId, String paymentInfoId) throws PaymentInfoException {
		PaymentInfoResponse response = new PaymentInfoResponse();
		PaymentInfo paymentInfo = paymentInfoRepository.findByUserIdAndPaymentInfoIdAndStatusCd(userId, paymentInfoId,
				StatusCd.ACTIVE.status());
		if (paymentInfo == null) {
			throw new PaymentInfoException("Payment information not found");
		}
		paymentInfo.setStatusCd(StatusCd.DELETED.status());
		paymentInfoRepository.save(paymentInfo);
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		response.getStatus().setMessage("Payment information deleted successfully");
		return response;
	}

	@Override
	public PaymentInfoListResponse fetchAllPaymentInfo(String userId) {
		PaymentInfoListResponse response = new PaymentInfoListResponse();
		List<PaymentInfo> paymentInfos = paymentInfoRepository.findByUserIdAndStatusCd(userId,
				StatusCd.ACTIVE.status());
		if (CollectionUtils.isNotEmpty(paymentInfos)) {
			response.setResults(
					paymentInfos.stream().map(p -> paymentInfoMapper.entityToRequest(p)).collect(Collectors.toList()));
		} else {
			response.setResults(Collections.emptyList());
		}
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

	@Override
	public PaymentInfoResponse fetchPaymentInfo(String userId, String paymentInfoId) throws PaymentInfoException {
		PaymentInfoResponse response = new PaymentInfoResponse();
		PaymentInfo paymentInfo = paymentInfoRepository.findByUserIdAndPaymentInfoIdAndStatusCd(userId, paymentInfoId,
				StatusCd.ACTIVE.status());
		if (paymentInfo == null) {
			throw new PaymentInfoException("Payment information not found");
		}
		response.setMessage(paymentInfoMapper.entityToRequest(paymentInfo));
		response.setStatus(new ResponseStatus(ResponseStatus.SUCCESS));
		return response;
	}

}
