package org.clicLava.controller;

import java.util.List;

import org.clicLava.dto.PagoDTO;
import org.clicLava.model.Pago;
import org.clicLava.service.PagoService;
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
@RequestMapping(path="/api/pago")//http://localhost:8080/api/pago
public class PagoController {
	
	private final PagoService pagoService;
	
	@Autowired
	public PagoController(PagoService pagoService) {
		this.pagoService = pagoService;
	}//constructor


	@GetMapping
	public List<PagoDTO> getPagos(){
		List<Pago> pagos = pagoService.getPagos();
		return DTOConverter.convertToPagoDTOList(pagos);
	}//getPagos
	
	@GetMapping(path="{pagoId}")//http://localhost:8080/api/pago/1
	public PagoDTO getPago(@PathVariable("pagoId") Long id){
		Pago pago = pagoService.getPago(id);
		return DTOConverter.convertToDTO(pago);
	}//getPago
	
		
	@DeleteMapping(path="{pagoId}")//http://localhost:8080/api/pago/1
	public PagoDTO deletePago(@PathVariable("pagoId") Long id){
		Pago pago = pagoService.deletePago(id);
		return DTOConverter.convertToDTO(pago);
	}//deletePago
	
	@PostMapping
	public PagoDTO addPago(@RequestBody Pago pago){
		Pago nuevoPago = pagoService.addPago(pago);
		return DTOConverter.convertToDTO(nuevoPago);
	}//addPago
	
	@PutMapping(path="{pagoId}")
	public PagoDTO updatePago(@PathVariable("pagoId") Long id,
			  @RequestParam(required = false) Double monto){
		
		Pago pago = pagoService.updatePago(id,monto);
		return DTOConverter.convertToDTO(pago);
	}//updatePago
	
}//classPagoController