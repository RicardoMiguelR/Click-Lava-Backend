package org.clicLava.controller;

import java.util.List;

import org.clicLava.model.Pago;
import org.clicLava.service.PagoService;
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
@RequestMapping(path="/api/pagos/")//http://localhost:8080/api/pagos/
public class PagoController {
	
	private final PagoService pagoService;
	
	@Autowired
	public PagoController(PagoService pagoService) {
		this.pagoService = pagoService;
	}//constructor


	@GetMapping
	public List<Pago> getPagos(){
		return pagoService.getPagos();
	}//getPagos
	
	@GetMapping(path="{pagoId}")//http://localhost:8080/api/pagos/1
	public Pago getPago(@PathVariable("pagoId") Long id){
		return pagoService.getPago(id);
	}//getPago
	
		
	@DeleteMapping(path="{pagoId}")//http://localhost:8080/api/pagos/1
	public Pago deletePago(@PathVariable("pagoId") Long id){
		return pagoService.deletePago(id);
	}//deletePago
	
	@PostMapping
	public Pago addPago(@RequestBody Pago pago){
		return pagoService.addPago(pago);
	}//addPago
	
	@PutMapping(path="{pagoId}")
	public Pago updatePago(@PathVariable("pagoId") Long id,
			  @RequestParam(required = false) Double monto){
		
		return pagoService.updatePago(id,monto);
	}//updatePago
	
}//classPagoController