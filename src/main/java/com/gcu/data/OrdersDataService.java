package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity>
{
	@Autowired
	private OrdersRepository ordersRepository;
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	// Non-default constructor
	public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource)
	{
		this.ordersRepository = ordersRepository;
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	// CRUD: finder to return single entity 
	public OrderEntity findById(int id)
	{
		OrderEntity order = new OrderEntity();
		try
		{
			// Get one of the Entity Orders
			order = ordersRepository.findById(id).get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// Return the list of Orders
		return order;
	}
	
	// CRUD: finder to return all entities
	public List<OrderEntity> findAll()
	{
		List<OrderEntity> orders = new ArrayList<OrderEntity>();
		
		try
		{
			// Get all of the Entity Orders
			Iterable<OrderEntity> ordersIterable = ordersRepository.findAll();
			
			// Add to the list
			ordersIterable.forEach(orders::add);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		// Return the list of Orders
		return orders;
	}
	
	// CRUD: create an entity
	public boolean create(OrderEntity order)
	{
		String sql = "INSERT INTO `order`(order_no, product_name, price, quantity) VALUES(?, ?, ?, ?)";
		try
		{
			jdbcTemplateObject.update(sql, 
									  order.getOrderNo(),
									  order.getProductName(),
									  order.getPrice(),
									  order.getQuantity());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// CRUD: update an entity
	public boolean update(OrderEntity order)
	{
		return true;
	}
	
	// CRUD: delete an entity
	public boolean delete(OrderEntity order)
	{
		String sql = "DELETE FROM `order` WHERE id=?";
		try
		{
			jdbcTemplateObject.update(sql, 
									  order.getId());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
