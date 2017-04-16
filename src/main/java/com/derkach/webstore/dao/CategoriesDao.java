package com.derkach.webstore.dao;


import java.util.List;


import com.derkach.webstore.domain.Category;
/**
 * dao interface
 * @author alex
 *
 */
public interface CategoriesDao {

	List<Category> searchCategoriesByParentsId(String categoryId);

	List<Category> editCategory(Category category);
	
	void deleteCategory(Category category);
	
	List<Category> findAll();
	
	void updateCategory(Category category);
	
	public List<Category> findRoot();

}
