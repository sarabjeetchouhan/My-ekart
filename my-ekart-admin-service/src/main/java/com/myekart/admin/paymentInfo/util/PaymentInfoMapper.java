package com.myekart.admin.paymentInfo.util;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myekart.admin.paymentInfo.entity.PaymentInfo;
import com.myekart.messaging.admin.paymentInfo.PaymentInfoRequest;
import com.myekart.utilities.commons.MappingHelper;

@Component
public class PaymentInfoMapper implements MappingHelper<PaymentInfoRequest, PaymentInfo> {

	@Autowired
	private DozerBeanMapper mapper;

	@Override
	public PaymentInfo requestToEntity(PaymentInfoRequest req) {
		return mapper.map(req, PaymentInfo.class);
	}

	@Override
	public PaymentInfoRequest entityToRequest(PaymentInfo entity) {
		return mapper.map(entity, PaymentInfoRequest.class);
	}

}
