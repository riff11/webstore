package com.derkach.webstore.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "products")
public class Products {
	
	private ArrayList<Product> products = null;

	public ArrayList<Product> getProducts() {
		return products;
	}
	@XmlElement(name = "list")
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
}
