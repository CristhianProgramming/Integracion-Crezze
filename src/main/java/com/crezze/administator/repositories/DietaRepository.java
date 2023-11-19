package com.crezze.administator.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crezze.administator.models.DietaModel;
import com.crezze.administator.models.UserModel;

public interface DietaRepository  extends CrudRepository<DietaModel, Long>{

	List<DietaModel> findAllByUsuario(UserModel usuario);

}
