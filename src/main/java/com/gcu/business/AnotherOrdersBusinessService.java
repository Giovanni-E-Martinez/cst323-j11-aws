package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface
{
	public void init() 
	{
		System.out.println("In AnotherOrdersBusinessService.init()");
	}
	
	public void destroy() 
	{
		System.out.println("In AnotherOrdersBusinessService.destroy()");
	}

	@Override
	public void test() 
	{
		System.out.println("Hello from AnotherOrdersBusinessService");		
	}

	@Override
	public List<OrderModel> getOrders()
	{
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "0000000002", "Product 2", 1.00f, 1));
		orders.add(new OrderModel(2L, "0000000003", "Product 3", 1.00f, 1));
		orders.add(new OrderModel(3L, "0000000004", "Product 4", 1.00f, 1));
		orders.add(new OrderModel(4L, "0000000005", "Product 5", 1.00f, 1));
		
		return orders;
	}

	@Override
	public OrderModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(OrderModel order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create(String productName, float price, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
