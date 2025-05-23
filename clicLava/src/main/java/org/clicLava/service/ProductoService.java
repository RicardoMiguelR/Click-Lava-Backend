package org.clicLava.service;

import java.util.List;
import java.util.Optional;
import org.clicLava.model.Producto;
import org.clicLava.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	// Se referencia el repositorio ->
	private final ProductoRepository productoRepository;
	
	// Constructor repository ->
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	// Logica para traer todos los productos ->
	public List<Producto> getProducts() {
		return productoRepository.findAll();
	}
	
	// Logica para traer un solo producto ->
	public Producto getProduct(Long id) {
		return productoRepository.findById(id).orElseThrow(
					() -> new IllegalArgumentException("El producto con el id["
							+ id + "] no existe")
				);
	}
	
	// Logica para eliminar un producto ->
	public Producto deleteProduct(Long id) {
		Producto tmp = null;
		if (productoRepository.existsById(id)) {
			tmp = productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}
		return tmp;
	}
	
	// Logica para agregar un producto ->
	public Producto addProducto(Producto producto) {
		Optional<Producto> prod = productoRepository.findByNombre(producto.getNombre());
		if (prod.isEmpty()) {
			productoRepository.save(producto);
		} else {
			producto = null;
		}
		return producto;
	}
	
	// Logica para actualizar un producto ->	
	public Producto updateProduct(Long id, String nombre, String descripcion, Double precio, Integer stock, String imagen) {
		Producto tmp = null;
		if (productoRepository.existsById(id)) {
			Producto producto = productoRepository.findById(id).get();
			if (nombre != null) producto.setNombre(nombre);
			if (descripcion != null) producto.setDescripcion(descripcion);
			if (precio != null) producto.setPrecio(precio);
			if (stock != null) producto.setStock(stock);
			if (imagen != null) producto.setImagen(imagen);
			productoRepository.save(producto);
			tmp = producto;
		}
		return tmp;
	}

}
