package com.eshop.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Product {
	private int id;
	private String category;
	private String company;
	private String product;
	private String color;
	private String description;
	private double price;
	private double discount;
	private int noOfItemInStock;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getNoOfItemInStock() {
		return noOfItemInStock;
	}

	public void setNoOfItemInStock(int noOfItemInStock) {
		this.noOfItemInStock = noOfItemInStock;
	}

}
