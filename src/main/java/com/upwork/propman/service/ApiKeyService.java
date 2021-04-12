package com.upwork.propman.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upwork.propman.model.ApiKey;
import com.upwork.propman.repository.ApiKeyRepository;

@Service
public class ApiKeyService {

	private static final Logger LOG = LoggerFactory.getLogger(ApiKeyService.class);

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public String generateKey(String username) {

		String status = "Key not generated for " + username;
		String key = getRandomAlphaNumeric();
		storeKey(username, key);
		status = "Key for " + username + " is " + key;
		LOG.info(status);
		return status;

	}

	public String storeKey(String username, String key) {

		String status = "Key not stored for " + username;
		ApiKey apiKey = apiKeyRepository.save(new ApiKey(username, key));
		status = "Key stored for " + username + " in DB.";
		LOG.info(status);
		return status;

	}

	public boolean validateKey(String key) {
		Optional<ApiKey> optionalApiKey = apiKeyRepository.findByKey(key);

		if (optionalApiKey.isPresent())
			return optionalApiKey.get().getKey().equals(key);

		return false;
	}

	public String getRandomAlphaNumeric() {
		// count is the length of random string to create.
		int count = 10;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
