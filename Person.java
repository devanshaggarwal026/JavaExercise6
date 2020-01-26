package com.robomq.pojo;

public class Person {
	
	private int id ,price ,  qty ;
	private String name , description ;
	public Person() {
		super();
	}
	public Person(int id, int price, int qty, String name, String description) {
		super();
		this.id = id;
		this.price = price;
		this.qty = qty;
		this.name = name;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", price=" + price + ", qty=" + qty + ", name=" + name + ", description="
				+ description + "]";
	}
	
	
}
