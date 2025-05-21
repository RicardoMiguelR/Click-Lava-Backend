package org.clicLava.service;
import java.util.ArrayList;
import java.util.List;

import org.clicLava.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	
	private final List<Pedido> lista= new ArrayList<Pedido>();
	
	@Autowired
	public PedidoService () {
	//	public Pedido(String calle, String colonia, String municipio, String codigoPostal, String fechaPedido,
		//		Double cantidad, String tiempo, Long idUsuario) {
		lista.add(new Pedido("Av. Chimalhuacán 12", "Benito Juárez", "Nezahualcoyotl", "5700", "2025-05-19 06:00:00", 1.0, "Un día", 1L));
		lista.add(new Pedido("Calle 20 de noviembre", "Las Águilas", "Nezahualcoyotl", "5700", "2025-05-20 08:00:00", 1.0, "Un día", 2L));
		lista.add(new Pedido("Av. Pantitlán 300", "Benito Juárez", "Nezahualcoyotl", "5700", "2025-05-22 09:00:00", 1.0, "Un día", 3L));
		lista.add(new Pedido("Calle Vicente Gerrero 89", "Benito Juárez", "Nezahualcoyotl", "5700", "2025-05-23 12:00:00", 1.0, "Un día", 4L));
		lista.add(new Pedido("Av. Riva Palacio 150", "Benito Juárez", "Nezahualcoyotl", "5700", "2025-05-23 7:00:00", 1.0, "Un día", 5L));
	}//constructor
	
	public List<Pedido> getPedidoS (){
		return lista;
	}//getPedidoS

	public Pedido getPedidO(Long id) {
		Pedido tmp = null;
		for (Pedido pedido : lista) {
			if (pedido.getId()==id){
				tmp= pedido;
				break;
			}//if
		}//foreach
		
		return tmp;
	}//getPedidO

	public Pedido deletePedidO(Long id) {
		Pedido tmp = null;
		for (Pedido pedido : lista) {
			if (pedido.getId()==id){
				tmp= pedido;
				lista.remove(pedido);
				break;
			}//if
		}//foreach
		
		return tmp;
	}//deletePedidO

	public Pedido addPedido(Pedido pedido) {
		lista.add(pedido);
		return pedido;
	}//addProduct

	public Pedido updatePedido(Long id, String calle, String colonia, String municipio, String codigoPostal,
			String fechaPedido, Double cantidad, String tiempo, Long idUsuario) {
		Pedido tmp = null;
		for (Pedido pedido : lista) {
			if (pedido.getId()==id){
				if(calle!=null) pedido.setCalle(calle);
				if (colonia!=null) pedido.setColonia(colonia);
				if (municipio!=null) pedido.setMunicipio(municipio);
				if (codigoPostal!=null) pedido.setCodigoPostal(codigoPostal);
				if (fechaPedido!=null) pedido.setFechaPedido(fechaPedido);
				if (cantidad!=null) pedido.setCantidad(cantidad);
				if (tiempo!=null) pedido.setTiempo(tiempo);
				if (tiempo!=null) pedido.setIdUsuario(idUsuario);
				
				tmp= pedido;
				break;
			}//if
		}//foreach
		return tmp;
	}//updatePedido


}// class PedidoService
