package com.derkach.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derkach.webstore.dao.CategoriesDaoImpl;
import com.derkach.webstore.domain.Category;

@Service
public class CategoryService {

	@Autowired
	CategoriesDaoImpl categoriesDaoImpl;

	public List<Category> searchCategoriesByParentsId(String categoryId) {
		return categoriesDaoImpl.searchCategoriesByParentsId(categoryId);
	}

	public List<Category> editCategory(Category category) {
		return categoriesDaoImpl.editCategory(category);
	}

	public void deleteCategory(Category category) {
		categoriesDaoImpl.deleteCategory(category);
	}

	public List<Category> findAll() {
		return categoriesDaoImpl.findAll();
	}

	public List<Category> findRoot() {
		return categoriesDaoImpl.findRoot();
	}

	public void updateCategory(Category category) {
		categoriesDaoImpl.updateCategory(category);
	}

	public List<Category> findSiblings(int i) {
		return categoriesDaoImpl.findSiblings(i);
	}

}
