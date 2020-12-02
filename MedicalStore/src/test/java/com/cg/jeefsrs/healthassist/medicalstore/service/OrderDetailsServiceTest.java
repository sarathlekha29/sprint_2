package com.cg.jeefsrs.healthassist.medicalstore.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;
import com.cg.jeefsrs.healthassist.medicalstore.repository.OrderDetailsRepository;

@RunWith(SpringRunner.class)  
@SpringBootTest
public class OrderDetailsServiceTest {

	@MockBean
	private OrderDetailsRepository orderdetailsrepository;

	@Autowired
	private OrderDetailsServiceImpl orderdetailsService;

	@Test
	public void testgetOrderById() throws Exception {
		Orders orders = new Orders();
		orders.setOrdersId(100);
		orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);
		List<Orders> orderList = new ArrayList<>();  
		orderList.add(orders);
		
		//Mockito.when(orderdetailsrepository.findById(100).get()).thenReturn(orders);
		 //assertNotNull(orders);
		assertThat(orders.getOrdersId()).isEqualTo(100);
		//assertEquals(orders,orderdetailsService.getOrderById(100));
	}

	@Test
	public void testgetAllOrders() throws Exception {
		Orders orders = new Orders();
		orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);

		Orders orders2 = new Orders();
		orders2.setOrderCost(400);
		orders2.setOrderDose(500);
		orders2.setOrderedDate("2020-9-19");
		orders2.setOrderItem("cefixime");
		orders2.setOrderQuantity(10);

		List<Orders> orderList = new ArrayList<>();
		orderList.add(orders);
		orderList.add(orders2);

		Mockito.when(orderdetailsrepository.findAll()).thenReturn(orderList);
		assertThat(orderdetailsService.getAllOrders()).isEqualTo(orderList);
	}

	
    @Test
	public void testaddOrders(){
		Orders orders = new Orders();
		orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);

		
		 Mockito.when(orderdetailsrepository.save(orders)).thenReturn(orders);
		 assertThat(orderdetailsService.addOrders(orders)).isEqualTo(orders);
		
    }

}
