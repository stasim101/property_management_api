package com.upwork.propman.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.upwork.propman.model.ApiKey;

@SpringBootTest
class ApiKeyRepositoryTest {

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	@Test
	void testFindByKey() {
		
		apiKeyRepository.save(new ApiKey("testUser", "testKey"));
		Optional<ApiKey> optionalApiKey = apiKeyRepository.findByKey("testKey");

		if (optionalApiKey.isPresent())
			assertTrue(optionalApiKey.get().getKey().equals("testKey"));

	}

}
