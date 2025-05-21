package org.clicLava.service;

import java.util.ArrayList;
import java.util.List;

import org.clicLava.model.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
		private final List<Pago> lista= new ArrayList<Pago>();
		
		@Autowired
		public PagoService() {
			lista.add(new Pago(Double.valueOf(95.50),"15 de mayo 2025", 15, 16));
			lista.add(new Pago(Double.valueOf(96.50),"16 de mayo 2025", 17, 18));
			lista.add(new Pago(Double.valueOf(59.50),"17 de mayo 2025", 19, 20));
			lista.add(new Pago(Double.valueOf(43.50),"18 de mayo 2025", 21, 22));
			lista.add(new Pago(Double.valueOf(53.50),"19 de mayo 2025", 23, 24));
		}//Constructor
	
		public List<Pago> getPagos(){
			return lista;
		}//getPago

		public Pago getPago(Long id) {
			Pago tmp =null;
			for (Pago pago : lista) {
				if(pago.getId()==id) {
					tmp = pago;
					break;
				}//if
			}//foreach
			return tmp;
		}//getPago 

		public Pago deletePago(Long id) {
			Pago tmp =null;
			for (Pago pago : lista) {
				if(pago.getId()==id) {
					tmp = pago;
					lista.remove(pago);
					break;
				}//if
			}//foreach
			return tmp;
		}//deletePago

		public Pago addPago(Pago pago) {
			lista.add(pago);
			return pago;
		}//addPago

		public Pago updatePago(Long id, Double monto, String fecha, 
				Integer idTarjeta, Integer idPedido) {
			Pago tmp = null;
			for (Pago pago : lista) {
				if(pago.getId()==id) {
					if (monto!=null) pago.setMonto(monto);
					if (fecha!=null) pago.setFecha(fecha);
					if (idTarjeta!=null) pago.setIdTarjeta(idTarjeta);
					if (idPedido!=null) pago.setIdPedido(idPedido);
					tmp = pago;
					break;
				}//if
			}//foreach
			return tmp;
		}//updatePago
		
		
}//	PagoService
