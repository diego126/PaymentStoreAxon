package com.dcs.order.api;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.order.application.dto.RegisterOrderErrorResponseDto;
import com.dcs.order.application.dto.RegisterOrderOkResponseDto;
import com.dcs.order.application.dto.RegisterOrderRequestDto;
import com.dcs.order.messages.commands.RegisterOrderCommand;
import com.dcs.order.query.OrderDetailRepository;
import com.dcs.order.query.OrderDetailView;
import com.dcs.order.query.OrderView;
import com.dcs.order.query.OrderViewRepository;

@RestController
@RequestMapping("/api/orders")
public class OrderCommandController {
	
	private final CommandGateway commandGateway;
	private final OrderViewRepository orderViewRepo;
	private final OrderDetailRepository orderDetailRepository;
	
	public OrderCommandController(CommandGateway commandGateway,OrderViewRepository orderViewRepo,OrderDetailRepository orderDetailRepository) {
		this.commandGateway=commandGateway;
		this.orderViewRepo=orderViewRepo;
		this.orderDetailRepository=orderDetailRepository;
	}
	
	@GetMapping
	public List<OrderView> findAllOrders(){
		return orderViewRepo.findAll();
	}
	
	@PostMapping
	public CompletableFuture<Object> saveOrder(@RequestBody RegisterOrderRequestDto registerOrderDto) {
		String orderId = UUID.randomUUID().toString();
		RegisterOrderCommand registerOrderCommand = new RegisterOrderCommand(
				orderId,
				registerOrderDto.getCustomerId(),
				registerOrderDto.getProducts(),
				new Date()
		);
		CompletableFuture<Object> future = commandGateway.send(registerOrderCommand);
		CompletableFuture<Object> response = future.handle((ok, ex) -> {
		    if (ex != null) {
		    	ex.printStackTrace();
		        return new RegisterOrderErrorResponseDto();
		    }
		    return new RegisterOrderOkResponseDto(orderId);
		});
		return response;
	}
	
	@GetMapping("/{orderId}")
	public List<OrderDetailView> findOrderDetail(@PathVariable("orderId") String orderId){
		System.out.println("OrderId:"+orderId);
		return orderDetailRepository.findByOrderId(orderId);
	}
}
