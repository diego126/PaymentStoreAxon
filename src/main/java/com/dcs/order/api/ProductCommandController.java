package com.dcs.order.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.order.query.ProductView;
import com.dcs.order.query.ProductViewRepository;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {
	
	private final ProductViewRepository productViewRepository;
	
	public ProductCommandController(ProductViewRepository productViewRepository) {
		this.productViewRepository=productViewRepository;
	}
	
	@GetMapping
	public List<ProductView> findAll(){
		return productViewRepository.findAll();
	}
	
	
}
