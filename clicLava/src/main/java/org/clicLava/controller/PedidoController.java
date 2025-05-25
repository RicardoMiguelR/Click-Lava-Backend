package org.clicLava.controller;
import java.util.List;
import org.clicLava.dto.PedidoDTO;
import org.clicLava.model.Pedido;
import org.clicLava.service.PedidoService;
import org.clicLava.util.DTOConverter;
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
@RequestMapping (path = "/api/pedidos/") // http://localhost:8080/api/pedidos/

public class PedidoController {
	private final PedidoService pedidoService;
	
	
	@Autowired
	public PedidoController(PedidoService pedidoService) {
		super();
		this.pedidoService = pedidoService;
	}


	@GetMapping
	public List<PedidoDTO> getPedidos(){
		List<Pedido> pedidos = pedidoService.getPedidoS();
		return DTOConverter.convertToPedidoDTOList(pedidos);
	} //getPeedidos
	
	@GetMapping (path = "{pedId}") // http://localhost:8080/api/pedidos/1
	public PedidoDTO getPedido(@PathVariable ("pedId")Long id){
		Pedido pedido = pedidoService.getPedidO(id);
		return DTOConverter.convertToDTO(pedido);
	} //getPeedido
	

	@DeleteMapping (path = "{pedId}") // http://localhost:8080/api/pedidos/1
	public PedidoDTO deletePedido(@PathVariable ("pedId")Long id){
		Pedido pedido = pedidoService.deletePedidO(id);
		return DTOConverter.convertToDTO(pedido);
	} //deletePeedido
	
	@PostMapping
	public PedidoDTO addPedido (@RequestBody Pedido pedido) {
		Pedido nuevoPedido = pedidoService.addPedido(pedido);
		return DTOConverter.convertToDTO(nuevoPedido);
	}//addPedido
	
	@PutMapping(path = "{pedId}") // http://localhost:8080/api/pedidos/1
		public PedidoDTO updatePedido(@PathVariable ("pedId")Long id,
				@RequestParam (required = false) String calle, 
				@RequestParam (required = false) String colonia, 
				@RequestParam (required = false) String municipio, 
				@RequestParam (required = false) String codigoPostal, 
				@RequestParam (required = false) String fechaPedido,
				@RequestParam (required = false) Double cantidad, 
				@RequestParam (required = false) String tiempo, 
				@RequestParam (required = false) Long idUsuario){
		
		Pedido pedido = pedidoService.updatePedido(id, calle, colonia, municipio, codigoPostal, fechaPedido, cantidad, tiempo, idUsuario);
		return DTOConverter.convertToDTO(pedido);
		
	}//uodatePedido

} //class PedidoController
