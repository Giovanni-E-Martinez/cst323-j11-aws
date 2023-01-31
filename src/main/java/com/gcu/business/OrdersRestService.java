package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

/* @RestController is a convenience annotation for creating Restful controllers.
 * It adds the @Controller and @ResponseBody annotations.
 * It converts the response to JSON or XML.
 */
@RestController
/* @RequestMapping is the most common and widely used annotation in the Spring MVC.
 * It is used to map request into specific handler classes
 * and/or handler methods.
 */
@RequestMapping("/service")
public class OrdersRestService 
{
	/* Inject this bean into the OrdersBusinessService bean using @AutoWired on
	 * the field definition.
	 */
	@Autowired
	OrdersBusinessServiceInterface service;
	
	/* The @GetMapping annotation is the specialized version of @RequestMapping
	 * annotation that acts as a shortcut for
	 * @RequestMapping.
	 * The @GetMapping method in the @Controller annotated classes, handle the HTTP GET request.
	 * The produces = MediaType.APPLICATION_JSON_VALUE means that the
	 * response that will be produced will be converted into JSON format.
	 */
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson()
	{
		return service.getOrders();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml()
	{
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
}
