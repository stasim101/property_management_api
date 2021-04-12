package com.upwork.propman.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.upwork.propman.repository.ApiKeyRepository;

@SpringBootTest
class ApiKeyServiceTest {

	@Autowired
	private ApiKeyService apiKeyService;

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	@Test
	void testGenerateKey() {
		String username = "testUser";
		String expected = "Key for " + username + " is ";
		assertTrue(apiKeyService.generateKey(username).contains(expected));
		apiKeyRepository.deleteAll();
	}

	@Test
	void testStoreKey() {
		String username = "testUser";
		String expected = "Key stored for " + username + " in DB.";
		String actual = apiKeyService.storeKey(username, "testKey");
		assertTrue(expected.equals(actual));
		apiKeyRepository.deleteAll();
	}

	@Test
	void testValidateKey() {
		apiKeyService.storeKey("testUser", "4F6D83MH54");
		assertTrue(apiKeyService.validateKey("4F6D83MH54"));
		apiKeyRepository.deleteAll();
	}

	@Test
	void testGetRandomAlphaNumeric() {
		String s = apiKeyService.getRandomAlphaNumeric();
		assertTrue(s.length() == 10);
		assertFalse(s.length() == 23232);
	}

}
