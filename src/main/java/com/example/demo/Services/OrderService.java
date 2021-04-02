package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.Order;
import com.example.demo.Util.*;

@Service
public class OrderService {

	List<Order> OrderReq = new ArrayList<Order>();
	Util util = new Util();

	public Order SaveOrder(Order order) {
		try {

			Order orderVirificated = util.VerifyPriceToSave(order);

			if (orderVirificated.getTotalPrice() > 70000 && orderVirificated.getTotalPrice() < 100000) {

				Double home = 8000.0;
				orderVirificated.setPriceHome(home);
				Double priceIva = (orderVirificated.getTotalPrice() * 0.19) + orderVirificated.getTotalPrice();
				orderVirificated.setTotalPriceIva(priceIva + home);
			} else if (orderVirificated.getTotalPrice() > 100000) {
				Double home = 0.0;
				orderVirificated.setPriceHome(home);
				Double priceIva = (order.getTotalPrice() * 0.19) + orderVirificated.getTotalPrice();
				orderVirificated.setTotalPriceIva(priceIva + home);
			}

			OrderReq.add(order);

			Order orderAddRecent = GetOrderCC(orderVirificated.getCc());

			return orderAddRecent;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Order orderAddRecent = null;
			return orderAddRecent;
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

	public Order UpdateOrder(int cc, Order order) {

		boolean swCc = util.VerifyCc(order.getCc(), cc);
		Order orderFind = null;
		if (!swCc) {
			return orderFind;
		}

		orderFind = GetOrderCC(cc);

		if (orderFind == null) {
			return orderFind;
		}

		Order orderVirificated = util.VerifyPriceToSave(order);

		boolean swDate = util.VerifyDate(order, orderFind);
		boolean swPrice = util.VerifyPriceToEdit(orderVirificated, orderFind);

		if (swDate && swPrice) {
			boolean swDelteOrder = OrderReq.remove(orderFind);
			if (swDelteOrder) {
				Order orderUpdated = SaveOrder(orderVirificated);
				return orderUpdated;
			}
		}

		return orderFind;

	}

}
