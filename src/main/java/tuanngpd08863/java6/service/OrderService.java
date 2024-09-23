package tuanngpd08863.java6.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import tuanngpd08863.java6.entity.Order;

public interface OrderService {


	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);



}
