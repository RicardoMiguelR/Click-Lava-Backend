package org.clicLava.model;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRol", nullable = false)
	private Long id;
	
	@Column(name = "nombreRol", nullable = false)
	private String rol;
	
	// Relación inversa con Usuario
	@JsonManagedReference(value = "usuario-rol")
	@OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Usuario> usuarios;
	
	public Rol(String rol) {
		this.rol = rol;
	}
	
	public Rol() {}

	public Long getId() {
		return id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", rol=" + rol + "]";
	}
}