package org.clicLava.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private Long id;
    private String calle;
    private String colonia;
    private String municipio;
    private String codigoPostal;
    private String fechaPedido;
    private Integer cantidad;
    private Double total;
    private Long idUsuario;
    private String nombreUsuario;
    private List<PedidoProductoDTO> pedidoProductos;
    
    // Constructor vacío
    public PedidoDTO() {}
    
    // Constructor con parámetros
    public PedidoDTO(Long id, String calle, String colonia, String municipio, 
                    String codigoPostal, String fechaPedido, Integer cantidad, 
                    Double total, Long idUsuario, String nombreUsuario) {
        this.id = id;
        this.calle = calle;
        this.colonia = colonia;
        this.municipio = municipio;
        this.codigoPostal = codigoPostal;
        this.fechaPedido = fechaPedido;
        this.cantidad = cantidad;
        this.total = total;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.pedidoProductos = new ArrayList<>();
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCalle() {
        return calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    public String getColonia() {
        return colonia;
    }
    
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }
    
    public String getMunicipio() {
        return municipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    
    public String getCodigoPostal() {
        return codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    
    public String getFechaPedido() {
        return fechaPedido;
    }
    
    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
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
    
    public List<PedidoProductoDTO> getPedidoProductos() {
        return pedidoProductos;
    }
    
    public void setPedidoProductos(List<PedidoProductoDTO> pedidoProductos) {
        this.pedidoProductos = pedidoProductos;
    }
}