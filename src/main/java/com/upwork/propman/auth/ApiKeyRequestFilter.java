package com.upwork.propman.auth;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.upwork.propman.service.ApiKeyService;

@Component
@Order(1)
public class ApiKeyRequestFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(ApiKeyRequestFilter.class);

	@Autowired
	private ApiKeyService apiKeyService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (!apiKeyService.validateKey(((HttpServletRequest) request).getHeader("X-API-KEY"))) {

			String error = "Invalid API KEY";
			LOG.info(error);
			HttpServletResponse resp = (HttpServletResponse) response;

			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentLength(error.length());
			response.getWriter().write(error);

		} else {

			LOG.info("Key validated successfully");
			chain.doFilter(request, response);

		}
	}
}
