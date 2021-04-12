package com.upwork.propman.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.propman.repository.ApiKeyRepository;

@SpringBootTest
class ApiKeyTest {

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	@Test
	void testGetId() {

		ApiKey apiKey = apiKeyRepository.save(new ApiKey("testUser", "testKey"));
		Optional<ApiKey> optionalApiKey = apiKeyRepository.findByKey("testKey");
		ApiKey actual = null;
		if (optionalApiKey.isPresent())
			actual = optionalApiKey.get();
		assertEquals(apiKey.getId(), actual.getId());
		apiKeyRepository.deleteAll();
	}

	@Test
	void testGetUsername() {

		ApiKey apiKey = apiKeyRepository.save(new ApiKey("testUser", "testKey"));
		Optional<ApiKey> optionalApiKey = apiKeyRepository.findById(apiKey.getId());
		ApiKey actual = null;
		if (optionalApiKey.isPresent())
			actual = optionalApiKey.get();
		assertEquals(apiKey.getUsername(), actual.getUsername());
		apiKeyRepository.deleteAll();

	}

	@Test
	void testGetKey() {

		ApiKey apiKey = apiKeyRepository.save(new ApiKey("testUser", "testKey"));
		Optional<ApiKey> optionalApiKey = apiKeyRepository.findById(apiKey.getId());
		ApiKey actual = null;
		if (optionalApiKey.isPresent())
			actual = optionalApiKey.get();
		assertEquals(apiKey.getKey(), actual.getKey());
		apiKeyRepository.deleteAll();
		
	}

}
