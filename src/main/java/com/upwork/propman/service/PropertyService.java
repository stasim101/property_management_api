package com.upwork.propman.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.propman.model.Property;
import com.upwork.propman.repository.PropertyRepository;

@Service
public class PropertyService {

	private static final Logger LOG = LoggerFactory.getLogger(PropertyService.class);

	@Autowired
	private PropertyRepository propertyRepository;

	public int addNewProperty(Property property) {
		LOG.info("Added new property");
		return propertyRepository.save(property).getId();		
	}

	public int modifyExistingProperty(int id, Property property) {

		Optional<Property> propertyOptional = propertyRepository.findById(id);

		if (!propertyOptional.isPresent())
			return 0;

		Property existingPropertyObject = propertyOptional.get();

		if (!existingPropertyObject.getCity().equals(property.getCity()))
			existingPropertyObject.setCity(property.getCity());

		if (!existingPropertyObject.getAddress().equals(property.getAddress()))
			existingPropertyObject.setCity(property.getAddress());

		if (!existingPropertyObject.getContact().equals(property.getContact()))
			existingPropertyObject.setCity(property.getContact());

		if (!existingPropertyObject.getLocality().equals(property.getLocality()))
			existingPropertyObject.setCity(property.getLocality());

		propertyRepository.save(existingPropertyObject);
		LOG.info("Given property updated");
		return existingPropertyObject.getId();
	}

	public String approveExistingProperty(int id) {

		Optional<Property> retreivedOptional = propertyRepository.findById(id);
		Property retreived = null;

		if (!retreivedOptional.isPresent()) {
			LOG.info("Invalid ID provided for approval");
			return "INVALID ID";
		}
		retreived = retreivedOptional.get();
		retreived.setApproved(true);
		propertyRepository.save(retreived);
		LOG.info("Property Approved: "+id);
		return "APPROVED";
	}

	public Property search(int id) {
		LOG.info("Searching property: "+id);

		Optional<Property> optionalProperty = propertyRepository.findById(id);

		if (optionalProperty.isPresent()) {
			LOG.info("Found property: "+id);
			return optionalProperty.get();			
		}
		
		LOG.info("Could not found property: "+id);
		return null;
	}

}
