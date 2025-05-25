package org.clicLava.dto;

public class PagoDTO {
    private Long id;
    private Double monto;
    private String fechaPago;
    private Long idTarjeta;
    private Long idPedido;
    
    // Constructor vacío
    public PagoDTO() {}
    
    // Constructor con parámetros
    public PagoDTO(Long id, Double monto, String fechaPago, Long idTarjeta, Long idPedido) {
        this.id = id;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.idTarjeta = idTarjeta;
        this.idPedido = idPedido;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Double getMonto() {
        return monto;
    }
    
    public void setMonto(Double monto) {
        this.monto = monto;
    }
    
    public String getFechaPago() {
        return fechaPago;
    }
    
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    public Long getIdTarjeta() {
        return idTarjeta;
    }
    
    public void setIdTarjeta(Long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }
    
    public Long getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
}