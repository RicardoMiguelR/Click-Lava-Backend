package org.clicLava.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pago")
public class Pago {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPago", unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private Double monto;
	
	@Column(nullable = false)
	private String fechaPago;
	
	// Relación con Tarjeta
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTarjeta_fk", nullable = false)
	private Tarjeta tarjeta;
	
	// Relación con Pedido
	@JsonBackReference(value = "pedido-pago")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPedido_fk", nullable = false)
	private Pedido pedido;

	
	public Pago(Double monto, String fechaPago, Tarjeta tarjeta, Pedido pedido) {
		this.monto = monto;
		this.fechaPago = fechaPago;
		this.tarjeta = tarjeta;
		this.pedido = pedido;
	}
	
	public Pago() {}
	
	public Long getId() {
		return id;
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
	
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public void setPago(Pedido pedido) {
		if (pedido == null) {
	        if (this.pedido != null) {
	            this.pedido.setPago(null);
	        }
	    } else {
	        pedido.setPago(this);
	    }
	    this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Pago [id=" + id + ", monto=" + monto + ", fechaPago=" + fechaPago + "]";
	}
}
