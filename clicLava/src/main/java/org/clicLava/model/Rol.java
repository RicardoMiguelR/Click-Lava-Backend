package org.clicLava.model;

public class Rol {
	private Long id;
	private String rol;
	private static Long totalRol = Long.valueOf(0);
	
	
	public Rol(String rol) {
		Rol.totalRol++;
        this.id = Rol.totalRol;
        this.rol = rol;
	}
	
	public Rol() {
		Rol.totalRol++;
		this.id = Rol.totalRol;
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
