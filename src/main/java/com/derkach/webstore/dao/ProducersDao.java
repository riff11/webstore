package com.derkach.webstore.dao;


import java.util.List;

import com.derkach.webstore.domain.Producer;


/**
 * dao interface
 * @author alex
 *
 */
public interface ProducersDao {

	void searchCategory(Producer Producer);

	List<Producer> editCategory(Producer Producer);
	
	void deleteCategory(Producer Producer);
	
	List<Producer> findAll();
	
	void updateCategory(Producer Producer);

}
