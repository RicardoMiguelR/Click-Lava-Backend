package org.clicLava.model;


public class Producto {
	
	// Propiedades ->
	private Long id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	private String imagen;
	private static Long total= Long.valueOf(0);
	
	// Constructor ->
	public Producto(String nombre, String descripcion, Double precio, Integer stock, String imagen) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
		Producto.total++;
		this.id = Producto.total;
	}
	
	// Contructor para total ->
	public Producto() {
		Producto.total++;
		this.id = Producto.total;
	}
	
	// Getters y Setters ->
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getId() {
		return id;
	}

	// ToString ->
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + ", imagen=" + imagen + "]";
	}
	
}
