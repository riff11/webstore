package com.derkach.webstore.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "producers")
// @XmlAccessorType (XmlAccessorType.classclassFIELD)
public class Producers {
	

	private ArrayList<Producer> producers = null;

	public ArrayList<Producer> getProducers() {
		return producers;
	}

	@XmlElement(name = "list")
	public void setProducers(ArrayList<Producer> producers) {
		this.producers = producers;
	}

}
