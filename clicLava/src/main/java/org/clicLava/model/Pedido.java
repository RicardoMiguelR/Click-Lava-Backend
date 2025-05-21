package org.clicLava.model;

public class Pedido {
		private Long id;
		private String calle;
		private String colonia;
		private String municipio;
		private String codigoPostal;
		private String fechaPedido;
		private Double cantidad;
		private String tiempo;
		private Long idUsuario;
		private static Long total= Long.valueOf(0);
		
		public Pedido(String calle, String colonia, String municipio, String codigoPostal, String fechaPedido,
				Double cantidad, String tiempo, Long idUsuario) {
			super();
			this.calle = calle;
			this.colonia = colonia;
			this.municipio = municipio;
			this.codigoPostal = codigoPostal;
			this.fechaPedido = fechaPedido;
			this.cantidad = cantidad;
			this.tiempo = tiempo;
			this.idUsuario = idUsuario;
			
			Pedido.total++;
			this.id=Pedido.total;
		}//constructor
		
		public Pedido() {
			Pedido.total++;
			this.id=Pedido.total;
		} //Constructor vacío
		
		//Getters and setters

		public String getCalle() {
			return calle;
		}//get Calle

		public void setCalle(String calle) {
			this.calle = calle;
		}// set Calle

		public String getColonia() {
			return colonia;
		}//get Colonia

		public void setColonia(String colonia) {
			this.colonia = colonia;
		}// set Colonia

		public String getMunicipio() {
			return municipio;
		}//get Municipio

		public void setMunicipio(String municipio) {
			this.municipio = municipio;
		}// set Municipio

		public String getCodigoPostal() {
			return codigoPostal;
		}// get Código postal

		public void setCodigoPostal(String codigoPostal) {
			this.codigoPostal = codigoPostal;
		}// set Código Postal

		public String getFechaPedido() {
			return fechaPedido;
		}//get Fecha pedido

		public void setFechaPedido(String fechaPedido) {
			this.fechaPedido = fechaPedido;
		}// set fechaPedido

		public Double getCantidad() {
			return cantidad;
		}//get Cantidad

		public void setCantidad(Double cantidad) {
			this.cantidad = cantidad;
		}// set Cantidad

		public String getTiempo() {
			return tiempo;
		}//get Tiempo

		public void setTiempo(String tiempo) {
			this.tiempo = tiempo;
		}//set tiempo

		public Long getIdUsuario() {
			return idUsuario;
		}//get idUsuario

		public void setIdUsuario(Long idUsuario) {
			this.idUsuario = idUsuario;
		}
		// set id Usuario
		public Long getId() {
			return id;
		}//get id
		
		//Fin getters and setters


		@Override
		public String toString() {
			return "Pedido [id=" + id + ", calle=" + calle + ", colonia=" + colonia + ", municipio=" + municipio
					+ ", codigoPostal=" + codigoPostal + ", fechaPedido=" + fechaPedido + ", cantidad=" + cantidad
					+ ", tiempo=" + tiempo + ", idUsuario=" + idUsuario + "]";
		}//toString
		
		

		
		
		
		
		
		
		

}//Pedido
