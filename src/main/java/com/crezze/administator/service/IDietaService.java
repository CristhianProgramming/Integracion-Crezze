package com.crezze.administator.service;

import java.util.List;

import com.crezze.administator.models.DietaModel;

public interface IDietaService {

	DietaModel createDieta(DietaModel dieta);
	
	List<DietaModel> obtenerMisDietas();
	
	DietaModel actualizarDieta(DietaModel dieta,Long id);
	
	DietaModel eliminarDieta(Long id);
}
