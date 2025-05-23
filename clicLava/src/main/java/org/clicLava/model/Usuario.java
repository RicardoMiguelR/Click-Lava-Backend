package org.clicLava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellidos;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String telefono;
	@Column(nullable = false)
	private String fechaRegistro;
	@Column(nullable = false)
	private Long idRol;
		
	// 1. Constructor
	public Usuario(String nombre, String apellidos, String email, String password, String telefono,
			String fechaRegistro, Long idRol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
		this.idRol = idRol;
	} // constructor
	
	public Usuario() {
	} // constructor vacio

	// 2. Getter and Setters
	public String getNombre() {
		return nombre;
	} // getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} // setNombre
	
	public String getApellidos() {
		return apellidos;
	} // getApellidos

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	} // setApellidos

	public String getEmail() {
		return email;
	} // getEmail

	public void setEmail(String email) {
		this.email = email;
	} // setEmail

	public String getPassword() {
		return password;
	} // getPassword

	public void setPassword(String password) {
		this.password = password;
	} // setPassword

	public String getTelefono() {
		return telefono;
	} // getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} // setTelefono

	public String getFechaRegistro() {
		return fechaRegistro;
	} // getFechaRegistro

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	} // setFechaRegistro

	public Long getIdRol() {
		return idRol;
	} // getIdRol
	
	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	} // setIdRol
	
	public Long getId() {
		return id;
	} // getId

	// 3. toString()
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + ", idRol="
				+ idRol + "]";
	}

	
} // Usiario 
