package com.crezze.administator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crezze.administator.Exceptions.UserNotRegisterException;
import com.crezze.administator.models.UserModel;
import com.crezze.administator.service.IUserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private IUserService seviceUser;


	@PostMapping("/register")
	ResponseEntity<?> register(@RequestBody UserModel payload) throws UserNotRegisterException {

		try {
			seviceUser.registro(payload);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(new responses("good", "Usuario Creado Correctamente"));
		} catch (Exception e) {
			seviceUser.registro(payload);
			return ResponseEntity.badRequest().body(new responses("bad", e.getMessage()));
		}

	}

	
	
	private record responses(String status, String message) {
	};

}
