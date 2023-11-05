package com.crezze.administator.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crezze.administator.models.UserModel;
import com.crezze.administator.repositories.IUserDao;

@Service
public class jpaUserDetailService implements UserDetailsService{

	@Autowired private IUserDao dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = dao.findByUsername(username);
		
		List<GrantedAuthority> authorizations = new ArrayList<GrantedAuthority>();
		

		if (user == null) {
			throw new UsernameNotFoundException("usuario no encontrado");
		}
		
		authorizations.add(new SimpleGrantedAuthority(user.getRol()));
		
		return new User(user.getUsername(), user.getPassword(), true, true, true, true,authorizations);
	
	}
	
}
