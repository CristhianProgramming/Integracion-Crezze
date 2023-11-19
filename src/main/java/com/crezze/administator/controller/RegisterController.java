package com.crezze.administator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crezze.administator.service.IRegistrosService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/crezze")
public class RegisterController {

	@Autowired
	private IRegistrosService registroService;

	@GetMapping("/registro")
	ResponseEntity<?> obtenerRegistros() {
		return ResponseEntity.ok(registroService.obtenerRegistros(null, null));
	}

	@PostMapping("/registro")
	ResponseEntity<?> generarRegistros(@RequestBody registroNuevo payload) {
		try {
			var registro = registroService.createRegistro(payload.peso, payload.altura);
			return ResponseEntity.ok("Se registro el progeso del usuario" + registro.getUser().getUsername());
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("/elimnar/{id}")
	ResponseEntity<?> eliminarRegistro(@PathVariable Long id) {
		var RegistroEliminado = registroService.eliminarRegistro(id);
		if (RegistroEliminado.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body("Eliminado correctamente");
		}
		return ResponseEntity.badRequest().body(null);
	}

	private record registroNuevo(Double peso, Double altura) {
	};
}
