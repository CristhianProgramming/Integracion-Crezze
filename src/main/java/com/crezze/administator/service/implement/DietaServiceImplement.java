package com.crezze.administator.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.crezze.administator.models.DietaModel;
import com.crezze.administator.models.UserModel;
import com.crezze.administator.repositories.DietaRepository;
import com.crezze.administator.repositories.IUserDao;
import com.crezze.administator.service.IDietaService;

@Service
public class DietaServiceImplement implements IDietaService {

	@Autowired
	private DietaRepository daoDieta;
	@Autowired
	private IUserDao userDao;

	@Override
	public DietaModel createDieta(DietaModel dieta) {
		dieta.setUsuario(getUserId());
		return daoDieta.save(dieta);
	}

	@Override
	public List<DietaModel> obtenerMisDietas() {
		return daoDieta.findAllByUsuario(getUserId());
	}

	@Override
	public DietaModel actualizarDieta(DietaModel dieta, Long id) {
		Optional<DietaModel> existDieta = daoDieta.findById(id);

		if (existDieta.isEmpty()) {
			throw new Error("La dieta no se encuentra registrada para ser modificada");
		}

		DietaModel modDieta = existDieta.get();

		if (dieta.getDia() != modDieta.getDia()) {
			modDieta.setDia(dieta.getDia());
		}

		if (dieta.getDescripcion() != modDieta.getDescripcion()) {
			modDieta.setDescripcion(dieta.getDescripcion());
		}

		return modDieta;
	}

	@Override
	public DietaModel eliminarDieta(Long id) {
		Optional<DietaModel> existDieta = daoDieta.findById(id);

		if (existDieta.isEmpty()) {
			throw new Error("La dieta no se encuentra registrada para ser eliminada");
		}

		daoDieta.deleteById(id);

		return existDieta.get();
	}

	private UserModel getUserId() {
		String nombreUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
		var usuario = userDao.findByUsername(nombreUsuario);
		return usuario;
	}
}
