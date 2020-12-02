package com.cg.jeefsrs.healthassist.medicalstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;
import com.cg.jeefsrs.healthassist.medicalstore.exception.ResourceNotFoundException;
import com.cg.jeefsrs.healthassist.medicalstore.repository.OrderDetailsRepository;

@Service
@Transactional
public class OrderDetailsServiceImpl implements OrderDetailsService  {

	@Autowired
	private OrderDetailsRepository orderdetailsrepository;
	
	public Orders getOrderById( Integer ordersId)
			throws ResourceNotFoundException {
		Orders order = orderdetailsrepository.findById(ordersId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + ordersId));
		return order;
	}  
	
	public List<Orders> getAllOrders() {
		return orderdetailsrepository.findAll();
	}
	 
	public Orders addOrders( Orders orders) {
			return  orderdetailsrepository.save(orders);
		}
	
	
	@Override
	public Orders updateOrder(Integer ordersId, Orders orders) throws ResourceNotFoundException {
		Orders order = orderdetailsrepository.findById(ordersId)
				.orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + ordersId));
		order.setOrderCost(orders.getOrderCost());
		order.setOrderDose(orders.getOrderDose());
		order.setOrderedDate(orders.getOrderedDate());
		order.setOrderItem(orders.getOrderItem());
		order.setOrderQuantity(orders.getOrderQuantity());
		order.setOrdersId(orders.getOrdersId());
		order.setPatientAddress(orders.getPatientAddress());
		order.setPatientEmail(orders.getPatientEmail());
		order.setPatientName(orders.getPatientName());
		order.setPatientNumber(orders.getPatientNumber());
		final Orders updateorder = orderdetailsrepository.save(order);
		return updateorder; 
	}
		
}
