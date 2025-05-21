package org.clicLava.service;

import java.util.ArrayList;
import java.util.List;

import org.clicLava.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	private final List<Producto> lista = new ArrayList<Producto>();
	
	@Autowired
	public ProductoService() {
		lista.add(new Producto("Lavadora", "Lavadora automática de alta eficiencia con múltiples ciclos de lavado. Capacidad de 10kg, ideal para familias. Sistema de ahorro de agua y energía.", 89.99, 5, "https://picsum.photos/id/237/200/300"));
		lista.add(new Producto("Secadora", "Secadora eléctrica con tecnología de secado rápido y sensores de humedad. Capacidad de 8kg y sistema anti-arrugas. Incluye múltiples configuraciones de temperatura.", 58.79, 7, "https://picsum.photos/id/96/200/300"));
		lista.add(new Producto("Suavitel", "Suavizante de telas concentrado con aroma floral duradero. Deja la ropa suave, fresca y sin estática. Rinde hasta 40 lavadas. Botella de 850ml.", 19.90, 10, "https://picsum.photos/id/57/200/300"));
		lista.add(new Producto("Ace 1kg", "Detergente en polvo multiusos con partículas activas que eliminan manchas difíciles. Fórmula concentrada con blanqueador para mayor brillo en tus prendas. Envase de 1kg.", 15.35, 16, "https://picsum.photos/id/26/200/300"));
		lista.add(new Producto("Cloralex", "Blanqueador desinfectante que elimina el 99.9% de bacterias y gérmenes. Ideal para limpieza profunda de baños, cocinas y superficies. Botella de 1 litro con tapa de seguridad.", 21.80, 12, "https://picsum.photos/id/2/200/300"));
	}
	
	public List<Producto> getProducts() {
		return lista;
	}
	
	public Producto getProduct(Long id) {
		Producto tmp = null;
		for (Producto producto : lista) {
			if (producto.getId() == id) {
				tmp = producto;
				break;
			}
		}
		return tmp;
	}
	
	public Producto deleteProduct(Long id) {
		Producto tmp = null;
		for (Producto producto : lista) {
			if (producto.getId() == id) {
				tmp = producto;
				lista.remove(producto);
				break;
			}
		}
		return tmp;
	}
	
	public Producto addProducto(Producto producto) {
		lista.add(producto);
		return producto;
	}
	
	public Producto updateProduct(Long id, String nombre, String descripcion, Double precio, Integer stock, String imagen) {
		Producto tmp = null;
		for (Producto producto : lista) {
			if (producto.getId() == id) {
				if (nombre != null) producto.setNombre(nombre);
				if (descripcion != null) producto.setDescripcion(descripcion);
				if (precio != null) producto.setPrecio(precio);
				if (stock != null) producto.setStock(stock);
				if (imagen != null) producto.setImagen(imagen);
				
				tmp = producto;
				break;
			}
		}
		return tmp;
	}

}
