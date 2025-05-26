package org.clicLava.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pedido_producto")
public class PedidoProducto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedidoProducto", unique = true, nullable = false)
    private Long idPedidoProducto;
    
    // Relación con Pedido
    @JsonBackReference(value = "pedido-productos")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPedido_fk", nullable = false)
    private Pedido pedido;
    
    // Relación con Producto
    @JsonBackReference(value = "producto-pedidos")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProducto_fk", nullable = false)
    private Producto producto;
    
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    
    @Column(name = "precioUnitario", nullable = false)
    private Double precioUnitario;
    
    // Constructores
    public PedidoProducto() {
    }
    
    public PedidoProducto(Pedido pedido, Producto producto, Integer cantidad, Double precioUnitario) {
        this.pedido = pedido;
        this.producto = producto;
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
    
    public Pedido getPedido() {
        return pedido;
    }
    
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
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

