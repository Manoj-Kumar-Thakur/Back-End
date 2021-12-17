package com.capg.onlinesportsshopee.util;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Component;

import com.capg.onlinesportsshopee.bean.Order;
import com.capg.onlinesportsshopee.model.OrderDTO;
/*
 * Author      : JISHNA K
 * Version     : 1.0
 * Date        : 05-04-2021
 * Description : This is OrderUtil class
*/
@Component
public class OrderUtil {
	
	public static List<OrderDTO> convertToOrderDtoList(List<Order> list)
	{
		List<OrderDTO> OrderDtoList = new ArrayList<OrderDTO>();
		for (Order order : list)
			OrderDtoList.add(convertToOrderDto(order));
	    return OrderDtoList;
	}
	public static OrderDTO convertToOrderDto(Order order) {
		OrderDTO orderDto = new OrderDTO();
		
		orderDto.setOrderId(order.getOrderId());
		orderDto.setAmount(order.getAmount());
		orderDto.setBillingDate(order.getBillingDate());
		orderDto.setCustomer(order.getCustomer());
		orderDto.setProduct(order.getProduct());
		orderDto.setPayment(order.getPayment());

		
		return orderDto;
	}
	
	public static Order convertToorder(OrderDTO orderDto) {
		Order order = new Order();
		
		order.setOrderId(orderDto.getOrderId());
		order.setBillingDate(orderDto.getBillingDate());
		order.setAmount(orderDto.getAmount());
		order.setCustomer(orderDto.getCustomer());
		order.setProduct(orderDto.getProduct());
		order.setPayment(orderDto.getPayment());

		
		return order;
	}
	
	

}

