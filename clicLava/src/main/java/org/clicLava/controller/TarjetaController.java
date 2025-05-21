package org.clicLava.controller;

import java.util.List;

import org.clicLava.model.Tarjeta;
import org.clicLava.service.TarjetaService;
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
    public List<Tarjeta> getTarjetas() {
        return tarjetaService.getTarjetas();
    }
    
    @GetMapping(path = "{idTarjeta}") // Traer una sola tarjeta por su ID  http://localhost:8080/api/tarjeta/1
    public Tarjeta getTarjeta(@PathVariable("idTarjeta") Long idTarjeta) {
        return tarjetaService.getTarjeta(idTarjeta);
    } // getTarjeta
    
    @DeleteMapping(path = "{idTarjeta}") // Eliminar una tarjeta por su ID http://localhost:8080/api/tarjeta/1
    public Tarjeta deleteTarjeta(@PathVariable("idTarjeta") Long idTarjeta) {
        return tarjetaService.deleteTarjeta(idTarjeta);
    } // deleteTarjeta
    
    @PostMapping // Agregar una nueva tarjeta 
    public Tarjeta addTarjeta(@RequestBody Tarjeta tarjeta) {
        return tarjetaService.addTarjeta(tarjeta);
    } // addTarjeta
    
    @PutMapping(path = "{idTarjeta}") // Modificar una tarjeta 
    public Tarjeta updateTarjeta(@PathVariable("idTarjeta") Long idTarjeta, 
            @RequestParam(required = false) String nombreTitular, 
            @RequestParam(required = false) String numeroTarjeta, 
            @RequestParam(required = false) String vencimiento, 
            @RequestParam(required = false) Integer cvv,
            @RequestParam(required = false) Integer idUsuario){
        return tarjetaService.updateTarjeta(idTarjeta, nombreTitular, numeroTarjeta, vencimiento, cvv, idUsuario);
    } // updateTarjeta
    
} // TarjetaController



