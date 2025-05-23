package org.clicLava.service;

import java.util.List;
import java.util.Optional;

import org.clicLava.dto.ChangePassword;
import org.clicLava.model.Usuario;
import org.clicLava.repository.UsuariosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service 
public class UsuariosService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	private final UsuariosRepository usuariosRepository;
	
	@Autowired
	public UsuariosService(UsuariosRepository usuariosRepository) {
		this.usuariosRepository = usuariosRepository;
	} // constructor
	
	public List<Usuario> getUsuarios() {
		return usuariosRepository.findAll();
	} // getUsuarios

	public Usuario getUsuario(Long id) {
		return usuariosRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El usuario con el id [ " + id + " ] no existe.")
				);
	} // getUsuario

	public Usuario deleteUsuario(Long id) {
		Usuario user = null;
		if (usuariosRepository.existsById(id)) {
			user = usuariosRepository.findById(id).get();
			usuariosRepository.deleteById(id);
		} // if exists
		return user;
	} // deleteUsuario

	public Usuario addUsuario(Usuario usuario) {
		Optional<Usuario> user = usuariosRepository.findByEmail(usuario.getEmail());
		if (user.isEmpty()) {
			usuario.setPassword(encoder.encode(usuario.getPassword()));
			return usuariosRepository.save(usuario);
		} else {
			return null;
		} // if isEmpty
	} // addUsuario

	public Usuario updateUsuario(Long id, ChangePassword changePassword) {
		Usuario user = null;
		if (usuariosRepository.existsById(id)) {
			user = usuariosRepository.findById(id).get();
			if (encoder.matches(changePassword.getPassword(), user.getPassword())) {
				user.setPassword(encoder.encode(changePassword.getNpassword()));
				usuariosRepository.save(user);
			} else {
				user = null;
			} // if matches 
		} // if exists
		return user;
	} // updateUsiario
	
} // UsuarioService
