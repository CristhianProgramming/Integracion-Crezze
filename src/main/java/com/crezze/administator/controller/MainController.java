package com.crezze.administator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/prueba")
	ResponseEntity<?> prueba(){
		return ResponseEntity.ok(":)");
	}
}
