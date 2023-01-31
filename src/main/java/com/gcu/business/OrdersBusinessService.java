package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.OrdersDataService;
import com.gcu.data.entity.OrderEntity;
import com.gcu.model.OrderModel;

// to access the interface module the interface must be "implemented"
// by another class with the implements keyword.
// the body of the interface method is provided by the implement class:
// the implement keyword is used by a class so that it can follow or adhere
// to the contract provided by the interface.
public class OrdersBusinessService implements OrdersBusinessServiceInterface
{
	@Autowired
	private OrdersDataService service;
	
	@Override
	public void init() 
	{
		System.out.println("In OrdersBusinessService.init()");
	}
	
	@Override
	public void destroy() 
	{
		System.out.println("In OrdersBusinessService.destroy()");
	}

	@Override
	public void test() 
	{
		System.out.println("Hello from the OrdersBusinessService");
	}
	
	@Override
	public List<OrderModel> getOrders()
	{
		
//		List<OrderModel> orders = new ArrayList<OrderModel>(); orders.add(new
//		OrderModel(0L, "0000000001", "Product 1", 1.00f, 1)); orders.add(new
//		OrderModel(1L, "0000000002", "Product 2", 1.00f, 1)); orders.add(new
//		OrderModel(2L, "0000000003", "Product 3", 1.00f, 1)); orders.add(new
//		OrderModel(3L, "0000000004", "Product 4", 1.00f, 1)); orders.add(new
//		OrderModel(4L, "0000000005", "Product 5", 1.00f, 1));
		
		
		List<OrderEntity> ordersEntity = service.findAll();
		
		List<OrderModel> ordersDomain = new ArrayList<OrderModel>();
		
		for(OrderEntity entity : ordersEntity)
		{
			ordersDomain.add(new OrderModel(entity.getId(), entity.getOrderNo(), entity.getProductName(), entity.getPrice(), entity.getQuantity()));
		}
		
		return ordersDomain;
	}
	
	@Override
	public OrderModel findById(int id)
	{
		OrderEntity orderEntity = service.findById(id);
		OrderModel orderModel = new OrderModel(
												 orderEntity.getId(), orderEntity.getOrderNo(),
												 orderEntity.getProductName(), orderEntity.getPrice(),
												 orderEntity.getQuantity()
												);
		
		return orderModel;
	}
	
	@Override
	public boolean delete(OrderModel order) 
	{
		OrderEntity entity = new OrderEntity(order.getId(), order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
		boolean result = service.delete(entity);
		
		return true;
	}
	
	@Override
	public boolean create(String productName, float price, int quantity)
	{
		OrderModel orderModel = new OrderModel(productName, price, quantity);
		OrderEntity orderEntity = new OrderEntity(-1L, "00000000", orderModel.getProductName(), orderModel.getPrice(), orderModel.getQuantity());
		boolean result = service.create(orderEntity);
		
		return true;
	}
}
