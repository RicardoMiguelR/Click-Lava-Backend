package org.clicLava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.clicLava.model.Rol;
import org.clicLava.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    
	private final RolRepository rolRepository;
	
    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    
    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }
    
    public Rol getRol(Long id) {
        Rol tmp = null;
        
        if(rolRepository.existsById(id)) {
        	tmp = rolRepository.findById(id).get();
        }
        
        return tmp;
    }
    
    public Rol deleteRol(Long id) {
        Rol tmp = null;
        
        if(rolRepository.existsById(id)) {
        	tmp = rolRepository.findById(id).get();
        	rolRepository.deleteById(id);
        }
        
        return tmp;
    }
    
    public Rol addRol(Rol rol) {
        Optional<Rol> roles = rolRepository.findByRol(rol.getRol()); 
        
        if(roles.isEmpty()) {
        	rolRepository.save(rol);
        }else {
        	rol = null;
        }
        		
        return rol;
    }
    
    public Rol updateRol(Long id, String nombreRol) {
        Rol tmp = null;
        
        if(rolRepository.existsById(id)) {
        	Rol rol = rolRepository.findById(id).get();
        	if(nombreRol != null) rol.setRol(nombreRol);
        	
        	rolRepository.save(rol);
        	tmp = rol;
        }
        
        return tmp;
    }
}
