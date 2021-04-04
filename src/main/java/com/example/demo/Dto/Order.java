package com.example.demo.Dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
	private int id;
	private boolean status;
	private String name;
	private String address;
	private int cc;
	private Double totalPrice;
	private Double totalPriceIva;
	private Double priceHome;
	private List<Item> items;
	private Date dateCreate;

	public Order() {
		super();
		this.dateCreate = new Date();
		this.status = true;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean value) {
		this.status = value;
	}

	@JsonProperty("id")
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(int value) {
		this.id = value;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String value) {
		this.name = value;
	}

	@JsonProperty("cc")
	public int getCc() {
		return cc;
	}

	@JsonProperty("cc")
	public void setCc(int value) {
		this.cc = value;
	}

	@JsonProperty("address")
	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String value) {
		this.address = value;
	}

	public Double getTotalPriceIva() {
		return totalPriceIva;
	}

	public void setTotalPriceIva(Double value) {
		this.totalPriceIva = value;
	}

	public Double getPriceHome() {
		return priceHome;
	}

	public void setPriceHome(Double value) {
		this.priceHome = value;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date value) {
		this.dateCreate = value;
	}

	@JsonProperty("totalPrice")
	public Double getTotalPrice() {
		return totalPrice;
	}

	@JsonProperty("totalPrice")
	public void setTotalPrice(Double value) {
		this.totalPrice = value;
	}

	@JsonProperty("items")
	public List<Item> getItems() {
		return items;
	}

	@JsonProperty("items")
	public void setItems(List<Item> value) {
		this.items = value;
	}
}
