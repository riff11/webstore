package com.derkach.webstore.domain;


public class Product {
	
	private Integer id;
	private String name;
	private String price;
	private String description;
	private String image;
	private String available;
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
			String image, String available, Integer producer_fk,
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getProducer_fk() {
		return producer_fk;
	}
	public void setProducer_fk(Integer producer_fk) {
		this.producer_fk = producer_fk;
	}
	public Integer getCategories_fk() {
		return categories_fk;
	}
	public void setCategories_fk(Integer categories_fk) {
		this.categories_fk = categories_fk;
	}
	
	
	
	

}
