package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.Order;
import com.example.demo.Util.*;
@Service
public class OrderService {

	List<Order> OrderReq = new ArrayList<Order>();

	public boolean SaveOrder(Order order) {
		try {
			if (order.getTotalPrice() > 70000 && order.getTotalPrice() < 100000) {

				Double home = 8000.0;
				order.setPriceHome(home);
				Double priceIva = (order.getTotalPrice() * 0.19) + order.getTotalPrice();
				order.setTotalPriceIva(priceIva + home);
			} else if (order.getTotalPrice() > 100000) {
				Double home = 0.0;
				order.setPriceHome(home);
				Double priceIva = (order.getTotalPrice() * 0.19) + order.getTotalPrice();
				order.setTotalPriceIva(priceIva + home);
			}

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
		try {
			return OrderReq.stream().filter(p -> p.getCc() == cc).findFirst().get();
		} catch (Exception e) {
			Order order = null;
			return order;
		}
		
	}

	public boolean UpdateOrder(int cc, Order order) {
		
		Order orderFind = GetOrderCC(cc);
		
		if(orderFind==null) {
			return false;
		}else {
			Util util = new Util();
			util.VerifyDate(order, orderFind);
			return true;
		}
	
	}

}
