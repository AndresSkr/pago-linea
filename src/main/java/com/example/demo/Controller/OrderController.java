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
	public List<Order> GetOrderCC(@PathVariable int cc) {

		List<Order> orderFind = orderService.GetOrderCC(cc);

		if (orderFind == null) {
			return orderFind;
		}
		return orderFind;
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
		Order orderFind = null;

		orderFind = orderService.GetOrderId(id);

		if (orderFind == null) {
			return new responseOrder("Order by id not found", 0, orderFind);
		}

		boolean swCc = util.VerifyCc(order.getCc(), cc, orderFind);
		if (!swCc) {
			return new responseOrder("Order cc is not equals to cc Url", 0, orderFind);
		}

		Order orderVirificated = util.VerifyPriceToSave(order);

		boolean swDate = util.VerifyDate(order, orderFind, 5);
		boolean swPrice = util.VerifyPriceToEdit(orderVirificated, orderFind);

		if (!swDate) {
			return new responseOrder("Date expired", 0, orderFind);
		}
		if (!swPrice) {
			return new responseOrder("Price below the last price", 0, orderFind);
		}

		Order orderupdate = orderService.UpdateOrder(orderFind, orderVirificated);
		return new responseOrder("Order Updated ", 1, orderupdate);

	}

	@DeleteMapping
	@RequestMapping("/delete/{id}")
	public responseOrder DeleteOrder(@PathVariable int id) {
		Order orderFind = null;
		orderFind = orderService.GetOrderId(id);

		if (orderFind == null) {
			return new responseOrder("Order by id not found", 0, orderFind);
		}

		boolean swDate = util.VerifyDate(new Order(), orderFind, 12);

		if (!swDate) {
			Order orderDeleteModify = orderService.saveOrderDelete(orderFind);
			return new responseOrder("Order deleted but with 10%", 1, orderDeleteModify);
		} else {

			orderService.DeleteOrder(orderFind);
			return new responseOrder("Order deleted", 1, orderFind);
		}

	}

}
