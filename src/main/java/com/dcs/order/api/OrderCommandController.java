package com.dcs.order.api;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcs.order.application.dto.RegisterOrderErrorResponseDto;
import com.dcs.order.application.dto.RegisterOrderOkResponseDto;
import com.dcs.order.application.dto.RegisterOrderRequestDto;
import com.dcs.order.messages.commands.RegisterOrderCommand;
import com.dcs.order.query.OrderView;

@RestController
public class OrderCommandController {
	
	private final CommandGateway commandGateway;
	
	public OrderCommandController(CommandGateway commandGateway) {
		this.commandGateway=commandGateway;
	}
	
	@GetMapping
	public List<OrderView> findAllOrders(){
		return null;
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
}
