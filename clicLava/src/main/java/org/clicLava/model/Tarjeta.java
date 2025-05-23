package org.clicLava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //clase usuario
@Table(name = "tarjeta") // se nombra la entidad Tarjeta
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idTarjeta;
	
	@Column(nullable = false)
	private String nombreTitular;
	@Column(nullable = false)
	private String numeroTarjeta;
	@Column(nullable = false)	
	private String vencimiento;
	@Column(nullable = false)	
	private Integer cvv;
	@Column(nullable = false)
	private Integer idUsuario;
	//private static Long totalTarjeta = Long.valueOf(0);
	
	
	public Tarjeta(String nombreTitular, String numeroTarjeta, String vencimiento, Integer cvv, Integer idUsuario) {
	
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
		this.vencimiento = vencimiento;
		this.cvv = cvv;
		this.idUsuario = idUsuario;
		
		//Tarjeta.totalTarjeta++;
       // this.idTarjeta = Tarjeta.totalTarjeta;
	}//constructor
	
	public Tarjeta() {}//constructor
	

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdTarjeta() {
		return idTarjeta;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", nombreTitular=" + nombreTitular + ", numeroTarjeta="
				+ numeroTarjeta + ", vencimiento=" + vencimiento + ", cvv=" + cvv + ", idUsuario=" + idUsuario + "]";
	}//toString

}//classProducto
