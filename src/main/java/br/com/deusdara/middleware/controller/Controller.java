package br.com.deusdara.middleware.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deusdara.middleware.filter.ApplicationFilter;
import br.com.deusdara.middleware.model.Pacient;

@RestController
@RequestMapping(path = "v1")
public class Controller {
	Logger logger = LoggerFactory.getLogger(ApplicationFilter.class);
	
	@GetMapping(path = "/test1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getTestMiddleware() {
		logger.info("Controller test1");
		return ResponseEntity.ok().body("Test Middleware 1");
	}
	
	@GetMapping(path = "/test2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> getTestMiddleware2() {
		logger.info("Controller test2");
		return ResponseEntity.ok().body("Test Middleware 2");
	}

	@PostMapping(path = "/test3", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<Pacient> getTestMiddleware3(@RequestBody Pacient body) {
		logger.info("Controller test3");
		return ResponseEntity.ok().body(body);
	}
}
