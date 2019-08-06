package br.com.deusdara.middleware.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ApplicationFilter implements Filter {
	Logger logger = LoggerFactory.getLogger(ApplicationFilter.class);

	@Override
	public void doFilter(ServletRequest request, javax.servlet.ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		logger.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
		logger.info("User {}", req.getUserPrincipal().getName());

		logger.info("-> chain");
		chain.doFilter(request, response);
		logger.info("chain ->");
		
		logger.info("Logging Response :{}", res.getContentType());
	}
}