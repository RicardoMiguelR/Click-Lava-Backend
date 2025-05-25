package org.clicLava.controller;

import java.util.List;
import org.clicLava.dto.RolDTO;
import org.clicLava.service.RolService;
import org.clicLava.model.Rol;
import org.clicLava.util.DTOConverter;
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
@RequestMapping(path = "/api/roles/")
public class RolController {
	
    private final RolService rolService;
    
    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    
    @GetMapping
    public List<RolDTO> getRoles(){
        List<Rol> roles = rolService.getRoles();
        return DTOConverter.convertToRolDTOList(roles);
    }
    
    @GetMapping(path = "{rolId}")
    public RolDTO getRol(@PathVariable("rolId") Long id){
        Rol rol = rolService.getRol(id);
        return DTOConverter.convertToDTO(rol);
    }
    
    @DeleteMapping(path = "{rolId}")
    public RolDTO deleteRol(@PathVariable("rolId") Long id){
        Rol rol = rolService.deleteRol(id);
        return DTOConverter.convertToDTO(rol);
    }
    
    @PostMapping
    public RolDTO addRol(@RequestBody Rol rol){
        Rol nuevoRol = rolService.addRol(rol);
        return DTOConverter.convertToDTO(nuevoRol);
    }
    
    @PutMapping(path = "{rolId}")
    public RolDTO updateRol(@PathVariable("rolId") Long id,
        @RequestParam(required = false) String rol){
        
        Rol rolActualizado = rolService.updateRol(id, rol);
        return DTOConverter.convertToDTO(rolActualizado);
    }
}
