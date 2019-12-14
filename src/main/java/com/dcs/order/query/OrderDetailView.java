package com.dcs.order.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetailView {
	@Id
	@Column(length=36)
	private String orderDetailId;
	private String orderId;
	private String productId;
	private int quantity;
	
	public OrderDetailView() {
		
	}
	public OrderDetailView(String orderDetailId, String orderId, String productId, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity=quantity;
	}
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public String getOrderId() {
		return orderId;
	}
	public String getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
}
