package com.crezze.administator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crezze.administator.models.DietaModel;
import com.crezze.administator.service.IDietaService;

@RestController
@RequestMapping("/v1/crezze")
public class DietaController {

	@Autowired
	private IDietaService dietaService;

	@GetMapping("/dietas")
	ResponseEntity<?> getDietas() {
		return ResponseEntity.ok(dietaService.obtenerMisDietas());
	}

	@PostMapping("/dieta")
	ResponseEntity<?> crearDieta(@RequestBody DietaModel payload) {
		try {
			var dieta = dietaService.createDieta(payload);
			return ResponseEntity.status(HttpStatus.CREATED).body(dieta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@PutMapping("/dieta/{id}")
	ResponseEntity<?> actualziarDieta(@RequestBody DietaModel payload, @PathVariable Long id) {
		try {
			var dieta = dietaService.actualizarDieta(payload, id);
			return ResponseEntity.status(HttpStatus.CREATED).body(dieta);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@DeleteMapping("/dieta/{id}")
	ResponseEntity<?> eliminarDieta(@PathVariable Long id) {
		try {
			dietaService.eliminarDieta(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

		}

	}

}
