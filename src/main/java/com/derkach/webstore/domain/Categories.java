package com.derkach.webstore.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "categories")
public class Categories {

	private ArrayList<Category> categories = null;

	public ArrayList<Category> getCategories() {
		return categories;
	}

	@XmlElement(name = "list")
	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

}
