package com.dcs.order.query;

import java.util.UUID;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.dcs.order.messages.events.OrderRegisteredEvent;

@Component
public class OrderViewProjection {
	
	private final OrderViewRepository orderViewRepository;
	private final OrderDetailRepository orderDetailRepository;
	
	public OrderViewProjection(OrderViewRepository orderViewRepository,OrderDetailRepository orderDetailRepository) {
		this.orderViewRepository=orderViewRepository;
		this.orderDetailRepository=orderDetailRepository;
	}
	
	@EventHandler
	public void on(OrderRegisteredEvent event) {
		OrderView order=new OrderView(event.getOrderId(), event.getCustomerId(), event.getRegisterDate(), "0");
		
		for(OrderDetailView product:event.getProducts()) {
			String orderDetailId = UUID.randomUUID().toString();
			OrderDetailView orderDetail=new OrderDetailView(orderDetailId, event.getOrderId(), product.getProductId(),product.getQuantity());
			orderDetailRepository.save(orderDetail);
		}
		orderViewRepository.save(order);
	}
}
