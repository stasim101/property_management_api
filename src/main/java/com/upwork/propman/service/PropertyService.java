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

	public int approveExistingProperty(String city, String locality, String address) {
		List<Property> list = propertyRepository.search(city, locality);
		for (Property property : list) {
			if (property.getAddress().equals(address.trim())) {
				property.setApproved(true);
				propertyRepository.save(property);
				break;
			}
		}
		return 0;
	}

	public List<Property> searchExistingProperty(String city, String locality) {
		List<Property> list = propertyRepository.search(city, locality);
		return list;
	};

}
