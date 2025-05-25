package org.clicLava.controller;

import java.util.List;

import org.clicLava.dto.ChangePassword;
import org.clicLava.dto.UsuarioDTO;
import org.clicLava.model.Usuario;
import org.clicLava.service.UsuariosService;
import org.clicLava.util.DTOConverter;

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
    public List<UsuarioDTO> getUsuarios() {
        List<Usuario> usuarios = usuariosService.getUsuarios();
        return DTOConverter.convertToUsuarioDTOList(usuarios);
    } // getUsuarios
    
    @GetMapping(path = "{id}") // Traer un solo usuario por su ID
    // http://localhost:8080/api/usuario/1
    public UsuarioDTO getUsuario(@PathVariable("id") Long id) {
        Usuario usuario = usuariosService.getUsuario(id);
        return DTOConverter.convertToDTO(usuario);
    } // getUsuario
    
    @DeleteMapping(path = "{id}") // Traer un solo usuario por su ID
    // http://localhost:8080/api/idUsuario/1
    public UsuarioDTO deleteUsuario(@PathVariable("id") Long id) {
        Usuario usuario = usuariosService.deleteUsuario(id);
        return DTOConverter.convertToDTO(usuario);
    } // deleteUsuario
    
    @PostMapping // Agregar un solo usuario 
    public UsuarioDTO addUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuariosService.addUsuario(usuario);
        return DTOConverter.convertToDTO(nuevoUsuario);
    } // addUsuario
    
    @PutMapping(path = "{id}") // Modificar un usuario 
    public UsuarioDTO updateUsuario(@PathVariable("id") Long id, @RequestBody ChangePassword changePassword) {
        Usuario usuario = usuariosService.updateUsuario(id, changePassword);
        return DTOConverter.convertToDTO(usuario);
    } // updateUsuario
    
} // UsuarioController
