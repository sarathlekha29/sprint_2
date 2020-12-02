package com.cg.jeefsrs.healthassist.medicalstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;
import com.cg.jeefsrs.healthassist.medicalstore.exception.ResourceNotFoundException;
import com.cg.jeefsrs.healthassist.medicalstore.service.OrderDetailsServiceImpl;

@RestController
@RequestMapping("/api/v2")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsServiceImpl orderdetailsservice;
	
	@GetMapping("/OrderDetails")
	public List<Orders> getAllOrders() {
		return orderdetailsservice.getAllOrders();
	}
	
	@GetMapping("/OrderDetails/{id}")
	public ResponseEntity<Orders> getOrderById(@PathVariable(value = "id") Integer ordersId) throws ResourceNotFoundException {
		Orders orders = orderdetailsservice.getOrderById(ordersId);
		return  ResponseEntity.ok(orders);
	}
	
	@PostMapping("/AddOrderDetails")  
	public Orders addOrders( @RequestBody Orders orders) {
		return orderdetailsservice.addOrders(orders);
	} 
	
	
	
	@PutMapping("/editOrderDetails/{id}")
	public ResponseEntity<Orders>  updateOrderById(@PathVariable(value = "id") Integer ordersId, @RequestBody Orders orders ) throws ResourceNotFoundException {
		Orders order = orderdetailsservice.updateOrder(ordersId, orders);
		return  ResponseEntity.ok(order);
	}
	
}
