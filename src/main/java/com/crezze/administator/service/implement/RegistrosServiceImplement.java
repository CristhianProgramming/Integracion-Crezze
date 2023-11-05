package com.crezze.administator.service.implement;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.crezze.administator.models.RegistrosModel;
import com.crezze.administator.models.UserModel;
import com.crezze.administator.repositories.IRegistrosDao;
import com.crezze.administator.repositories.IUserDao;
import com.crezze.administator.service.IRegistrosService;

@Service
public class RegistrosServiceImplement implements IRegistrosService {

	@Autowired private IRegistrosDao registroDao;
	@Autowired private IUserDao userDao;
	
	@Override
	public RegistrosModel createRegistro(Double peso, Double altura) {
		RegistrosModel saveRegistro = new RegistrosModel(getUserId(),peso,altura);
		return registroDao.save(saveRegistro);
	}

	@Override
	public List<RegistrosModel> obtenerRegistros(Date from, Date late) {
		
		return (List<RegistrosModel>) registroDao.findAllByUser(getUserId());
	}
	
	private UserModel getUserId() {
		String nombreUsuario = SecurityContextHolder.getContext().getAuthentication().getName();
		var usuario = userDao.findByUsername(nombreUsuario);
		return usuario;
	}

}
