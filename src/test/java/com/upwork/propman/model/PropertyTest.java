package com.upwork.propman.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.propman.repository.PropertyRepository;

@SpringBootTest
class PropertyTest {

	private String city = "New Delhi";
	private String locality = "New Friends Colony";
	private String address = "House no.-3, First floor";
	private String contact = "+919999999999";
	private boolean approved = true;

	@Autowired
	private PropertyRepository propertyRepository;

	@Test
	void testProperty() {

		Property property = new Property(city, locality, address, contact, approved);

		assertEquals(city, property.getCity());
		assertEquals(locality, property.getLocality());
		assertEquals(address, property.getAddress());
		assertEquals(contact, property.getContact());
		assertTrue(property.isApproved());

	}

	@Test
	void testGetId() {

		Property property = new Property(city, locality, address, contact, approved);
		Property p = propertyRepository.save(property);
		assertThat(p.getId()).isPositive();
		propertyRepository.deleteAll();

	}

	@Test
	void testGetCity() {

		Property property = new Property(city, locality, address, contact, approved);
		assertEquals(city, property.getCity());

	}

	@Test
	void testGetLocality() {

		Property property = new Property(city, locality, address, contact, approved);
		assertEquals(locality, property.getLocality());

	}

	@Test
	void testGetAddress() {

		Property property = new Property(city, locality, address, contact, approved);
		assertEquals(address, property.getAddress());

	}

	@Test
	void testGetContact() {

		Property property = new Property(city, locality, address, contact, approved);
		assertEquals(contact, property.getContact());

	}

	@Test
	void testIsApproved() {

		Property property = new Property(city, locality, address, contact, approved);
		assertTrue(property.isApproved());

	}

	@Test
	void testSetCity() {

		Property property = new Property();
		property.setCity("Bengaluru");
		assertEquals("Bengaluru", property.getCity());

	}

	@Test
	void testSetLocality() {

		Property property = new Property();
		property.setLocality("White fields");
		assertEquals("White fields", property.getLocality());

	}

	@Test
	void testSetAddress() {

		Property property = new Property();
		property.setAddress("Plot No. 23, Whitefield Road, EPIP Zone");
		assertEquals("Plot No. 23, Whitefield Road, EPIP Zone", property.getAddress());

	}

	@Test
	void testSetContact() {

		Property property = new Property();
		property.setContact("918043311555");
		assertEquals("918043311555", property.getContact());

	}

	@Test
	void testSetApproved() {

		Property property = new Property();
		property.setApproved(true);
		assertTrue(property.isApproved());

	}

}
