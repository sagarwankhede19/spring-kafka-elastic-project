package com.orders.orderservice.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.orders.BaseDomain.models.OrderEvent;
import com.orders.orderservice.repos.OrderRepository;

@Service
public class OrderConsumer {
    private final OrderRepository orderRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    public OrderConsumer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessage(OrderEvent event) {
        try {
            LOGGER.info("Order event received in stock service ------> {}", event);
            
            // Handle the order event and save it to the repository
//            orderRepository.save(event.getOrder());

            LOGGER.info("Order event successfully processed and saved.");
        } catch (Exception e) {
            LOGGER.error("Error processing order event: {}", event, e);
            // Optionally, add retry logic or alerting mechanisms here
        }
    }
}
