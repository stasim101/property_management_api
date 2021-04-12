package com.upwork.propman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.upwork.propman.repository.ApiKeyRepository;
import com.upwork.propman.repository.PropertyRepository;
import com.upwork.propman.service.ApiKeyService;

@Component
public class PropCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ApiKeyService apiKeyService;

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public void run(String... args) throws Exception {

		apiKeyRepository.deleteAll();
		propertyRepository.deleteAll();
		apiKeyService.storeKey("admin", "4F6D83MH53");

	}

}
