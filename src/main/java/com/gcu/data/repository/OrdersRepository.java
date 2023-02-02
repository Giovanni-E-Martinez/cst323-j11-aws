package com.gcu.data.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcu.data.entity.OrderEntity;

@Repository
public interface OrdersRepository extends CrudRepository<OrderEntity, Integer>
{
	// Example of truly overriding a method from the CrudRepository and using our own customized SQL
	@Override
	@Query(value = "SELECT * FROM `order`")
	public List<OrderEntity> findAll();
}
