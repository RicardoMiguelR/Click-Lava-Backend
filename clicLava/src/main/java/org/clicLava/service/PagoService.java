package org.clicLava.service;
import java.util.List;
import org.clicLava.model.Pago;
import org.clicLava.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoService {
	
		private final PagoRepository pagoRepository;
		
		@Autowired
		public PagoService (PagoRepository pagoRepository) {
					this.pagoRepository = pagoRepository;
		}//Constructor
	
		public List<Pago> getPagos(){
			return pagoRepository.findAll();
		}//getPago

		public Pago getPago(Long id) {
			Pago tmp =null;
	
				if(pagoRepository.existsById(id)) {
					tmp = pagoRepository.findById(id).get();
				}//if
				return tmp;
			}//foreach

		public Pago deletePago(Long id) {
			Pago tmp =null;
				 if(pagoRepository.existsById(id)) {
			        	tmp = pagoRepository.findById(id).get();
			        	pagoRepository.deleteById(id);
			        }
					return tmp;
			}//foreach

		public Pago addPago(Pago pago) {
		     
		       return pagoRepository.save(pago);
		        	
		 }//addPago
			

		public Pago updatePago(Long id, Double monto) {
			Pago tmp = null;
			if(pagoRepository.existsById(id)) {
				Pago pago = pagoRepository.findById(id).get();
				if(monto != null) pago.setMonto(monto);
				
				pagoRepository.save(pago);
	        	tmp = pago;
			}
			 return tmp;
		}//updatePago	

}//	PagoService
