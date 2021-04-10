package com.upwork.propman.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.propman.model.Property;
import com.upwork.propman.repository.PropertyRepository;

@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;

	public boolean addNewProperty(Property property) {
		propertyRepository.save(property);
		return true;
	};

	public int modifyExistingProperty(Property property) {
		return 0;
	}

	public int approveExistingProperty(String city, String locality,String address) {
		List<Property> list = propertyRepository.search(city, locality);
		for (Property property : list) {
			if(property.getAddress().equals(address.trim())) {
				property.setApproved(true);
				propertyRepository.save(property);
				break;
			}
		}
		return 0;
	};

	public List<Property> searchExistingProperty(String city, String locality) {
		List<Property> list = propertyRepository.search(city, locality);
		return list;
	};

}
