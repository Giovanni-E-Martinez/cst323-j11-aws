package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private Logger logger = LoggerFactory.getLogger(OrdersDataService.class);


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
		logger.info("Entering OrdersDataService.findById()");
		OrderEntity order = new OrderEntity();
		try
		{
			// Get one of the Entity Orders
			order = ordersRepository.findById(id).get();
		}
		catch(Exception e)
		{
			logger.error("Unable to retrieve order through OrdersDataService.findById()");
			e.printStackTrace();
		}
		// Return the list of Orders
		logger.info("Exiting OrdersDataService.findById()");

		return order;
	}

	// CRUD: finder to return all entities
	public List<OrderEntity> findAll()
	{
		logger.info("Entering OrdersDataService.findAll()");
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
			logger.error("Unable to retrieve orders through OrdersDataService.findAll()");
			e.printStackTrace();
		}
		// Return the list of Orders
		logger.info("Exiting OrdersDataService.findAll()");

		return orders;
	}

	// CRUD: create an entity
	public boolean create(OrderEntity order)
	{
		logger.info("Entering OrdersDataService.create()");
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
			logger.error("Unable to create order through OrdersDataService.create()");
			e.printStackTrace();
			return false;
		}
		logger.info("Exiting OrdersDataService.create()");

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
		logger.info("Entering OrdersDataService.delete()");
		String sql = "DELETE FROM `order` WHERE id=?";
		try
		{
			jdbcTemplateObject.update(sql,
					order.getId());
		}
		catch(Exception e)
		{
			logger.error("Unable to delete order through OrdersDataService.delete()");
			e.printStackTrace();
			return false;
		}
		logger.info("Exiting OrdersDataService.delete()");

		return true;
	}
}
