package com.dcs.order.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.order.query.ProductView;

@RestController
public class ProductCommandController {
	
	@GetMapping
	public List<ProductView> findAll(){
		return null;
	}
	
	
}
