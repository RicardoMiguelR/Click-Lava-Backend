package org.clicLava.dto;

public class PedidoProductoDTO {
    private Long idPedidoProducto;
    private Long idPedido;
    private Long idProducto;
    private String nombreProducto;
    private Integer cantidad;
    private Double precioUnitario;
    
    // Constructor vacío
    public PedidoProductoDTO() {}
    
    // Constructor con parámetros
    public PedidoProductoDTO(Long idPedidoProducto, Long idPedido, Long idProducto, 
                            String nombreProducto, Integer cantidad, Double precioUnitario) {
        this.idPedidoProducto = idPedidoProducto;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }
    
    // Getters y Setters
    public Long getIdPedidoProducto() {
        return idPedidoProducto;
    }
    
    public void setIdPedidoProducto(Long idPedidoProducto) {
        this.idPedidoProducto = idPedidoProducto;
    }
    
    public Long getIdPedido() {
        return idPedido;
    }
    
    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }
    
    public Long getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}