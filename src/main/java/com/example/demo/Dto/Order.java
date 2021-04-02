package com.example.demo.Dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
		private String name;
		private String address;
	    private int cc;
	    private long totalPrice;
	    private List<Item> items;

	    @JsonProperty("name")
	    public String getName() { return name; }
	    @JsonProperty("name")
	    public void setName(String value) { this.name = value; }

	    @JsonProperty("cc")
	    public int getCc() { return cc; }
	    @JsonProperty("cc")
	    public void setCc(int value) { this.cc = value; }

	   
	    @JsonProperty("address")
	    public String getaddress() { return address; }
	    @JsonProperty("address")
	    public void setaddress(String value) { this.address = value; }

	    @JsonProperty("totalPrice")
	    public long getTotalPrice() { return totalPrice; }
	    @JsonProperty("totalPrice")
	    public void setTotalPrice(long value) { this.totalPrice = value; }

	    @JsonProperty("items")
	    public List<Item> getItems() { return items; }
	    @JsonProperty("items")
	    public void setItems(List<Item> value) { this.items = value; }
}
