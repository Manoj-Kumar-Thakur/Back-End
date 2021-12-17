package com.capg.onlinesportsshopee.util;

/*
 * Author : SYED SAMSUDEEN A

 * Version : 1.0
 * Date : 04-04-2021
 * Description : This is Payment Util
*/
import java.util.ArrayList;
import java.util.List;

import com.capg.onlinesportsshopee.bean.Payment;
import com.capg.onlinesportsshopee.model.PaymentDTO;

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
