package com.crezze.administator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crezze.administator.models.UserModel;
import com.crezze.administator.service.IUserService;

@RestController
@RequestMapping("/v1/auth")
public class MainController {

	@Autowired IUserService seviceUser;
	
	@PostMapping("/register")
	ResponseEntity<?> register(@RequestBody UserModel payload){
		
		try {
			seviceUser.registro(payload);
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
	
}
