package com.upwork.propman.auth;

/*
@Component
@Order(1)
public class ApiKeyRequestFilter implements Filter{/*extends GenericFilterBean {

	private static final Logger LOG = LoggerFactory.getLogger(ApiKeyRequestFilter.class);

	@Autowired
	private ApiKeyService apiKeyService;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		String username = req.getHeader("username");
		String key = req.getHeader("key");

		if (key.equals(apiKeyService.getKey("username"))) {

			LOG.info("Key validated successfully");
			chain.doFilter(request, response);

		} else {

			HttpServletResponse resp = (HttpServletResponse) response;

			String error = "Invalid Username or API KEY";

			LOG.info(error);
			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.setContentLength(error.length());
			response.getWriter().write(error);
		}

	}
}*/