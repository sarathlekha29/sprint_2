package com.cg.jeefsrs.healthassist.medicalstore.repository;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;


@RunWith(SpringRunner.class)
@DataJpaTest
class OrderDetailsRepositoryTest {

	@Autowired
    private OrderDetailsRepository orderdetailsrepository;

    @Autowired
    private TestEntityManager testEntityManager;
 
    @Test
    public void testaddOrders() throws Exception{
	 Orders orders = getOrders();
	 Orders saveInDb = testEntityManager.persist(orders);
	 Orders getFromInDb = orderdetailsrepository.findById(saveInDb.getOrdersId()).get();
	 assertThat(getFromInDb).isEqualTo(saveInDb);
	 
    }
 
	private Orders getOrders() {
		// TODO Auto-generated method stub
		Orders orders = new Orders();
		orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);
        return orders;
	}
	
    @Test
    public void getAllOrders() throws Exception{
	
    	Orders orders = new Orders();
    	orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);
		
		Orders orders2 = new Orders();
    	orders2.setOrderCost(500);
		orders2.setOrderDose(650);
		orders2.setOrderedDate("2020-9-19");
		orders2.setOrderItem("paracetamol");
		orders2.setOrderQuantity(15);
		
        //Save into in memory database
        testEntityManager.persist(orders);
        testEntityManager.persist(orders2);

        //Retrieve all tickets
        List<Orders> orderlist = (List<Orders>) orderdetailsrepository.findAll();
        Assert.assertEquals(2, orderlist.size());
    }
    
    @Test
    public void testgetOrderById() throws Exception{
    	Orders orders = new Orders();
    	orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);
		
        //Insert Data into in memory database
		Orders saveInDb = testEntityManager.persist(orders);
        //Get Data from DB
		Orders getFromInDb = orderdetailsrepository.findById(saveInDb.getOrdersId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
}
}
