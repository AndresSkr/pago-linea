package com.example.demo.Services;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.Dto.Order;
import com.example.demo.Util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class OrderService {
	String data = "[\r\n"
			+ "    {\r\n"
			+ "        \"status\": true,\r\n"
			+ "        \"totalPriceIva\": 109150,\r\n"
			+ "        \"priceHome\": 8000,\r\n"
			+ "        \"dateCreate\": \"2021-04-03T20:00:00.004+00:00\",\r\n"
			+ "        \"id\": 1,\r\n"
			+ "        \"name\": \"Andres\",\r\n"
			+ "        \"address\": \"11# 14-08\",\r\n"
			+ "        \"cc\": 123,\r\n"
			+ "        \"totalPrice\": 85000.0,\r\n"
			+ "        \"items\": [\r\n"
			+ "            {\r\n"
			+ "                \"id\": 1,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"shoes \",\r\n"
			+ "                \"price\": 15000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 2,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"jean\",\r\n"
			+ "                \"price\": 20000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 3,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"T-shirt\",\r\n"
			+ "                \"price\": 50000\r\n"
			+ "            }\r\n"
			+ "        ]\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"status\": true,\r\n"
			+ "        \"totalPriceIva\": 160650,\r\n"
			+ "        \"priceHome\": 0.0,\r\n"
			+ "        \"dateCreate\": \"2021-04-03T12:15:09.004+00:00\",\r\n"
			+ "        \"id\": 2,\r\n"
			+ "        \"name\": \"Jhohan\",\r\n"
			+ "        \"address\": \"11# 14-08\",\r\n"
			+ "        \"cc\": 456,\r\n"
			+ "        \"totalPrice\": 135000.0,\r\n"
			+ "        \"items\": [\r\n"
			+ "            {\r\n"
			+ "                \"id\": 1,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"shoes \",\r\n"
			+ "                \"price\": 15000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 2,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"jean\",\r\n"
			+ "                \"price\": 20000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 3,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"T-shirt\",\r\n"
			+ "                \"price\": 50000\r\n"
			+ "            },\r\n"
			+ "             {\r\n"
			+ "                \"id\": 4,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"T-shirt man\",\r\n"
			+ "                \"price\": 50000\r\n"
			+ "            }\r\n"
			+ "        ]\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"status\": true,\r\n"
			+ "        \"totalPriceIva\": 91300,\r\n"
			+ "        \"priceHome\": 8000,\r\n"
			+ "        \"dateCreate\": \"2021-04-03T08:15:09.004+00:00\",\r\n"
			+ "        \"id\": 3,\r\n"
			+ "        \"name\": \"Julian\",\r\n"
			+ "        \"address\": \"11# 14-08\",\r\n"
			+ "        \"cc\": 789,\r\n"
			+ "        \"totalPrice\": 70000.0,\r\n"
			+ "        \"items\": [\r\n"
			+ "            {\r\n"
			+ "                \"id\": 1,\r\n"
			+ "                \"quantity\": 2,\r\n"
			+ "                \"name\": \"shoes \",\r\n"
			+ "                \"price\": 15000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 2,\r\n"
			+ "                \"quantity\": 2,\r\n"
			+ "                \"name\": \"jean\",\r\n"
			+ "                \"price\": 20000\r\n"
			+ "            }\r\n"
			+ "        ]\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "        \"status\": true,\r\n"
			+ "        \"totalPriceIva\": 109150,\r\n"
			+ "        \"priceHome\": 8000,\r\n"
			+ "        \"dateCreate\": \"2021-04-03T02:15:09.004+00:00\",\r\n"
			+ "        \"id\": 4,\r\n"
			+ "        \"name\": \"Nataly\",\r\n"
			+ "        \"address\": \"11# 14-08\",\r\n"
			+ "        \"cc\": 741,\r\n"
			+ "        \"totalPrice\": 85000.0,\r\n"
			+ "        \"items\": [\r\n"
			+ "            {\r\n"
			+ "                \"id\": 1,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"shoes \",\r\n"
			+ "                \"price\": 15000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 2,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"jean\",\r\n"
			+ "                \"price\": 20000\r\n"
			+ "            },\r\n"
			+ "            {\r\n"
			+ "                \"id\": 3,\r\n"
			+ "                \"quantity\": 1,\r\n"
			+ "                \"name\": \"T-shirt\",\r\n"
			+ "                \"price\": 50000\r\n"
			+ "            }\r\n"
			+ "        ]\r\n"
			+ "    }\r\n"
			+ "]"; 
	
	Gson gson = new Gson();
	
	Type listType = new TypeToken<ArrayList<Order>>(){}.getType();
	ArrayList<Order> OrderReq = gson.fromJson(data, listType);
	
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

			Order orderAddRecent = GetOrderId(orderVirificated.getId());

			return orderAddRecent;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Order orderAddRecent = null;
			return orderAddRecent;
		}
	}

	public List<Order> GetOrder() {
		return OrderReq.stream().filter(p -> p.getStatus()).collect(Collectors.toList());
	}

	public List<Order> GetOrderCC(int cc) {
		try {
			return OrderReq.stream().filter(p -> p.getCc() == cc).collect(Collectors.toList());
		} catch (Exception e) {
			List<Order> order = null;
			return order;
		}

	}

	public Order GetOrderId(int id) {
		try {
			/*return OrderData;*/
			return OrderReq.stream().filter(p -> p.getId() == id).findFirst().get();
		} catch (Exception e) {
			Order order = null;
			return order;
		}

	}

	public Order UpdateOrder(boolean swDate, boolean swPrice, Order orderFind, Order orderVirificated) {

		if (swDate && swPrice) {
			boolean swDelteOrder = OrderReq.remove(orderFind);
			if (swDelteOrder) {
				Order orderUpdated = SaveOrder(orderVirificated);
				return orderUpdated;
			}
		}
		Order order = null;
		return order;
	}

	public boolean DeleteOrder(Order orderDelete) {
	
		boolean swDelteOrder = OrderReq.remove(orderDelete);
		if (!swDelteOrder) {
			return false;
		}
		return true;
	}
	
	public Order saveOrderDelete(Order orderDelete) {
		Double totalPrice10 = 0.0;
		totalPrice10 = util.calculatePrice10(orderDelete.getTotalPriceIva());
		orderDelete.setTotalPriceIva(totalPrice10);
		orderDelete.setStatus(false);
		
		return  orderDelete;
	}
	
	
	
	
	
	

}
