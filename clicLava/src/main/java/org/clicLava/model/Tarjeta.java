package org.clicLava.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "tarjeta")
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTarjeta", unique = true, nullable = false)
	private Long id;
	
	@Column(nullable = false)
	private String nombreTitular;
	
	@Column(nullable = false)
	private String numeroTarjeta;
	
	@Column(nullable = false)
	private String vencimiento;
	
	@Column(nullable = false)
	private Integer cvv;
	
	// Relación con Usuario
	@JsonBackReference(value = "usuario-tarjetas")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario_fk", nullable = false)
	private Usuario usuario;
	
	// Relación inversa con Pago
	@OneToMany(mappedBy = "tarjeta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pago> pagos;
	
	public Tarjeta(String nombreTitular, String numeroTarjeta, String vencimiento, Integer cvv, Usuario usuario) {
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
		this.vencimiento = vencimiento;
		this.cvv = cvv;
		this.usuario = usuario;
	}
	
	public Tarjeta() {}

	public Long getId() {
		return id;
	}

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
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Pago> getPagos() {
		return pagos;
	}
	
	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", nombreTitular=" + nombreTitular + ", numeroTarjeta="
				+ numeroTarjeta + ", vencimiento=" + vencimiento + ", cvv=" + cvv + "]";
	}
}
