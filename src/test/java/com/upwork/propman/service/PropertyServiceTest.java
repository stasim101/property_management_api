package com.upwork.propman.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.propman.model.Property;
import com.upwork.propman.repository.PropertyRepository;

@SpringBootTest
class PropertyServiceTest {

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private PropertyRepository propertyRepository;

	@Test
	void testAddNewProperty() {
		Property in = new Property("New York", "West Village", "12", "+12121111111", true);
		boolean saved = propertyService.addNewProperty(in);
		List<Property> list = propertyService.searchExistingProperty(in.getCity(), in.getLocality());
		Property out = list.get(0);
		assertEquals(in.getAddress(), out.getAddress());
		assertTrue(saved);
		propertyRepository.deleteAll();
	}

	@Test
	void testModifyExistingProperty() {

	}

	@Test
	void testApproveExistingProperty() {
		Property in = new Property("New York", "West Village", "12", "+12121111111", true);
		propertyService.addNewProperty(in);
		propertyService.approveExistingProperty("New York", "West Village", "12");
		List<Property> list = propertyService.searchExistingProperty("New York", "West Village");
		Property out = list.get(0);
		assertTrue(out.isApproved());
		propertyRepository.deleteAll();		
	}

	@Test
	void testSearchExistingProperty() {
		Property in = new Property("New York", "West Village", "12", "+12121111111", true);
		propertyService.addNewProperty(in);
		List<Property> list = propertyService.searchExistingProperty(in.getCity(), in.getLocality());
		Property out = list.get(0);
		assertEquals(in.getAddress(), out.getAddress());
		propertyRepository.deleteAll();
	}

}
