package com.dcs.order.application.dto;

public class RegisterOrderOkResponseDto {
	private String orderId;

	public RegisterOrderOkResponseDto(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}
	
}
