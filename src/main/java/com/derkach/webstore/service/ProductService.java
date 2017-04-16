package com.derkach.webstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.derkach.webstore.dao.ProductsDaoImpl;
import com.derkach.webstore.domain.Category;
import com.derkach.webstore.domain.Producer;
import com.derkach.webstore.domain.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductsDaoImpl daoImpl;
	
	public List<Product> searchProduct( Product product){
		return daoImpl.searchProduct(product);
	}

	public List<Product> editProduct( Product product){
		return daoImpl.editProduct(product);
	}
	
	public void deleteProduct( Product product){
		 daoImpl.deleteProduct(product);
	}
	
	public List<Product> findAll(){
		return daoImpl.findAll();
	}
	
	public List<Product> searchProductByCategory(String string){
		return daoImpl.searchProductByCategory(string);
	}
	
	public void updateProduct( Product product){
		 daoImpl.updateProduct(product);
	}

}
