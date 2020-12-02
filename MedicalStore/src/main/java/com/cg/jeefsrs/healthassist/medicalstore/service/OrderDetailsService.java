package com.cg.jeefsrs.healthassist.medicalstore.service;

import java.util.List;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;
import com.cg.jeefsrs.healthassist.medicalstore.exception.ResourceNotFoundException;

public interface OrderDetailsService {

	public Orders getOrderById( Integer ordersId) throws ResourceNotFoundException;
	public List<Orders> getAllOrders() ; 
	public Orders addOrders( Orders orders) ;
	public Orders updateOrder(Integer ordersId,  Orders orders) throws ResourceNotFoundException;
}
