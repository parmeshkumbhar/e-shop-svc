package com.eshop.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.eshop.model.Product;
import com.eshop.model.ProductWithDiscountPrice;
import com.eshop.service.ProductService;

@Path("/product")
public class ProductResource {
	private ProductService productService;

	public ProductResource() {
		this.productService = new ProductService();
	}

	@GET
	@Path("/all-products")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GET
	@Path("/products-by-category")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByCategory(@QueryParam("category") String category) {
		return productService.getProductsByCategory(category);
	}

	@GET
	@Path("/products-by-category-less-than-price-and-greater-than-price")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByCategoryAndLessThanPriceAndGreaterThanPrice(
			@QueryParam("category") String category, @QueryParam("lessThanPrice") int lessThanPrice,
			@QueryParam("greaterThanPrice") int greaterThanPrice) {
		return productService.getProductsByCategoryAndLessThanPriceAndGreaterThanPrice(category, lessThanPrice,
				greaterThanPrice);
	}
	
	@GET
	@Path("/products-by-company")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByCompany(@QueryParam("company") String company) {
		return productService.getProductsByCompany(company);
	}

	@GET
	@Path("/products-by-company-less-than-price-and-greater-than-price")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductsByCompanyAndLessThanPriceAndGreaterThanPrice(
			@QueryParam("company") String company, @QueryParam("lessThanPrice") int lessThanPrice,
			@QueryParam("greaterThanPrice") int greaterThanPrice) {
		return productService.getProductsByCompanyAndLessThanPriceAndGreaterThanPrice(company, lessThanPrice,
				greaterThanPrice);
	}
	
	@GET
	@Path("/discounted-price-by-category")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductWithDiscountPrice> getDiscountedPriceByCategory(@QueryParam("category") String category) {
		return productService.getDiscountedPriceByCategory(category);
	}
}
