package com.crezze.administator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crezze.administator.service.IRegistrosService;

@RestController
@RequestMapping("/v1/crezze")
public class RegisterController {

	@Autowired private IRegistrosService registroService;
	
	@GetMapping("/registro")
	ResponseEntity<?> obtenerRegistros(){
		return ResponseEntity.ok(registroService.obtenerRegistros(null, null));
	}
	
	@PostMapping("/registro")
	ResponseEntity<?> generarRegistros(@RequestBody registroNuevo payload){
		try {
			var registro = registroService.createRegistro(payload.peso, payload.altura);
			return ResponseEntity.ok("Se registro el progeso del usuario"+registro.getUser().getUsername());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
	
	private record registroNuevo (Double peso,Double altura) {};
}
