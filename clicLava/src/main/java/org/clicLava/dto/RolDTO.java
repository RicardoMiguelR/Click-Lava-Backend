package org.clicLava.dto;

public class RolDTO {
    private Long id;
    private String rol;
    
    // Constructor vacío
    public RolDTO() {}
    
    // Constructor con parámetros
    public RolDTO(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
}