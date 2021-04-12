package com.upwork.propman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.propman.model.Property;
import com.upwork.propman.service.ApiKeyService;
import com.upwork.propman.service.PropertyService;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private ApiKeyService apiKeyService;

	@PutMapping(value = "/new")
	public int createProperty(@RequestBody Property property) {
		return propertyService.addNewProperty(property);
	}

	@PatchMapping("/update/{id}")
	public int updateProperty(@PathVariable("id") int id, @RequestBody Property property) {
		return propertyService.modifyExistingProperty(id, property);
	}

	@PatchMapping("/approve/{id}")
	public String approveProperty(@PathVariable("id") int id) {
		return propertyService.approveExistingProperty(id);
	}

	@GetMapping(value = "/search/{id}")
	public Property searchProperty(@PathVariable("id") int id) {
		return propertyService.search(id);
	}

	@PutMapping(value = "/generateKey/{username}")
	public String createApiKey(@PathVariable String username) {
		return apiKeyService.generateKey(username);
	}

}
