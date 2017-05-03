package com.derkach.webstore.domain;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="producer")
// @XmlAccessorType(XmlAccessType)

public class Producer {

	private Integer id;
	private String name;
	
	

	public Producer() {
		super();
	}

	public Producer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	/*@XmlElement(name="id")*/
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	/*@XmlElement(name="name")*/
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Producer [id=" + id + ", name=" + name + "]";
	}

}
