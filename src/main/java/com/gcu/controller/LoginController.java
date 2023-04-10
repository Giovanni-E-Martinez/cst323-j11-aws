package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gcu.business.OrdersBusinessService;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/")

public class LoginController
{
	// Deploy: 1
	
	// Dependency Injection
	// we can use autowiring on properties, setters, and constructors.
	// using autowired on a property eliminates the need for getters and setters.
	// when autowiring a property in Bean, the property's class type is used
	// for searching a matching Bean definition in the configuration file.
	// if a Bean is found, it is injected into the property.
	// in this case autowiring to SpringConfig getOrdersBusiness method.
	@Autowired
	private OrdersBusinessService service;
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	// display the orders view
	@GetMapping("/")
	public String orders(Model model)
	{
		logger.info("Entering orders.");
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		model.addAttribute("orderModel", new OrderModel());
		logger.info("Exiting orders.");

		return "orders";
	}

	@PostMapping("/delete/{id}")
	public String doDelete(@PathVariable int id)
	{
		logger.info("Entering doDelete.");
		OrderModel order = service.findById(id);
		service.delete(order);
		logger.info("Exiting doDelete.");

		return "redirect:/";
	}

	@PostMapping("/create")
	public String doCreate(OrderModel orderModel)
	{
		logger.info("Entering create.");
		service.create(orderModel.getProductName(), orderModel.getPrice(), orderModel.getQuantity());
		logger.info("Exiting create.");

		return "redirect:/";
	}
}
