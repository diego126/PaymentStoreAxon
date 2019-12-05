package com.dcs.order.domain;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class Product {
	@AggregateIdentifier
	private String productId;
	
}
