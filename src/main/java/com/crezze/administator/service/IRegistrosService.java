package com.crezze.administator.service;

import java.util.Date;
import java.util.List;

import com.crezze.administator.models.RegistrosModel;

public interface IRegistrosService {
	
	RegistrosModel createRegistro(Double peso , Double altura);
	
	List<RegistrosModel> obtenerRegistros(Date from , Date late);
	
}
