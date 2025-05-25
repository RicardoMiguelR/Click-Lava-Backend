package org.clicLava.model;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido", nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String calle;
	
	@Column(nullable = false)
	private String colonia;
	
	@Column(nullable = false)
	private String municipio;
	
	@Column(nullable = false)
	private String codigoPostal;
	
	@Column(nullable = false)
	private String fechaPedido;
	
	@Column(nullable = false)
	private Integer cantidad;
	
	@Column(nullable = false)
	private String tiempo;
	
	@Column(nullable = true) // Puedes cambiar a false si es obligatorio
	private Double total;
	
	// Relación con Usuario
	@JsonBackReference(value = "usuario-pedidos")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario_fk", nullable = false)
	private Usuario usuario;
	
	@JsonManagedReference(value = "pedido-productos")
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PedidoProducto> pedidoProductos;
	
	@JsonManagedReference(value = "pedido-pago")
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Pago pago;
	
	public Pedido(String calle, String colonia, String municipio, String codigoPostal, String fechaPedido,
			Integer cantidad, String tiempo, Usuario usuario) {
		this.calle = calle;
		this.colonia = colonia;
		this.municipio = municipio;
		this.codigoPostal = codigoPostal;
		this.fechaPedido = fechaPedido;
		this.cantidad = cantidad;
		this.tiempo = tiempo;
		this.usuario = usuario;
	}
	
	public Pedido() {}
	
	public Long getId() {
		return id;
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

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	public Double getTotal() {
		return total;
	}
	
	public void setTotal(Double total) {
		this.total = total;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	// Agregar estos métodos
	public List<PedidoProducto> getPedidoProductos() {
		return pedidoProductos;
	}
	
	public void setPedidoProductos(List<PedidoProducto> pedidoProductos) {
		this.pedidoProductos = pedidoProductos;
	}
	
	public Pago getPago() {
		return pago;
	}
	
	public void setPago(Pago pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", municipio=" + municipio
				+ ", codigoPostal=" + codigoPostal + ", fechaPedido=" + fechaPedido + ", cantidad=" + cantidad
				+ ", tiempo=" + tiempo + "]";
	}
}
