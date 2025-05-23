package org.clicLava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PedidoProducto") 
public class PedidoProducto {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column (name ="idPeidoProducto", unique=true, nullable = false)
    private Long idPedido;
    private Long idProducto;
    @Column (name ="idcantidad", nullable = false)
    private Integer cantidad;
    @Column (nullable = false)
    private Double precioUnitario;
    
    
    public PedidoProducto() {
    }

    public PedidoProducto(Long idPedido, Long idProducto, Integer cantidad, Double precioUnitario) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
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

