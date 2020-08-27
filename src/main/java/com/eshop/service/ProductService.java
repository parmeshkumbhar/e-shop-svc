package com.eshop.service;

import java.util.ArrayList;
import java.util.List;

import com.eshop.dao.ProductDao;
import com.eshop.model.Product;
import com.eshop.model.ProductWithDiscountPrice;

public class ProductService {
	private ProductDao productDao;

	public ProductService() {
		this.productDao = new ProductDao();
	}

	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		return productDao.getProductsByCategory(category);
	}

	public List<Product> getProductsByCategoryAndLessThanPriceAndGreaterThanPrice(String category, int lessThanPrice,
			int greaterThanPrice) {
		return productDao.getProductsByCategoryAndLessThanPriceAndGreaterThanPrice(category, lessThanPrice, greaterThanPrice);
	}

	public List<Product> getProductsByCompany(String company) {
		return productDao.getProductsByCompany(company);
	}

	public List<Product> getProductsByCompanyAndLessThanPriceAndGreaterThanPrice(String company, int lessThanPrice,
			int greaterThanPrice) {
		return productDao.getProductsByCompanyAndLessThanPriceAndGreaterThanPrice(company, lessThanPrice,
				greaterThanPrice);
	}

	public List<ProductWithDiscountPrice> getDiscountedPriceByCategory(String category) {
		List<Product> products = productDao.getProductsByCategory(category);
		List<ProductWithDiscountPrice> discountPrices = new ArrayList<>();
		if(products != null && products.size()>0) {
			for(Product product : products) {
				ProductWithDiscountPrice productWithDiscountPrice = new ProductWithDiscountPrice();
				productWithDiscountPrice.setCategory(product.getCategory());
				productWithDiscountPrice.setCompany(product.getCompany());
				productWithDiscountPrice.setProduct(product.getProduct());
				productWithDiscountPrice.setColor(product.getColor());
				double discoutPrice = (product.getPrice()*product.getDiscount())/100;
				productWithDiscountPrice.setDiscountedPrice(discoutPrice);
				discountPrices.add(productWithDiscountPrice);
			}
		}
		return discountPrices;
	}
}
