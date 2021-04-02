package com.example.demo.response;

import com.example.demo.Dto.Order;

public class responseOrder {

	private String message;
	private int status;
	private Order order;

	public responseOrder(String message, int status, Order order) {
		super();
		this.message = message;
		this.status = status;
		this.order = order;
	}

	public responseOrder() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
