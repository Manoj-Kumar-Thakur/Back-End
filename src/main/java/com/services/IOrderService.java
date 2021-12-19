package com.services;

import java.util.List;

import com.bean.Order;
import com.model.OrderDTO;


public interface IOrderService {
	public OrderDTO addOrder(Order order);
	public OrderDTO removeOrder(long id);
	public OrderDTO  updateOrder(long id, Order order);
	public OrderDTO  getOrderDetails(long id);
	public List<OrderDTO> getAllOrders(); 

}
