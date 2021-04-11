package com.upwork.propman.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

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
		int saved = propertyService.addNewProperty(in);
		Optional<Property> retreivedOptional = propertyRepository.findById(saved);
		Property out = retreivedOptional.get();
		assertEquals(in.getAddress(), out.getAddress());
		assertThat(saved).isPositive();
		assertEquals(in.getId(), out.getId());
		propertyRepository.deleteAll();
	}

	@Test
	void testModifyExistingProperty() {
		Property in = new Property("New York", "West Village", "12", "+12121111111", true);
		int saved = propertyService.addNewProperty(in);
		Optional<Property> retreivedOptional = propertyRepository.findById(saved);
		Property retreived = null;

		if (retreivedOptional.isPresent())
			retreived = retreivedOptional.get();

		Property test = new Property("New York", "West Village", "122222", "+12121111111", true);
		int s = propertyService.modifyExistingProperty(saved, test);
		assertEquals(retreived.getId(), s);
	}

	@Test
	void testApproveExistingProperty() {
		Property in = new Property("New York", "West Village", "12", "+12121111111", false);
		int id = propertyService.addNewProperty(in);
		String out = propertyService.approveExistingProperty(id);
		assertEquals("APPROVED", out);
		propertyRepository.deleteAll();
	}

	@Test
	void testSearchExistingProperty() {
		Property ins = new Property("New York", "West Village", "12", "+12121111111", true);
		int id = propertyService.addNewProperty(ins);
		Property retreived = propertyService.search(id);

		assertEquals("New York", retreived.getCity());
		assertEquals("West Village", retreived.getLocality());
		assertEquals("12", retreived.getAddress());
		assertEquals("+12121111111", retreived.getContact());
		assertTrue(retreived.isApproved());
	}

}
