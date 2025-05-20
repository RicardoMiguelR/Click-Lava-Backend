package org.clicLava.service;

import java.util.ArrayList;
import java.util.List;

import org.clicLava.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {
    private final List<Rol> listaRoles = new ArrayList<Rol>();
    
    @Autowired
    public RolService() {
        listaRoles.add(new Rol("administrador"));
        listaRoles.add(new Rol("cliente"));

    }
    
    public List<Rol> getRoles() {
        return listaRoles;
    }
    
    public Rol getRol(Long id) {
        Rol tmp = null;
        for (Rol rol : listaRoles) {
            if (rol.getId() == id) {
                tmp = rol;
                break;
            }
        }
        return tmp;
    }
    
    public Rol deleteRol(Long id) {
        Rol tmp = null;
        for (Rol rol : listaRoles) {
            if (rol.getId() == id) {
                tmp = rol;
                listaRoles.remove(rol);
                break;
            }
        }
        return tmp;
    }
    
    public Rol addRol(Rol rol) {
        listaRoles.add(rol);
        return rol;
    }
    
    public Rol updateRol(Long id, String nombreRol) {
        Rol tmp = null;
        for (Rol rol : listaRoles) {
            if (rol.getId() == id) {
                if(nombreRol != null) rol.setRol(nombreRol);
                tmp = rol;
                break;
            }
        }
        return tmp;
    }
}