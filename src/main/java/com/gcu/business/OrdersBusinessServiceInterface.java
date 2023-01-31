package com.gcu.business;

import java.util.List;

import com.gcu.model.OrderModel;

public interface OrdersBusinessServiceInterface 
{
	public void test();
	public List<OrderModel> getOrders();
	public OrderModel findById(int id);
	public boolean delete(OrderModel order);
	public boolean create(String productName, float price, int quantity);
	public void init();
	public void destroy();
}
