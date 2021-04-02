package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private long id;
    private int quantity;
    private String name;
    private long price;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("quantity")
    public int getQuantity() { return quantity; }
    @JsonProperty("quantity")
    public void setQuantity(int value) { this.quantity = value; }

    
    
    @JsonProperty("price")
    public long getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(long value) { this.price = value; }
}
