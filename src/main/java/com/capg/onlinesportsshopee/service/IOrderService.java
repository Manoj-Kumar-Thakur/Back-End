package com.capg.onlinesportsshopee.service;

import java.util.List;


import com.capg.onlinesportsshopee.bean.Order;
import com.capg.onlinesportsshopee.model.OrderDTO;

/*
 * Author      : JISHNA k
 * Version     : 1.0
 * Date        : 05-04-2021
 * Description : This is OrderService Interface
*/
public interface IOrderService {
	public OrderDTO addOrder(Order order);
	public OrderDTO removeOrder(long id);
	public OrderDTO  updateOrder(long id, Order order);
	public OrderDTO  getOrderDetails(long id);
	public List<OrderDTO> getAllOrders(); 

}
