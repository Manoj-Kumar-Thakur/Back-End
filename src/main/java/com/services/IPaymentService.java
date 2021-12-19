
package com.services;

import java.util.List;

import com.bean.Payment;
import com.exceptions.PaymentServiceException;
import com.model.PaymentDTO;




/*
 * Description : This is Payment Service Interface Layer that provides Interface services to Add New Payment details, Update Existing Payment details, 
 *               Delete Existing Payment details, Get Existing Payment details and Get All Existing Payment details
*/

public interface IPaymentService {

	public PaymentDTO addPayment(Payment payment) throws PaymentServiceException; 
	public PaymentDTO removePayment(long paymentId) throws PaymentServiceException;
	public PaymentDTO updatePayment(long paymentId ,Payment payment) throws PaymentServiceException;
	public PaymentDTO getPaymentDetails(long paymentId) throws PaymentServiceException;
	public List<PaymentDTO> getAllPaymentDetails() throws PaymentServiceException;

}

