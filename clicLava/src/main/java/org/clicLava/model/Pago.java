package org.clicLava.model;

public class Pago {
	private Long id;
	private Double monto;
	private String  fecha;
	private Integer idTarjeta;
	private Integer idPedido;
	private static Long total= Long.valueOf(0);
	
	
public Pago(Double monto, String fecha, 
		Integer idTarjeta, Integer idPedido) {
	
		this.monto = monto;
		this.fecha = fecha;
		this.idTarjeta = idTarjeta;
		this.idPedido = idPedido;
		Pago.total++;
		this.id=Pago.total;
	}//constructor
	public Pago() {
		Pago.total++;
		this.id=Pago.total;
	}
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
