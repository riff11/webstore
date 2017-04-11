package com.derkach.webstore.dao;


import java.util.List;


import com.derkach.webstore.domain.Category;
/**
 * dao interface
 * @author alex
 *
 */
public interface CategoriesDao {

	void searchCategory(Category user);

	List<Category> editCategory(Category user);
	
	void deleteCategory(Category user);
	
	List<Category> findAll();
	
	void updateCategory(Category user);

}
