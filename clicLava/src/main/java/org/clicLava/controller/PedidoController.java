package org.clicLava.controller;
import java.util.List;
import org.clicLava.model.Pedido;
import org.clicLava.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/pedidos/") // http://localhost:8080/api/pedidos/

public class PedidoController {
	private final PedidoService pedidoService;
	
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}


	@GetMapping
	public List<Pedido> getPedidos(){
		return pedidoService.getPedidoS();
	} //getPeedidos
	
	@GetMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/1
	public Pedido getPedido(@PathVariable("pedId")Long id){
		return pedidoService.getPedidO(id);
	} //getPeedido
	

	@DeleteMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/1
	public Pedido deletePedido(@PathVariable("pedId")Long id){
		return pedidoService.deletePedidO(id);
	} //deletePeedido
	
	@PostMapping
	public Pedido addPedido(@RequestBody Pedido pedido) {
		return pedidoService.addPedido(pedido);
	}//addPedido
	
	@PutMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/1
		public Pedido updatePedido(@PathVariable("pedId")Long id,
				@RequestParam(required = false) String calle, 
				@RequestParam(required = false) String colonia, 
				@RequestParam(required = false) String municipio, 
				@RequestParam(required = false) String codigoPostal, 
				@RequestParam(required = false) String fechaPedido,
				@RequestParam(required = false) Double cantidad, 
				@RequestParam(required = false) String tiempo, 
				@RequestParam(required = false) Long idUsuario){
		
		return pedidoService.updatePedido(id, calle, colonia, municipio, codigoPostal, fechaPedido, cantidad, tiempo, idUsuario);
		
	}//updatePedido

} //class PedidoController
