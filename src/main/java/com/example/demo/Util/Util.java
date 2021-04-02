package com.example.demo.Util;

import com.example.demo.Dto.Order;

public class Util {
	
	public boolean VerifyDate(Order order,Order orderFind) {
		
		long diff = order.getDateCreate().getTime() - orderFind.getDateCreate().getTime(); 
		long diffSeconds = diff / 1000 % 60; 
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000);

		System.out.println(diffSeconds+" "+diffMinutes+" "+diffHours);
		
		if (diffHours > 5)
			return false;
		else
			return true;

	}

}
