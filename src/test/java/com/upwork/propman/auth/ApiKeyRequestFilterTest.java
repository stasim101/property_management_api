package com.upwork.propman.auth;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

@SpringBootTest
class ApiKeyRequestFilterTest {

	@Mock
	private ApiKeyRequestFilter apiKeyRequestFilter;

	@Test
	void testDoFilter() throws Exception {
		MockHttpServletRequest req = new MockHttpServletRequest();
		MockHttpServletResponse res = new MockHttpServletResponse();
		MockFilterChain chain = new MockFilterChain();
		req.addHeader("username", "admin");
		req.addHeader("key", "4F6D83MH53");

		try {
			apiKeyRequestFilter.doFilter(req, res, chain);
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
	}

}
