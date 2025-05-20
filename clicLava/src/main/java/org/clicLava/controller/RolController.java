package org.clicLava.controller;

import java.util.List;
import org.clicLava.service.RolService;
import org.clicLava.model.Rol;
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
@RequestMapping(path = "/roles/")
public class RolController {
    private final RolService rolService;
    
    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }
    
    @GetMapping
    public List<Rol> getRoles(){
        return rolService.getRoles();
    }
    
    @GetMapping(path = "{rolId}")
    public Rol getRol(@PathVariable("rolId") Long id){
        return rolService.getRol(id);
    }
    
    @DeleteMapping(path = "{rolId}")
    public Rol deleteRol(@PathVariable("rolId") Long id){
        return rolService.deleteRol(id);
    }
    
    @PostMapping
    public Rol addRol(@RequestBody Rol rol){
        return rolService.addRol(rol);
    }
    
    @PutMapping(path = "{rolId}")
    public Rol updateRol(@PathVariable("rolId") Long id,
        @RequestParam(required = false) String rol){
        
        return rolService.updateRol(id, rol);
    }
}