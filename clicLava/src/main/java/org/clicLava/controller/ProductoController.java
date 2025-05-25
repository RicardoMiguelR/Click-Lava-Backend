package org.clicLava.controller;

import java.util.List;
import org.clicLava.dto.ProductoDTO;
import org.clicLava.model.Producto;
import org.clicLava.service.ProductoService;
import org.clicLava.util.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/productos")
public class ProductoController {
	
	private final ProductoService productoService;
	
	@Autowired
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public List<ProductoDTO> getProductos() {
		List<Producto> productos = productoService.getProducts();
		return DTOConverter.convertToProductoDTOList(productos);
	}
	
	@GetMapping(path = "{prodId}")
	public ProductoDTO getProducto(@PathVariable("prodId") Long id) {
		Producto producto = productoService.getProduct(id);
		return DTOConverter.convertToDTO(producto);
	}
	
	@DeleteMapping(path = "{prodId}")
	public ProductoDTO deleteProducto(@PathVariable("prodId") Long id) {
		Producto producto = productoService.deleteProduct(id);
		return DTOConverter.convertToDTO(producto);
	}
	
	@PostMapping()
	public ProductoDTO addProducto(@RequestBody Producto producto) {
		Producto nuevoProducto = productoService.addProducto(producto);
		return DTOConverter.convertToDTO(nuevoProducto);
	}
	
	// Actualizar por medio de RequestParams ->
	@PutMapping(path = "{prodId}")
	public ProductoDTO updateProducto(@PathVariable("prodId") Long id,
			@RequestParam String nombre,
			@RequestParam String descripcion,
			@RequestParam Double precio,
			@RequestParam Integer stock,
			@RequestParam String imagen) {
		Producto producto = productoService.updateProduct(id, nombre, descripcion, precio, stock, imagen);
		return DTOConverter.convertToDTO(producto);
	}
}
