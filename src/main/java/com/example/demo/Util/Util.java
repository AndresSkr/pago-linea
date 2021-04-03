package com.example.demo.Util;

import java.util.List;

import com.example.demo.Dto.Item;
import com.example.demo.Dto.Order;

public class Util {

	public Order VerifyPriceToSave(Order order) {

		Double priceCalculated = 0.0;
		Order orderVerify = null;
		List<Item> itemsOrder = order.getItems();
		for (Item item : itemsOrder) {
			priceCalculated += item.getPrice() * item.getQuantity();
		}
		order.setTotalPrice(priceCalculated);
		orderVerify = order;
		return orderVerify;
	}

	public boolean VerifyCc(int ccOrder, int ccUrl, Order order) {

		if (ccOrder == ccUrl && ccUrl == order.getCc())
			return true;
		else
			return false;
	}

	public boolean VerifyDate(Order order, Order orderFind, int hour) {

		long diff = order.getDateCreate().getTime() - orderFind.getDateCreate().getTime();
		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000);

		System.out.println(diffSeconds + " " + diffMinutes + " " + diffHours);

		if (diffHours > hour)
			return false;
		else
			return true;

	}

	public boolean VerifyPriceToEdit(Order order, Order orderFind) {

		if (order.getTotalPrice() >= orderFind.getTotalPrice())
			return true;
		else
			return false;
	}

	public Double calculatePrice10(Double price) {
		return price * 0.10;
	}

}
