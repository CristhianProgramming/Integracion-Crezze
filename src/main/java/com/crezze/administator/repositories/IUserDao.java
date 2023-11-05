package com.crezze.administator.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.crezze.administator.models.UserModel;

@Repository
public interface IUserDao extends CrudRepository<UserModel, Long>{

	UserModel findByUsername(String username);

}
