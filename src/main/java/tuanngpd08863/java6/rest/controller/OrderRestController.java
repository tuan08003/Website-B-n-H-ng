package tuanngpd08863.java6.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import tuanngpd08863.java6.entity.Order;
import tuanngpd08863.java6.service.OrderService;



@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

	@Autowired
	OrderService orderService;
	
	
	@PostMapping()
	public Order create(@RequestBody JsonNode orderData) {
	return orderService.create(orderData);
	}
}


