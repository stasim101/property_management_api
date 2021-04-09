package com.upwork.propman.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.upwork.propman.model.Property;

@DataJpaTest
class PropertyRepositoryTest {

	@Autowired
	private PropertyRepository propertyRepository;

	@Test
	void testSearch() {

		propertyRepository
				.save(new Property("New Delhi", "New Friends Colony", "888, Second Floor", "+919611111111", true));
		propertyRepository
				.save(new Property("New Delhi", "New Friends Colony", "345, Second Floor", "+919611111111", true));
		propertyRepository
				.save(new Property("New Delhi", "New Friends Colony", "3, Second Floor", "+919611111111", true));
		propertyRepository.save(new Property("New Delhi", "Greater Kailash", "1", "+919111111111", true));
		propertyRepository.save(new Property("New York", "West Village", "42, Perry Street", "+12121111111", true));
		propertyRepository.save(new Property("New York", "West Village", "12", "+12121111111", true));

		propertyRepository.save(new Property("London", " Bermondsey Square", "6-7", "+02080123342", true));
		propertyRepository.save(
				new Property("Paris", " RESIDENCES HARCOURT", "8 Rue Jean du Bellay, 4th arr", "+33109758351", true));

		List<Property> list = (List<Property>) propertyRepository.search("New Delhi", "New Friends Colony");
		assertThat(list).size().isEqualTo(3);

		list = (List<Property>) propertyRepository.search("New York", "West Village");
		assertThat(list).size().isEqualTo(2);

		propertyRepository.deleteAll();
	}

}
