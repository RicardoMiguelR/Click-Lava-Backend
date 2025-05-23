package org.clicLava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRol",  nullable = false)
	private Long id;
	
	@Column(name = "nombreRol", nullable = false)
	private String rol;
	
	
	public Rol(String rol) {
        this.rol = rol;
	}
	
	public Rol() {
		
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", rol=" + rol + "]";
	}
	
	
}