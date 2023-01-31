package com.gcu.data;

import java.util.List;

public interface DataAccessInterface <T> 
{
	/**
	 * 
	 * @return
	 */
	public List<T> findAll();
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T findById(int id);
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean create(T t);
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t);	
}
