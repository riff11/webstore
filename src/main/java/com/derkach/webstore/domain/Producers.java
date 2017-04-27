package com.derkach.webstore.domain;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "producer")
// @XmlAccessorType (XmlAccessorType.classclassFIELD)
public class Producers {

	private ArrayList<Producer> producers = null;

	public ArrayList<Producer> getProducers() {
		return producers;
	}

	@XmlElement(name = "employee")
	public void setProducers(ArrayList<Producer> producers) {
		this.producers = producers;
	}

}
