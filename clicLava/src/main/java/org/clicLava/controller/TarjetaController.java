package org.clicLava.controller;

import java.util.List;

import org.clicLava.dto.TarjetaDTO;
import org.clicLava.model.Tarjeta;
import org.clicLava.service.TarjetaService;
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
@RequestMapping(path = "/api/tarjeta/")  // http://localhost:8080/api/tarjeta/
public class TarjetaController {
    private final TarjetaService tarjetaService;
    
    @Autowired
    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    } // constructor 

    @GetMapping
    public List<TarjetaDTO> getTarjetas() {
        List<Tarjeta> tarjetas = tarjetaService.getTarjetas();
        return DTOConverter.convertToTarjetaDTOList(tarjetas);
    }
    
    @GetMapping(path = "{idTarjeta}") // Traer una sola tarjeta por su ID  http://localhost:8080/api/tarjeta/1
    public TarjetaDTO getTarjeta(@PathVariable("idTarjeta") Long idTarjeta) {
        Tarjeta tarjeta = tarjetaService.getTarjeta(idTarjeta);
        return DTOConverter.convertToDTO(tarjeta);
    } // getTarjeta
    
    @DeleteMapping(path = "{idTarjeta}") // Eliminar una tarjeta por su ID http://localhost:8080/api/tarjeta/1
    public TarjetaDTO deleteTarjeta(@PathVariable("idTarjeta") Long idTarjeta) {
        Tarjeta tarjeta = tarjetaService.deleteTarjeta(idTarjeta);
        return DTOConverter.convertToDTO(tarjeta);
    } // deleteTarjeta
    
    @PostMapping // Agregar una nueva tarjeta 
    public TarjetaDTO addTarjeta(@RequestBody Tarjeta tarjeta) {
        Tarjeta nuevaTarjeta = tarjetaService.addTarjeta(tarjeta);
        return DTOConverter.convertToDTO(nuevaTarjeta);
    } // addTarjeta
    
    @PutMapping(path = "{idTarjeta}") // Modificar una tarjeta 
    public TarjetaDTO updateTarjeta(@PathVariable("idTarjeta") Long idTarjeta, 
            @RequestParam(required = false) String nombreTitular, 
            @RequestParam(required = false) String numeroTarjeta, 
            @RequestParam(required = false) String vencimiento, 
            @RequestParam(required = false) Integer cvv,
            @RequestParam(required = false) Long idUsuario){ // Cambiar de Integer a Long
        Tarjeta tarjeta = tarjetaService.updateTarjeta(idTarjeta, nombreTitular, numeroTarjeta, vencimiento, cvv, idUsuario);
        return DTOConverter.convertToDTO(tarjeta);
    } // updateTarjeta
    
} // TarjetaController



