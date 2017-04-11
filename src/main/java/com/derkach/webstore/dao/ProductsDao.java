package com.derkach.webstore.dao;


import java.util.List;

import com.derkach.webstore.domain.Product;


/**
 * dao interface
 * @author alex
 *
 */
public interface ProductsDao {

	void searchCategory(Product Product);

	List<Product> editCategory(Product Product);
	
	void deleteCategory(Product Product);
	
	List<Product> findAll();
	
	void updateCategory(Product Product);

}
