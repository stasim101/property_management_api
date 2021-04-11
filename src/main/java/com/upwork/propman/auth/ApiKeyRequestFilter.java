package com.upwork.propman.auth;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.upwork.propman.model.ApiKey;
import com.upwork.propman.repository.ApiKeyRepository;

@Component
public class ApiKeyRequestFilter extends GenericFilterBean {

	private static final Logger LOG = LoggerFactory.getLogger(ApiKeyRequestFilter.class);

	@Autowired
	private ApiKeyRepository apiKeyRepository;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String username = req.getHeader("username");
		String key = req.getHeader("key");

		Optional<ApiKey> optionalApiKey = apiKeyRepository.findByUsername(username);

		if (optionalApiKey.isPresent() && key.equals(optionalApiKey.get().getKey())) {
			chain.doFilter(request, response);
		} else {

			HttpServletResponse resp = (HttpServletResponse) response;

			String error = "Invalid Username or API KEY";

			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentLength(error.length());
			response.getWriter().write(error);
		}

	}
}