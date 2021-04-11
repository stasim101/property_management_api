package com.upwork.propman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApiKey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(unique = true)
	private String username;
	private String key;

	public ApiKey(String username, String key) {
		this.username = username;
		this.key = key;
	}

	public ApiKey() {
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getKey() {
		return key;
	}

}
