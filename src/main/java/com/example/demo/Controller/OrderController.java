package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Dto.Order;
import com.example.demo.Services.OrderService;
import com.example.demo.Util.Util;
import com.example.demo.response.responseOrder;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	Util util = new Util();
	@PostMapping
	@RequestMapping("/add")
	public responseOrder AddOrder(@RequestBody Order order) {
		Order res = orderService.SaveOrder(order);
		
		if (res == null) {
			return new responseOrder("Order Error", 0, res);
		}
		return new responseOrder("Order Add", 1, res);
		
	}

	@GetMapping
	@RequestMapping("/getAll")
	public List<Order> GetOrder() {
		return orderService.GetOrder();
	}

	@GetMapping
	@RequestMapping("/getCc/{cc}")
	public responseOrder GetOrderCC(@PathVariable int cc) {

		Order orderFind = orderService.GetOrderCC(cc);

		if (orderFind == null) {
			return new responseOrder("Order by cc not found", 0, orderFind);
		}
		return new responseOrder("ok", 1, orderFind);
	}

	@GetMapping
	@RequestMapping("/getId/{id}")
	public responseOrder GetOrderID(@PathVariable int id) {

		Order orderFind = orderService.GetOrderId(id);

		if (orderFind == null) {
			return new responseOrder("Order by id not found", 0, orderFind);
		}
		return new responseOrder("ok", 1, orderFind);

	}

	@PutMapping
	@RequestMapping("/update/{cc}/{id}")
	public responseOrder UpdateOrder(@RequestBody Order order, @PathVariable int cc, @PathVariable int id) {
		
		boolean swCc = util.VerifyCc(order.getCc(), cc);
		Order orderFind = null;
		if (!swCc) {
			return new responseOrder("Order cc is not equals to cc Url", 0, orderFind);
		}

		orderFind = orderService.GetOrderId(id);

		if (orderFind == null) {
			return new responseOrder("Order by id not found", 0, orderFind);
		}

		Order orderVirificated = util.VerifyPriceToSave(order);

		boolean swDate = util.VerifyDate(order, orderFind);
		boolean swPrice = util.VerifyPriceToEdit(orderVirificated, orderFind);
		
		 Order orderupdate = orderService.UpdateOrder(swDate, swPrice, orderFind, orderVirificated);

		if (orderupdate==null) {
			return new responseOrder("Date expired or price total under total Update", 0, orderFind);
		}

		return new responseOrder("Order Updated ", 1, orderupdate);
	}

	@DeleteMapping
	@RequestMapping("/delete/{id}")

	public Order DeleteOrder(@PathVariable int id) {
		Order res = orderService.DeleteOrder(id);
		return res;
	}

}
