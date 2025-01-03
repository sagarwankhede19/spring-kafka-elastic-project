package com.orders.orderservice.repos;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.orders.BaseDomain.models.Order;

@Repository
public interface OrderRepository extends ElasticsearchRepository<Order, String> {

}
