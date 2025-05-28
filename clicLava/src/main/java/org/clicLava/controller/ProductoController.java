package org.clicLava.controller;

import java.util.List;
import org.clicLava.model.Producto;
import org.clicLava.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/productos/")
public class ProductoController {
	
	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public List<Producto> getProductos() {
		return productoService.getProducts();
	}
	
	@GetMapping(path = "{prodId}")
	public Producto getProducto(@PathVariable("prodId") Long id) {
		return productoService.getProduct(id);
	}
	
	@DeleteMapping(path = "{prodId}")
	public Producto deleteProducto(@PathVariable("prodId") Long id) {
		return productoService.deleteProduct(id);
	}
	
	@PostMapping()
	public Producto addProducto(@RequestBody Producto producto) {
		return productoService.addProducto(producto);
	}
	
	// Actualizar por medio de RequestParams ->
	@PutMapping(path = "{prodId}")
	public Producto updateProducto(@PathVariable("prodId") Long id,
			@RequestParam (required = false) String nombre,
			@RequestParam (required = false) String descripcion,
			@RequestParam (required = false) Double precio,
			@RequestParam (required = false) Integer stock,
			@RequestParam (required = false) String imagen) {
		return productoService.updateProduct(id, nombre, descripcion, precio, stock, imagen);
	}
}
