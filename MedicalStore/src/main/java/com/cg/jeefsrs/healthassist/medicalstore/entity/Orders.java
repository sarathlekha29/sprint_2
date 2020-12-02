package com.cg.jeefsrs.healthassist.medicalstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name  = "orderdetails")
public class Orders {
		
		@Id //@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(nullable = false)
		private int OrdersId;
		@Column(nullable = false)
		private String OrderItem;
		@Column(nullable = false)
		private int OrderDose;
		@Column(nullable = false)
		private int OrderQuantity;
		@Column(nullable = false) 
		private double OrderCost;
		@Column(nullable = false)
		private String orderedDate;
		@Column(nullable = false)
		private String patientName;
		@Column(nullable = false)
		private String patientAddress;
		@Column(nullable = false)
		private String patientEmail;
		@Column(nullable = false)
		private long patientNumber;
		@Column(nullable = false)
		private String delivered;	
		
		public Orders() {
			
		}

		public Orders(int ordersId, String orderItem, int orderDose, int orderQuantity, double orderCost,
				String orderedDate, String patientName, String patientAddress, String patientEmail, long patientNumber,
				String delivered) {
			super();
			OrdersId = ordersId;
			OrderItem = orderItem;
			OrderDose = orderDose;
			OrderQuantity = orderQuantity;
			OrderCost = orderCost;
			this.orderedDate = orderedDate;
			this.patientName = patientName;
			this.patientAddress = patientAddress;
			this.patientEmail = patientEmail;
			this.patientNumber = patientNumber;
			this.delivered = delivered;
		}





		public int getOrdersId() {
			return OrdersId;
		}


		public void setOrdersId(int ordersId) {
			OrdersId = ordersId;
		}


		public String getOrderItem() {
			return OrderItem;
		}


		public void setOrderItem(String orderItem) {
			OrderItem = orderItem;
		}


		public int getOrderDose() {
			return OrderDose;
		}


		public void setOrderDose(int orderDose) {
			OrderDose = orderDose;
		}


		public int getOrderQuantity() {
			return OrderQuantity;
		}


		public void setOrderQuantity(int orderQuantity) {
			OrderQuantity = orderQuantity;
		}


		public double getOrderCost() {
			return OrderCost;
		}


		public void setOrderCost(double orderCost) {
			OrderCost = orderCost;
		}


		public String getOrderedDate() {
			return orderedDate;
		}


		public void setOrderedDate(String orderedDate) {
			this.orderedDate = orderedDate;
		}


		public String getPatientName() {
			return patientName;
		}


		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}


		public String getPatientAddress() {
			return patientAddress;
		}


		public void setPatientAddress(String patientAddress) {
			this.patientAddress = patientAddress;
		}


		public String getPatientEmail() {
			return patientEmail;
		}


		public void setPatientEmail(String patientEmail) {
			this.patientEmail = patientEmail;
		}


		public long getPatientNumber() {
			return patientNumber;
		}


		public void setPatientNumber(long patientNumber) {
			this.patientNumber = patientNumber;
		}


		public String getDelivered() {
			return delivered;
		}


		public void setDelivered(String delivered) {
			this.delivered = delivered;
		}

		@Override
		public String toString() {
			return "Orders [OrdersId=" + OrdersId + ", OrderItem=" + OrderItem + ", OrderDose=" + OrderDose
					+ ", OrderQuantity=" + OrderQuantity + ", OrderCost=" + OrderCost + ", orderedDate=" + orderedDate
					+ ", patientName=" + patientName + ", patientAddress=" + patientAddress + ", patientEmail="
					+ patientEmail + ", patientNumber=" + patientNumber + ", delivered=" + delivered + "]";
		}



}
