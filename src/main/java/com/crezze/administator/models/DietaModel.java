package com.crezze.administator.models;

import com.crezze.administator.models.enums.Semana;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "dieta", uniqueConstraints = { @UniqueConstraint(columnNames = { "dia", "usuario" }) })

public class DietaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Semana dia;
	private String descripcion;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario")
	@JsonIgnore
	private UserModel usuario;


	public DietaModel() {
	
	}

	public DietaModel(Semana dia, String descripcion) {
		this.dia = dia;
		this.descripcion = descripcion;
	}

	public UserModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UserModel usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Semana getDia() {
		return dia;
	}

	public void setDia(Semana dia) {
		this.dia = dia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
