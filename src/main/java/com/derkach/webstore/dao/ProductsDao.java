package com.derkach.webstore.dao;


import java.util.List;

import com.derkach.webstore.domain.Category;
import com.derkach.webstore.domain.Product;


/**
 * Dao interface.
 * @author alex
 *
 */
public interface ProductsDao {

	List<Product> searchProduct( Product product);

	List<Product> editProduct( Product product);
	
	List<Product> searchProductByCategory( Integer i);
	
	void deleteProduct( Product product);
	
	List<Product> findAll();
	
	void updateProduct( Product product);
	

}
