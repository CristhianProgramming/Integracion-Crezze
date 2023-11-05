package com.crezze.administator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.crezze.administator.authentication.jpaUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private jpaUserDetailService validationsByJpa;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable());
		return http.build();
	}

	void configure(AuthenticationManagerBuilder authorizations) throws Exception {
		authorizations.userDetailsService(validationsByJpa).passwordEncoder(passwordEncoder);
	}

}