package org.xmen.devapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author David.Garay
 */
@RestController
public class IndexController {

	@GetMapping("/")
	public String defaultPath() {
		return "Welcome to the X-Men API, use the Requests defined in Postman Collection to test ;)"; 
	}
	
}
