package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Payment;
import com.exceptions.PaymentServiceException;
import com.model.PaymentDTO;
import com.services.IPaymentService;

@RestController
@RequestMapping("/api/oss")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	
	@Autowired
	private IPaymentService paymentService;
	
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/addPayment")
	public ResponseEntity<PaymentDTO> addPayment(@RequestBody Payment payment) {
		LOGGER.info("Add Payment Details executed");
		PaymentDTO addPayment = paymentService.addPayment(payment);
		return new ResponseEntity<PaymentDTO>(addPayment, HttpStatus.OK);
	}
	
	@DeleteMapping("/removePayment/{paymentId}")
	public ResponseEntity<PaymentDTO> removePayment(@PathVariable long paymentId)
	{
		LOGGER.info("Remove Payment Details  executed");
		PaymentDTO removePayment = paymentService.removePayment(paymentId);
		return new ResponseEntity<PaymentDTO>(removePayment,HttpStatus.OK);
	}
	
	@PutMapping("/updatePayment/{paymentId}")
	public ResponseEntity<PaymentDTO> updatePayment(@PathVariable long paymentId,@RequestBody Payment payment) {
		LOGGER.info("Update Payment Details executed");
		PaymentDTO updatePayment = paymentService.updatePayment(paymentId, payment);
		return new ResponseEntity<PaymentDTO>(updatePayment, HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentById/{paymentId}")
	public ResponseEntity<PaymentDTO> GetPaymentDetails(@PathVariable long paymentId) throws PaymentServiceException {
		LOGGER.info("Get Payment Details By Id executed");
		PaymentDTO getByPaymentId = paymentService.getPaymentDetails(paymentId);
		return new ResponseEntity<PaymentDTO>(getByPaymentId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllPayment")
	public ResponseEntity<List<PaymentDTO>> getAllPayment() {
		LOGGER.info("Get ALL Payment Details executed");
		List<PaymentDTO> getAllPayment = paymentService.getAllPaymentDetails();
		return new ResponseEntity<List<PaymentDTO>>(getAllPayment, HttpStatus.OK);
	}
	

}
