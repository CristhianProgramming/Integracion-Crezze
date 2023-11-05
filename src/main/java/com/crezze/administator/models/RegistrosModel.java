package com.crezze.administator.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity(name = "registros_users")
public class RegistrosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	private UserModel user;
	
	private Double peso;
	
	private Double altura;
	
	private Date fechaRegistro;

	public RegistrosModel() {
	}

	public RegistrosModel(UserModel user, Double peso, Double altura) {
		super();
		this.user = user;
		this.peso = peso;
		this.altura = altura;
	}

	@PrePersist
	public void actualizarFecha() {
		fechaRegistro =new Date();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonIgnore
	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	
}
