package com.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Payment;
import com.exceptions.PaymentServiceException;
import com.model.PaymentDTO;
import com.repo.IPaymentRepository;
import com.util.PaymentUtil;

/*
 * Description : This is Payment Service Layer that provides services to Add New Payment details, Update Existing Payment details, 
 *               Delete Existing Payment details, Get Existing Payment details and Get All Existing Payment details
*/

@Service
public class PaymentServiceImpl implements IPaymentService {

	@Autowired
	private IPaymentRepository paymentRepository;

	/*
	 * Description : This method adds Payment Details
	 * Input Parameter : Payment Object 
	 * Return Value : PaymentDTO Object 
	 * Exception : PaymentServiceException
	 */
	
	@Override
	public PaymentDTO addPayment(Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(payment.getPaymentId());
		if (paymentTemp.isEmpty() )
		{
				Payment addPayment = paymentRepository.save(payment);
				return PaymentUtil.convertToPaymentDto(addPayment);
			}
			else
			{
				throw new PaymentServiceException("Payment detials Already Exist");
			}
	}

	/*
	 * Description : This method remove existing Payment Details
	 * Input Parameter : Payment Object 
	 * Return Value : PaymentDTO Object 
	 * Exception : PaymentServiceException
	 */
	
	@Override
	public PaymentDTO removePayment(long paymentId) throws PaymentServiceException {
		Optional<Payment> payment = paymentRepository.findById(paymentId);
		if (payment.isEmpty()) 
		{
			throw new PaymentServiceException("Payment does not exist for paymentId to delete");
		} 
		else 
		{
			paymentRepository.deleteById(paymentId);
			if(payment.isPresent())
			{
				return PaymentUtil.convertToPaymentDto(payment.get());
			}
			else
			{
				throw new PaymentServiceException("Payment is not present ");
			}
		}
	}

	/*
	 * Description : This method update existing Payment Details
	 * Input Parameter : Payment Object and long PaymentID 
	 * Return Value : PaymentDTO Object 
	 * Exception : PaymentServiceException
	 */
	
	@Override
	public PaymentDTO updatePayment(long paymentId, Payment payment) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if ( !paymentTemp.isEmpty() )
		{
				Payment updatePayment = paymentRepository.save(payment);
				return PaymentUtil.convertToPaymentDto(updatePayment);
			}
			else
			{
				throw new PaymentServiceException("Enter payment detials does not exist");
			}
	}

	/*
	 * Description : This method get existing Payment Details
	 * Input Parameter : long PaymentID
	 * Return Value : PaymentDTO Object 
	 * Exception : PaymentServiceException
	 */
	
	@Override
	public PaymentDTO getPaymentDetails(long paymentId) throws PaymentServiceException {
		Optional<Payment> paymentTemp = paymentRepository.findById(paymentId);
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payment does not exist for paymentId");
		} 
		else 
		{
			Payment getPayment = paymentRepository.findById(paymentId).orElse(null);
			return PaymentUtil.convertToPaymentDto(getPayment);
		}
	}

	/*
	 * Description : This method get existing Payment Details
	 * Return Value : PaymentDTO Object list
	 * Exception : PaymentServiceException
	 */
	
	@Override
	public List<PaymentDTO> getAllPaymentDetails() throws PaymentServiceException {
		List<Payment> paymentTemp = paymentRepository.findAll();
		if (paymentTemp.isEmpty()) {
			throw new PaymentServiceException("Payments not found");
		} 
		else 
		{
			List<Payment> getAllPayment = paymentRepository.findAll();
			return PaymentUtil.convertToPaymentDtoList(getAllPayment);
		}
	}

	/*
	 * Description : This method validate payment type
	 * Input Parameter :  Payment Object
	 * Return Value : boolean 
	 * Exception : PaymentServiceException
	 */
	public  boolean validatePaymentType(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$"); 
		CharSequence cs= payment.getType();
		if (pattern.matcher(cs).matches() && !payment.getType().isBlank()) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

	/*
	 * Description : This method validate Payment Status
	 * Input Parameter :  Payment Object
	 * Return Value : boolean 
	 * Exception : PaymentServiceException
	 */
	public  boolean validatePaymentStatus(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[A-Za-z]*$");
		CharSequence cs= payment.getStatus();
		if (pattern.matcher(cs).matches() && !payment.getStatus().isBlank()) {
			flag = true;
		} 
		else
		{
			flag = false;
		}
		return flag;
	}

	/*
	 * Description : This method validate Card Name
	 * Input Parameter :  Payment Object
	 * Return Value : boolean 
	 * Exception : PaymentServiceException
	 */
	public  boolean validateCardName(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[a-zA-Z ]*$");
		CharSequence cs= payment.getCard().getCardName();
		if (pattern.matcher(cs).matches() && !payment.getCard().getCardName().isBlank()) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

	/*
	 * Description : This method validate Card Name
	 * Input Parameter :  Payment Object
	 * Return Value : boolean 
	 * Exception : PaymentServiceException
	 */
	public  boolean validateCardNumber(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]*$");
		CharSequence cs= payment.getCard().getCardNumber();
		if ((pattern.matcher(cs).matches()) && payment.getCard().getCardNumber().length() == 16 ) 
		{
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

	/*
	 * Description : This method validate Card Number
	 * Input Parameter :  Payment Object
	 * Return Value : boolean 
	 * Exception : PaymentServiceException
	 */
	public boolean validateCvv(Payment payment) {
		boolean flag = false;
		Pattern pattern = Pattern.compile("^[0-9]{3}$");
		String stringCvv = String.valueOf(payment.getCard().getCvv());
		CharSequence cs= stringCvv ;
		if ((pattern.matcher(cs).matches())) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;

	}

	/*
	 * Description : This method validate Card Expiry
	 * Input Parameter :  Payment Object
	 * Return Value : boolean 
	 * Exception : PaymentServiceException
	 */
	public  boolean validateCardExpiry(Payment payment) {
		boolean flag = false;
		if (payment.getCard().getCardExpiry() != null && payment.getCard().getCardExpiry().isAfter(LocalDate.now())) {
			flag = true;
		} 
		else 
		{
			flag = false;
		}
		return flag;
	}

}
