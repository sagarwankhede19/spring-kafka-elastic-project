package com.orders.StockService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.orders.BaseDomain.models.OrderEvent;

@Service
public class KafkaConfigs {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfigs.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumeMessage(OrderEvent event) {
		LOGGER.info(String.format("Order event reieved in stock service ------> %s ", event.toString()));
		
		
	}
}
