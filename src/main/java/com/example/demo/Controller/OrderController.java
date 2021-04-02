package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Order;
import com.example.demo.Services.OrderService;


@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping
	@RequestMapping("/Add")
	public Order AddOrder(@RequestBody Order order ) {
		Order res = orderService.SaveOrder(order);
		return res;
	}

	
	@GetMapping
	@RequestMapping("/Getall")
	public List<Order> GetOrder() {
		return orderService.GetOrder();
	}
	
	@GetMapping
	@RequestMapping("/Get/{cc}")
	public Order GetOrderCC(@PathVariable int cc) {
		return orderService.GetOrderCC(cc);
	}
	
	
	@PutMapping
	@RequestMapping("/update/{cc}")
	public Order UpdateOrder(@RequestBody Order order,@PathVariable int cc ) {
		Order res = orderService.UpdateOrder(cc,order);
		return res;
	}
	
	
}
