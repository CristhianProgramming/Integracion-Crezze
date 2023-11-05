package com.crezze.administator.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crezze.administator.models.UserModel;
import com.crezze.administator.repositories.IUserDao;
import com.crezze.administator.service.IUserService;

@Service
public class UserServiceImplement implements IUserService{

	@Autowired private IUserDao daoUser;
	@Autowired private PasswordEncoder encoder;
	
	@Override
	public UserModel registro(UserModel userModel) {
		userModel.setRol("USER");
		userModel.setPassword(encoder.encode(userModel.getPassword()));
		return daoUser.save(userModel);
	}

}
