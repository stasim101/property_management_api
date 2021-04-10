package com.upwork.propman.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.propman.model.Property;
import com.upwork.propman.repository.PropertyRepository;

@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;

	public int addNewProperty(Property property) {
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

		return existingPropertyObject.getId();
	}

	public String approveExistingProperty(int id) {

		Optional<Property> retreivedOptional = propertyRepository.findById(id);
		Property retreived = null;

		if (!retreivedOptional.isPresent())
			return "INVALID ID";

		retreived = retreivedOptional.get();
		retreived.setApproved(true);
		propertyRepository.save(retreived);

		return "APPROVED";
	}

	public Property search(int id) {
		Optional<Property> optionalProperty = propertyRepository.findById(id);
		if (optionalProperty.isPresent())
			return optionalProperty.get();
		return null;
	}

}
