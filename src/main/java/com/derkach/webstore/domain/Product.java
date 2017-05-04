package com.derkach.webstore.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {
	
	private Integer id;
	private String name;
	private String price;
	private String description;
	private String image;
	private String producer;
	private String category;
	private Boolean available;
	private Integer producer_fk;
	private Integer categories_fk;
	
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @param description
	 * @param image
	 * @param available
	 * @param producer_fk
	 * @param categories_fk
	 */
	public Product(Integer id, String name, String price, String description,
			String image, Boolean available, Integer producer_fk,
			Integer categories_fk) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.available = available;
		this.producer_fk = producer_fk;
		this.categories_fk = categories_fk;
	}
	
	public Product(Integer id, String name, String price, String description,
			String image, Boolean available, String producer,
			String category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.available = available;
		this.producer = producer;
		this.category= category;
	}
	
	
	public Product() {
		super();
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", description=" + description + ", image=" + image
				+ ", available=" + available + ", producer_fk=" + producer_fk
				+ ", categories_fk=" + categories_fk + "]";
	}
	
	

	public String getProducer() {
		return producer;
	}
	@XmlElement(name = "producer")
	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCategory() {
		return category;
	}
	@XmlElement(name = "category")
	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}
	@XmlElement(name = "id")
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	@XmlElement(name = "price")
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getAvailable() {
		return available;
	}
	@XmlElement(name = "available")
	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getImage() {
		return image;
	}
	@XmlElement(name = "image")
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getProducer_fk() {
		return producer_fk;
	}
	@XmlElement(name = "producer_fk")
	public void setProducer_fk(Integer producer_fk) {
		this.producer_fk = producer_fk;
	}
	public Integer getCategories_fk() {
		return categories_fk;
	}
	@XmlElement(name = "categories_fk")
	public void setCategories_fk(Integer categories_fk) {
		this.categories_fk = categories_fk;
	}
}
