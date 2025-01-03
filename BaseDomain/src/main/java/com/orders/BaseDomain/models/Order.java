package com.orders.BaseDomain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "orders")
public class Order {
	@Id
	private String orderId;
	private String customerId;
	private String productId;
	private int quantity;
	private double price;
	private String orderStatus;
	private String orderDate;
	private String deliveryDate;
	private String shippingAddress;
	private String paymentMethod;
}
