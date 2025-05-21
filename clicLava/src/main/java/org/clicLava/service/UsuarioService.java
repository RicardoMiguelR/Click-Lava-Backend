package org.clicLava.service;

import java.util.ArrayList;
import java.util.List;

import org.clicLava.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class UsuarioService {
	
private final List<Usuario> lista = new ArrayList<Usuario>();
	
	@Autowired
	public UsuarioService() {
		// String nombre, String apellidos, String email, String password, String telefono, String fechaRegistro
		lista.add(new Usuario("Peter", "Parker", "pparker@email.com", "RGUpp/kYdAPZ8U/J/snzvrtpQuHHijz4oDxwHf3SaJuDzxkGKEm0aOyFqdDRqRRmEZLvMPBddBzCVnVLh9v0AA==", "5512345678", "2025-05-16 00:00:00", 1));
		lista.add(new Usuario("Ruby", "Sunday", "rsunday@email.com", "FX1uK8PqQGDCfqKaNozGgLAtlrfmlQReR+gtAmwpp7GLwn2o3HuJXG6j2Nzujt6dg4BlKDZijf70zIn/+RRbDw==", "5509876543", "2025-05-16 00:00:00", 2));
		lista.add(new Usuario("Jack", "Harkness", "jharkness@email.com", "6/Pt5gtPUoZ4pJlsSg+5wppgJQUyhu6sSUBcF39fRRegbV1BUxTImJslEnaf2PNiz9L/vphXtwBpXCgg09Xj/g==", "5512345678", "2025-05-16 00:00:00", 2));
		lista.add(new Usuario("Rose", "Taylor", "rtaylor@email.com", "kje+jCXn0FLrB9hzKzLc+sbMTsVInYPrrz5iyqkaKZaBbbCGkrknwPtlTK7d09sg54sJBURUDih3SXLQMXqcLw==", "5524681357", "2025-05-16 00:00:00", 2));
		lista.add(new Usuario("Clara", "Oswald", "coswald@email.com", "2NnAUfxdAv/9Qu30I64smIVNlYbPGVUui2f0I+oRco1/Nu4vEgnjLriWN8kXHGnN7P0HiEj9yZQkvl7j2aLsIA==", "5597532468", "2025-05-16 00:00:00", 1));
	} // constructor
	
	public List<Usuario> getUsuarios() {
		return lista;
	}

	public Usuario getUsuario(Long idUsuario) {
		Usuario tmp = null;
		for (Usuario usuario : lista) {
			if (usuario.getIdUsuario() == idUsuario) {
				tmp = usuario;
				break;
			} // if
		} // foreach
		return tmp;
	} // getProduct

	public Usuario deleteUsuario(Long idUsuario) {
		Usuario tmp = null;
		for (Usuario usuario : lista) {
			if (usuario.getIdUsuario() == idUsuario) {
				tmp = usuario;
				lista.remove(usuario);
				break;
			} // if
		} // foreach
		return tmp;
	} // deleteProduct

	public Usuario addUsuario(Usuario usuario) {
		lista.add(usuario);
		return usuario;
	} // addProduct

	public Usuario updateUsiario(Long idUsuario, String nombre, String apellidos, String email, String password, String telefono,
			String fechaRegistro, Integer idRol) {
		Usuario tmp = null;
		for (Usuario usuario : lista) {
			if (usuario.getIdUsuario() == idUsuario) {
				if (nombre != null) usuario.setNombre(nombre);
				if (apellidos != null) usuario.setApellidos(apellidos);
				if (email != null) usuario.setEmail(email);
				if (password != null) usuario.setPassword(password);
				if (telefono != null) usuario.setTelefono(telefono);
				if (fechaRegistro != null) usuario.setFechaRegistro(fechaRegistro);
				if (idRol != null) usuario.setIdRol(idRol);
				tmp = usuario;
				break;
			} // if
		} // foreach
		return tmp;
	} // updateUsiario
	
} // UsuarioService
