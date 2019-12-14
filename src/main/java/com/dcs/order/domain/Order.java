package com.dcs.order.domain;

import java.util.List;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import com.dcs.order.messages.commands.RegisterOrderCommand;
import com.dcs.order.messages.events.OrderRegisteredEvent;
import com.dcs.order.query.OrderDetailView;
import com.dcs.order.query.ProductView;

@Aggregate
public class Order {
	@AggregateIdentifier
	private String orderId;
	private String customerId;
	private List<OrderDetailView> products;
	
	public Order() {
		
	}
	
	@CommandHandler
	public Order(RegisterOrderCommand command) {
		apply(
				new OrderRegisteredEvent(command.getOrderId(),command.getCustomerId(),command.getProducts(),command.getRegisterDate())
				);
	}
	
	@EventSourcingHandler
	public void on(OrderRegisteredEvent event) {
		this.orderId=event.getOrderId();
		this.customerId=event.getCustomerId();
		this.products=event.getProducts();
	}
}
