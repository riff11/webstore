package com.derkach.webstore.dao;

import java.util.List;

import com.derkach.webstore.domain.Product;

/**
 * Dao interface product.
 * 
 * @author alex
 * 
 */
public interface ProductsDao {

	List<Product> searchProduct(Product product);

	List<Product> searchProduct(int id);

	void editProduct(Product product);

	void deleteProduct(int integer);

	void addProduct(Product product);

	// void updateProduct(Product product);

	List<Product> findAll();

	List<Product> searchProductByCategory(int i);

	List<Product> filter(boolean available);

	List<Product> filter(int min, int max);

	List<Product> filter(int category_fk, boolean available);

	List<Product> filter(int category_fk, int min, int max);

	List<Product> filter(int min, int max, boolean available);

	List<Product> filter(int category_fk, int min, int max, boolean available);
}
