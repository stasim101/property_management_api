package com.upwork.propman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.upwork.propman.model.Property;
import com.upwork.propman.service.PropertyService;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

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

}
