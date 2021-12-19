package com.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Order;
import com.exceptions.OrderServiceException;
import com.model.OrderDTO;
import com.repo.IOrderRepository;
import com.util.CustomerUtil;
import com.util.OrderUtil;
import com.util.PaymentUtil;
import com.util.ProductUtil;

/*
 * Description : This is Order Service Layer that provides services to Add New Order details, Update Existing Order details, 
 *               Delete Existing Order details, Get Existing Order details and Get All Existing Order details
*/
@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private CustomerServiceImpl customerRepo;
	
	@Autowired
	private ProductServiceImpl productRepo;
	
	@Autowired
	private PaymentServiceImpl paymentRepo;
	

	   /*
     * Description    :This method adds Order Details
     * Input Parameter:Order Object
     * Return value   :OrderDTO object
     * Exception      :OrderServiceException
     */
	@Override
	public OrderDTO addOrder(Order order)throws OrderServiceException 
	{
		Optional<Order> addOrdertemp = orderRepo.findById(order.getOrderId());
		if (addOrdertemp.isEmpty()){
			Order addOrder = orderRepo.save(order);
			Order order1= new Order(addOrder.getOrderId(),addOrder.getAmount(),addOrder.getBillingDate(),CustomerUtil.convertToCustomer(customerRepo.getCustomer(addOrder.getCustomer().getUserId())),
					ProductUtil.convertToProduct(productRepo.getProduct(addOrder.getProduct().getProductId())),PaymentUtil.convertToPayment(paymentRepo.getPaymentDetails(addOrder.getPayment().getPaymentId())));
			return OrderUtil.convertToOrderDto(order1);
		}
		else
		{
			
			throw new OrderServiceException("Order already exists");
		}
		
	}
	/*
     * Description    :This method removes Order Details
     * Input Parameter:Order Object
     * Return value   :OrderDTO object
     * Exception      :OrderServiceException
     */
	@Override
	public OrderDTO removeOrder(long orderId) throws OrderServiceException {
		Optional<Order> order = orderRepo.findById(orderId);
		if (order.isEmpty()) {
			throw new OrderServiceException("OrderId does not exist to delete");
		} 
		else {
			orderRepo.deleteById(orderId);
			if(order.isPresent())
			{
				return OrderUtil.convertToOrderDto(order.get());
			}
			else
			{
				throw new OrderServiceException("Order is not present");
			}
			
		}
	}
	
	 /*
     * Description    :This method update Order Details
     * Input Parameter:Order Object
     * Return value   :OrderDTO object
     * Exception      :OrderServiceException
     */
	@Override
	public OrderDTO updateOrder(long orderId, Order order) throws OrderServiceException {
		if (order == null)
			return  null;
		Order order1 = orderRepo.findById(order.getOrderId()).orElse(null);
		if (order1 == null) {
			throw new OrderServiceException("OrderId not found");
		}
        else {
			return OrderUtil.convertToOrderDto(orderRepo.save(order));
		}
	}
		
	
	 /*
     * Description    :This method gets Order Details
     * Input Parameter:OrderID
     * Return value   :OrderDTO object
     * Exception      :OrderServiceException
     */
	@Override
	public OrderDTO getOrderDetails(long orderId)throws OrderServiceException {
		Optional<Order> orderTemp = orderRepo.findById(orderId);
		if (orderTemp.isEmpty()) {
			throw new OrderServiceException("OrderId does not exist");
		} 
		else {
			Order getOrder = orderRepo.findById(orderId).orElse(null);
			return OrderUtil.convertToOrderDto(getOrder);
		}
	}
		
	 /*
     * Description    :This method gets all Order Details
     * Input Parameter:Order Object
     * Return value   :OrderDTO object
     * Exception      :OrderServiceException
     */
	@Override
	public List<OrderDTO> getAllOrders() throws OrderServiceException {
		List<Order> orderTemp = orderRepo.findAll();
		if (orderTemp.isEmpty()) {
			throw new OrderServiceException("Order not found");
		} 
		else {
			List<Order> getAllOrders = orderRepo.findAll();
			return OrderUtil.convertToOrderDtoList(getAllOrders);
		}
	}
		
		
	public static boolean validateOrderId(Order order) {
		boolean flag = true;
		Long orderId = order.getOrderId();
		OrderServiceImpl service = new OrderServiceImpl();
		if (orderId == null|| orderId < 0 || !service.orderRepo.existsById(orderId))
			flag = false;
		return flag;
	}
		
		
		
}