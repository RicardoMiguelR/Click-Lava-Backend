package org.clicLava.model;

public class Usuario {
	
	private Long idUsuario;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private String telefono;
	private String fechaRegistro;
	private Integer idRol;
	private static Long total = Long.valueOf(0); // "Herramienta" para crear el contador y asignarlo al id
	
	// 1. Constructor
	public Usuario(String nombre, String apellidos, String email, String password, String telefono,
			String fechaRegistro, Integer idRol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
		this.idRol = idRol;
		Usuario.total ++; // Incrementamos el contador
		this.idUsuario = Usuario.total;
	} // constructor
	
	public Usuario() {
		Usuario.total ++; // Incrementamos el contador
		this.idUsuario = Usuario.total;
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

	public Integer getIdRol() {
		return idRol;
	} // getIdRol
	
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	} // setIdRol
	
	public Long getIdUsuario() {
		return idUsuario;
	} // getId

	// 3. toString()
	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
				+ ", password=" + password + ", telefono=" + telefono + ", fechaRegistro=" + fechaRegistro + ", idRol="
				+ idRol + "]";
	}

	
} // Usiario 
