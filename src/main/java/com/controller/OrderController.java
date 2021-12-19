
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

import com.bean.Order;
import com.exceptions.OrderServiceException;
import com.model.OrderDTO;
import com.services.IOrderService;

@RestController
@RequestMapping("/api/oss")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	final Logger LOGGER =	LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/addOrder")
	public ResponseEntity<OrderDTO> addOrder(@RequestBody Order order) 
	{   LOGGER.info("Add order details executed");
		OrderDTO resultorder = orderService.addOrder(order);
		return new ResponseEntity<OrderDTO>(resultorder, HttpStatus.OK);

	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDTO> updateOrder(@RequestBody Order order) {
		LOGGER.info("update order details executed");
		OrderDTO updateOrder = orderService.updateOrder(order.getOrderId(), order);
		return new ResponseEntity<OrderDTO>(updateOrder, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/removeOrder/{orderId}")
	public ResponseEntity<OrderDTO> removePayment(@PathVariable long orderId)
		{
		    LOGGER.info("remove order details executed");
			OrderDTO removeOrder = orderService.removeOrder(orderId);
			return new ResponseEntity<OrderDTO>(removeOrder,HttpStatus.OK);
		}
	
	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<OrderDTO> GetOrderDetails(@PathVariable long orderId) throws OrderServiceException {
		LOGGER.info("get order details by Id executed");
		OrderDTO getByOrderId = orderService.getOrderDetails(orderId);
		return new ResponseEntity<OrderDTO>(getByOrderId, HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrder")
	public ResponseEntity<List<OrderDTO>> getAllOrders() {
		LOGGER.info("Get all order details executed");
		List<OrderDTO> getAllOrder = orderService.getAllOrders();
		return new ResponseEntity<List<OrderDTO>>(getAllOrder, HttpStatus.OK);
	}

}