package com.cg.jeefsrs.healthassist.medicalstore.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.jeefsrs.healthassist.medicalstore.entity.Orders;
import com.cg.jeefsrs.healthassist.medicalstore.service.OrderDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = OrderDetailsController.class)
public class OrderDetailsControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderDetailsServiceImpl orderdetailsService;

	@Test
	public void testAddOrders() throws Exception{
		
        String URI = "/api/v2/AddOrderDetails";
        Orders orders = new Orders();
		orders.setOrderCost(400);
		orders.setOrderDose(500);
		orders.setOrderedDate("2020-9-19");
		orders.setOrderItem("cefixime");
		orders.setOrderQuantity(10);
        String jsonInput = this.converttoJson(orders);

        Mockito.when(orderdetailsService.addOrders(Mockito.any(Orders.class))).thenReturn(orders);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
    }
	
	
	@Test
	void testgetOrderById() throws Exception {
		String URI= "/api/v2/OrderDetails/{id}";
		 Orders orders = new Orders();
			orders.setOrderCost(400);
			orders.setOrderDose(500);
			orders.setOrderedDate("2020-9-19");
			orders.setOrderItem("cefixime");
			orders.setOrderQuantity(10);
        String jsonInput = this.converttoJson(orders);
        Mockito.when(orderdetailsService.getOrderById(Mockito.any())).thenReturn(orders);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
	
	
	@Test
	void testgetAllOrders() throws Exception {
		String URI = "/api/v2/OrderDetails";
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
				orders2.setOrderItem("Paracetamol");
				orders2.setOrderQuantity(10);
		        
	    	 List<Orders> orderList=new ArrayList<>();
	    	 orderList.add(orders);
	    	 orderList.add(orders2);
	    	 
	    	String jsonInput = this.converttoJson(orderList);

	         Mockito.when(orderdetailsService.getAllOrders()).thenReturn(orderList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	private String converttoJson(Object orders) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orders);
	}
}
