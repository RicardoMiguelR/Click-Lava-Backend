package org.clicLava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity//esto es una entidad
@Table(name="pago")//cambio de nombre en l tabla pago
public class Pago {
	@Id//Indica al Id que es un campo Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", unique= true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private Double monto;
	@Column(nullable = false)
	private String  fecha;
	private Integer idTarjeta;
	private Integer idPedido;
	
	
public Pago(Double monto, String fecha, 
		Integer idTarjeta, Integer idPedido) {
	
		this.monto = monto;
		this.fecha = fecha;
		this.idTarjeta = idTarjeta;
		this.idPedido = idPedido;
		}//constructor
	
	public Pago() {}//constructor vacio
	
	///////////Getters and Setters///////////	
	public Double getMonto() {
		return monto;
	}//getMonto
	public void setMonto(Double monto) {
		this.monto = monto;
	}//setMonto
	public String getFecha() {
		return fecha;
	}//getFecha
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}//setFecha
	public Integer getIdTarjeta() {
		return idTarjeta;
	}//getIdTarjeta
	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}//setIdTarjeta
	public Integer getIdPedido() {
		return idPedido;
	}//getIdPedido
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}//setIdPedido
	public Long getId() {
		return id;
	}//getId
	
	@Override
	public String toString() {
		return "Pago [id=" + id + ", monto=" + monto + ", fecha=" + fecha + ", idTarjeta=" + idTarjeta + ", idPedido="
				+ idPedido + "]";
	}//toString
	
}//ClassPago
