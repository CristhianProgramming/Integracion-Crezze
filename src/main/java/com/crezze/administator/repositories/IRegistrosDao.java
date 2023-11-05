package com.crezze.administator.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.crezze.administator.models.RegistrosModel;
import com.crezze.administator.models.UserModel;

public interface IRegistrosDao extends CrudRepository<RegistrosModel, Long>{

	List<RegistrosModel> findAllByUser(UserModel usuario);
}
