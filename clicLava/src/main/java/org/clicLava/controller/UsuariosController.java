package org.clicLava.controller;

import java.util.List;

import org.clicLava.dto.ChangePassword;
import org.clicLava.model.Usuario;
import org.clicLava.service.UsuariosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/usuarios/")  // http://localhost:8080/api/usuario/
public class UsuariosController {
	
	private final UsuariosService usuariosService;
	
	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		this.usuariosService = usuariosService;
	} // constructor 

	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuariosService.getUsuarios();
	} // getUsuarios
	
	@GetMapping(path = "{id}") // Traer un solo usuario por su ID
	// http://localhost:8080/api/usuario/1
	public Usuario getUsuario(@PathVariable("id") Long id) {
		return usuariosService.getUsuario(id);
	} // getUsuario
	
	@DeleteMapping(path = "{id}") // Traer un solo usuario por su ID
	// http://localhost:8080/api/idUsuario/1
	public Usuario deleteUsuario(@PathVariable("id") Long id) {
		return usuariosService.deleteUsuario(id);
	} // deleteUsuario
	
	@PostMapping // Agregar un solo usuario 
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuariosService.addUsuario(usuario);
	} // addUsuario
	
	@PutMapping(path = "{id}") // Modificar un usuario 
	public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody ChangePassword changePassword) {
		return usuariosService.updateUsuario(id, changePassword);
	} // updateUsuario
	
} // UsuarioController
