package com.eshop.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.jdbi.v3.core.Jdbi;

import com.eshop.model.Product;
import com.opentable.db.postgres.embedded.EmbeddedPostgres;

public class ProductDao {
	private static Jdbi jdbi;

	static {
		// i am writting here connection creation logic because we are using
		// in-memory database;
		EmbeddedPostgres pg;
		Connection connection;
		try {
			// Postgre in-memory database Connection with Jdbi
			pg = EmbeddedPostgres.start();
			connection = pg.getPostgresDatabase().getConnection();
			jdbi = Jdbi.create(connection);

			// Creating table and dummy records
			createTableAndInsertRecords();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ProductDao() {
	}

	// inside this method i have created table and inserted dummy records
	public static void createTableAndInsertRecords() {
		jdbi.withHandle(handle -> {
			handle.execute(
					"CREATE TABLE products (id INTEGER PRIMARY KEY, category VARCHAR, company VARCHAR, product VARCHAR, color VARCHAR, description VARCHAR,"
							+ "price INT, discount INT, no_of_items_in_stock INT)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(1, 'Mobiles', 'Apple', 'AP1', 'Black', 'Some description about AP1',70000 ,13,11)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(2, 'Mobiles','Samsung','SP1','Grey','Some description about SP1',50000,2,2)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(3, 'Mobiles','MI','MP1','Black','Some description about MP1',20000,9,35)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(4, 'Computers','Intel','IL1','Grey','Some description about IL1',67000,0,106)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(5, 'Computers','Intel','IL2','Black','Some description about IL2',74000,6,300)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(6, 'Computers','Lenovo','LL1','Black','Some description about LL2',80000,10,138)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(7, 'Television','LG','LT1','Black','Some description about LT1',42500,8,62)");

			handle.execute(
					"INSERT INTO products (id, category, company, product, color, description, price, discount, no_of_items_in_stock)"
							+ "VALUES(8, 'Television','Samsung','ST1','Grey','Some description about ST1',58360,16,168)");

			return null;
		});
	}

	public List<Product> getAllProducts() {
		List<Product> products = jdbi.withHandle(handle -> {
			return handle.createQuery(
					"SELECT id, category, company, product, color, description, price, discount, no_of_items_in_stock FROM products")
					.mapToBean(Product.class).list();
		});

		return products;
	}

	public List<Product> getProductsByCategory(String category) {
		List<Product> products = jdbi.withHandle(handle -> {
			return handle.createQuery(
					"SELECT id, category, company, product, color, description, price, discount, no_of_items_in_stock FROM products WHERE category = :category")
					.bind("category", category)
					.mapToBean(Product.class).list();
		});

		return products;
	}

	public List<Product> getProductsByCategoryAndLessThanPriceAndGreaterThanPrice(String category, int lessThanPrice,
			int greaterThanPrice) {
		List<Product> products = jdbi.withHandle(handle -> {
			return handle.createQuery(
					"SELECT id, category, company, product, color, description, price, discount, no_of_items_in_stock FROM products WHERE category = :category AND price < :lessThanPrice AND price > :greaterThanPrice")
					.bind("category", category)
					.bind("lessThanPrice", lessThanPrice)
					.bind("greaterThanPrice", greaterThanPrice)
					.mapToBean(Product.class).list();
		});

		return products;
	}

	public List<Product> getProductsByCompany(String company) {
		List<Product> products = jdbi.withHandle(handle -> {
			return handle.createQuery(
					"SELECT id, category, company, product, color, description, price, discount, no_of_items_in_stock FROM products WHERE company = :company")
					.bind("company", company)
					.mapToBean(Product.class).list();
		});

		return products;
	}

	public List<Product> getProductsByCompanyAndLessThanPriceAndGreaterThanPrice(String company, int lessThanPrice,
			int greaterThanPrice) {
		List<Product> products = jdbi.withHandle(handle -> {
			return handle.createQuery(
					"SELECT id, category, company, product, color, description, price, discount, no_of_items_in_stock FROM products WHERE company = :company AND price < :lessThanPrice AND price > :greaterThanPrice")
					.bind("company", company)
					.bind("lessThanPrice", lessThanPrice)
					.bind("greaterThanPrice", greaterThanPrice)
					.mapToBean(Product.class).list();
		});

		return products;
	}
}
