package org.clicLava.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "pedidos")
public class Pedido {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id",  nullable = false)	
		private Long id;
        @Column (nullable=false)
		private String calle;
        @Column (nullable=false)
		private String colonia;
        @Column (nullable=false)
		private String municipio;
        @Column (nullable=false)
		private String codigoPostal;
        @Column (nullable=false)
		private String fechaPedido;
        @Column (nullable=false)
		private Double cantidad;
        @Column (nullable=false)
		private String tiempo;
        @Column (nullable=false)
		private Long idUsuario;
        
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
			

		}//constructor
		
		public Pedido() {} //Constructor vacío
		
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
