package org.clicLava.controller;

import java.util.List;

import org.clicLava.model.Usuario;
import org.clicLava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/usuario/")  // http://localhost:8080/api/usuario/
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	} // constructor 

	@GetMapping
	public List<Usuario> getProductos() {
		return usuarioService.getUsuarios();
	}
	
	@GetMapping(path = "{idUsuario}") // Traer un solo usuario por su ID
	// http://localhost:8080/api/usuario/1
	public Usuario getUsuario(@PathVariable("idUsuario") Long idUsuario) {
		return usuarioService.getUsuario(idUsuario);
	} // getUsuario
	
	@DeleteMapping(path = "{idUsuario}") // Traer un solo usuario por su ID
	// http://localhost:8080/api/idUsuario/1
	public Usuario deleteUsuario(@PathVariable("idUsuario") Long idUsuario) {
		return usuarioService.deleteUsuario(idUsuario);
	} // deleteUsuario
	
	@PostMapping // Agregar un solo usuario 
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.addUsuario(usuario);
	} // addUsuario
	
	@PutMapping(path = "{idUsuario}") // Modificar un usuario 
	public Usuario updateUsuario(@PathVariable("idUsuario") Long idUsuario, 
			@RequestParam(required = false) String nombre, 
			@RequestParam(required = false) String apellidos, 
			@RequestParam(required = false) String email, 
			@RequestParam(required = false) String password, 
			@RequestParam(required = false) String telefono, 
			@RequestParam(required = false) String fechaRegistro, 
			@RequestParam(required = false) Integer idRol) {
		return usuarioService.updateUsiario(idUsuario, nombre, apellidos, email, password, telefono, fechaRegistro, idRol);
	} // updateUsuario
	
} // UsuarioController
