package org.clicLava.dto;

public class TarjetaDTO {
    private Long id;
    private String nombreTitular;
    private String numeroTarjeta;
    private String vencimiento;
    private Integer cvv;
    private Long idUsuario;
    private String nombreUsuario;
    
    // Constructor vacío
    public TarjetaDTO() {}
    
    // Constructor con parámetros
    public TarjetaDTO(Long id, String nombreTitular, String numeroTarjeta, 
                     String vencimiento, Integer cvv, Long idUsuario, String nombreUsuario) {
        this.id = id;
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.vencimiento = vencimiento;
        this.cvv = cvv;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombreTitular() {
        return nombreTitular;
    }
    
    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getVencimiento() {
        return vencimiento;
    }
    
    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
    
    public Integer getCvv() {
        return cvv;
    }
    
    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}