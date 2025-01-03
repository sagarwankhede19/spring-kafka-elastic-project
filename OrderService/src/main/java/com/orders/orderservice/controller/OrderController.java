package com.orders.orderservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.BaseDomain.models.Order;
import com.orders.BaseDomain.models.OrderEvent;
import com.orders.orderservice.services.OrderProducer;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	OrderProducer producer;

	public OrderController(OrderProducer producer) {
		this.producer = producer;
	}
	
	@PostMapping("order")
	public String placeOrder(@RequestBody Order order) {
		
		order.setOrderId("ORD"+UUID.randomUUID().toString());
		OrderEvent event= new OrderEvent();
		event.setStatus("Pending");
		event.setMessage("Order status is in pending state");
		event.setOrder(order);
		producer.sendMessage(event);
		return "Order placed successfully....";
	}

}
