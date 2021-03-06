package com.util;


import java.util.ArrayList;
import java.util.List;

import com.bean.Payment;
import com.model.PaymentDTO;

public class PaymentUtil {

	public static List<PaymentDTO> convertToPaymentDtoList(List<Payment> list) {
		List<PaymentDTO> paymentDtoList = new ArrayList<PaymentDTO>();
		for (Payment payment : list)
			paymentDtoList.add(convertToPaymentDto(payment));
		return paymentDtoList;
	}

	public static Payment convertToPayment(PaymentDTO paymentDto) {
		Payment payment = new Payment();

		payment.setPaymentId(paymentDto.getPaymentId());
		payment.setType(paymentDto.getType());
		payment.setStatus(paymentDto.getStatus());
		payment.setCard(paymentDto.getCard());

		return payment;
	}

	public static PaymentDTO convertToPaymentDto(Payment payment) {
		PaymentDTO paymentDto = new PaymentDTO();

		paymentDto.setPaymentId(payment.getPaymentId());
		paymentDto.setType(payment.getType());
		paymentDto.setStatus(payment.getStatus());
		paymentDto.setCard(payment.getCard());

		return paymentDto;
	}

}
