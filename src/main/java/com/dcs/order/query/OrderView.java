package com.dcs.order.query;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderView {
	@Id
	@Column(length=36)
	private String orderId;
	private String customerId;
	private Date orderDate;
	private String stateId;
	
	public OrderView() {
		
	}
	
	public OrderView(String orderId, String customerId, Date orderDate, String stateId) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.stateId = stateId;
	}
	public String getOrderId() {
		return orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public String getStateId() {
		return stateId;
	}
}
