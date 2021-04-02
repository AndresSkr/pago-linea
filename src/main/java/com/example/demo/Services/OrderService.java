package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.Order;

@Service
public class OrderService {

	List<Order> OrderReq = new ArrayList<Order>();
	public boolean SaveOrder(Order order) {
		try {
			OrderReq.add(order);

			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Order> GetOrder() {
		return OrderReq;
	}

	public Order GetOrderCC(int cc) {
		
		return OrderReq.stream().filter(p -> p.getCc()==cc).findFirst().get();
		
	}

}
