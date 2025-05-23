package org.clicLava.service;
import java.util.List;
import org.clicLava.model.Pedido;
import org.clicLava.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoService (PedidoRepository pedidoRepository) {
		this.pedidoRepository= pedidoRepository;
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
					Pedido pedido= pedidoRepository.findById(id).get();
				if(calle!=null) pedido.setCalle(calle);
				if (colonia!=null) pedido.setColonia(colonia);
				if (municipio!=null) pedido.setMunicipio(municipio);
				if (codigoPostal!=null) pedido.setCodigoPostal(codigoPostal);
				if (fechaPedido!=null) pedido.setFechaPedido(fechaPedido);
				if (cantidad!=null) pedido.setCantidad(cantidad);
				if (tiempo!=null) pedido.setTiempo(tiempo);
				if (idUsuario!=null) pedido.setIdUsuario(idUsuario);
				pedidoRepository.save(pedido);
				tmp= pedido;
			}//if
			return tmp;
	}//updatePedido


}// class PedidoService
