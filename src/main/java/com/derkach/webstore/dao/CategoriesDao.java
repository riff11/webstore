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

	void editCategory(Category category);
	
	void deleteCategory(Category category);
	
	List<Category> findAll();
	
	void addCategory(Category category);
	
	public List<Category> findRoot();
	
	public List<Category> findSiblings(int i);

}
