package com.dcs.order.application.dto;

import java.util.List;

import com.dcs.order.query.ProductView;

public class RegisterOrderRequestDto {
	private String customerId;
	private List<ProductView> products;
	
	public String getCustomerId() {
		return customerId;
	}
	public List<ProductView> getProducts() {
		return products;
	}
}
