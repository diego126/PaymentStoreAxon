package com.dcs.order.application.dto;

import java.util.List;

import com.dcs.order.query.OrderDetailView;
import com.dcs.order.query.ProductView;

public class RegisterOrderRequestDto {
	private String customerId;
	private List<OrderDetailView> products;
	
	public String getCustomerId() {
		return customerId;
	}
	public List<OrderDetailView> getProducts() {
		return products;
	}
}
