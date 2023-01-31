package com.gcu.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gcu.data.entity.OrderEntity;

/* 
 * What is RowMapper?
 * Interface that is used by Jdbc Template for mapping rows of a ResultSet
 * on a per-row basis. Implementations of this interface perform the actual
 * work of mapping each row to a result object.
 */
public class OrderRowMapper implements RowMapper<OrderEntity>
{
	/*
	 * Implementations must implement this method to map each row of data in the ResultSet
	 * This method should not call next() on the ResultSet, it is only supposed to
	 * map values of the current row only.
	 */
	@Override
	public OrderEntity mapRow(ResultSet rs, int rowNumber) throws SQLException
	{
		// Return a new instance of our OrderEntity using getters to populate the
		// parameterized constructor.
		return new OrderEntity(rs.getLong("id"), rs.getString("order_no"), rs.getString("product_name"), rs.getFloat("price"), rs.getInt("quantity"));
	}
}
