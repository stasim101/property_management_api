package com.upwork.propman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.upwork.propman.service.ApiKeyService;

@Component
public class PropCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ApiKeyService apiKeyService;

	@Override
	public void run(String... args) throws Exception {

		apiKeyService.storeKey("admin", "4F6D83MH53");

	}

}
