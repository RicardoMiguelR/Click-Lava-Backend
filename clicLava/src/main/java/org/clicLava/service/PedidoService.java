package org.clicLava.service;
import java.util.List;
import org.clicLava.model.Pedido;
import org.clicLava.model.Usuario;
import org.clicLava.repository.PedidoRepository;
import org.clicLava.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	private final UsuariosRepository usuarioRepository;
	
	@Autowired
	public PedidoService(PedidoRepository pedidoRepository, UsuariosRepository usuarioRepository) {
		this.pedidoRepository = pedidoRepository;
		this.usuarioRepository = usuarioRepository;
	}//constructor
	
	public List<Pedido> getPedidoS (){
		return pedidoRepository.findAll();
	}//getPedidoS

	public Pedido getPedidO(Long id) {
		return pedidoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El pedido con el id [" + id
						+ "] no existe.") 
				);
		}//getPedidO
		
	public Pedido deletePedidO(Long id) {
		Pedido tmp = null;
		if(pedidoRepository.existsById(id)) {
			tmp=pedidoRepository.findById(id).get();
			pedidoRepository.deleteById(id);
		}//if exists
		return tmp;
	}//deletePedido
		

	public Pedido addPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
		return pedido;
	}//add pedido
		
	public Pedido updatePedido(Long id, String calle, String colonia, String municipio, String codigoPostal,
			String fechaPedido, Double cantidad, String tiempo, Long idUsuario) {
		Pedido tmp = null;
		if (pedidoRepository.existsById(id)){
			Pedido pedido = pedidoRepository.findById(id).get();
			if(calle != null) pedido.setCalle(calle);
			if(colonia != null) pedido.setColonia(colonia);
			if(municipio != null) pedido.setMunicipio(municipio);
			if(codigoPostal != null) pedido.setCodigoPostal(codigoPostal);
			if(fechaPedido != null) pedido.setFechaPedido(fechaPedido);
			// Corregir el tipo de cantidad a Integer
			if(cantidad != null) pedido.setCantidad(cantidad.intValue());
			if(tiempo != null) pedido.setTiempo(tiempo);
			// Corregir la asignación de usuario
			if(idUsuario != null) {
				Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
				if(usuario != null) {
					pedido.setUsuario(usuario);
				}
			}
			pedidoRepository.save(pedido);
			tmp = pedido;
		}
		return tmp;
	}//updatePedido

}// class PedidoService
