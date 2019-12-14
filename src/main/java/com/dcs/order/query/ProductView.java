package com.dcs.order.query;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductView {
	@Id
	@Column(length=36)
	private String productId;
	private String description;
	private BigDecimal price;
	private int stock;
	
	public ProductView() {
		
	}
	
	public ProductView(String productId, String description, BigDecimal price, int stock) {
		super();
		this.productId = productId;
		this.description = description;
		this.price = price;
		this.stock = stock;
	}
	public String getProductId() {
		return productId;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	
	
}
