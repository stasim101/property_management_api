package com.upwork.propman.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.upwork.propman.model.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, Integer> {

	@Query("select p from Property p where p.city = ?1 and p.locality = ?2")
	List<Property> search(String city, String locality);

}
