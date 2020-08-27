package com.eshop.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class ProductWithDiscountPrice {
	private String category;
	private String company;
	private String product;
	private String color;
	private double discountedPrice;
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
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
}
