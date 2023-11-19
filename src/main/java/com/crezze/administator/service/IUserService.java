package com.crezze.administator.service;

import com.crezze.administator.Exceptions.UserNotRegisterException;
import com.crezze.administator.models.UserModel;

public interface IUserService {
	
	UserModel registro(UserModel userModel) throws UserNotRegisterException;
	
	
}
