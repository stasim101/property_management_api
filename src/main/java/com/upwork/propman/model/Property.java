package com.upwork.propman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String city;
	private String locality;
	private String address;
	private String contact;
	private boolean approved;

	public Property(String city, String locality, String address, String contact, boolean approved) {
		this.city = city;
		this.locality = locality;
		this.address = address;
		this.contact = contact;
		this.approved = approved;
	}

	public Property() {
	}

	
	public int getId() {
		return id;
	}

	public String getCity() {
		return city;
	}

	public String getLocality() {
		return locality;
	}

	public String getAddress() {
		return address;
	}

	public String getContact() {
		return contact;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

}
