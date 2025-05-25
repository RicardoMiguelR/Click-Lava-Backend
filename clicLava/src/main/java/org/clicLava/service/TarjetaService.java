package org.clicLava.service;

import java.util.List;
import java.util.Optional;

import org.clicLava.model.Tarjeta;
import org.clicLava.model.Usuario;
import org.clicLava.repository.TarjetaRepository;
import org.clicLava.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {
    private final TarjetaRepository tarjetaRepository;
    private final UsuariosRepository usuarioRepository;
    
    @Autowired
    public TarjetaService(TarjetaRepository tarjetaRepository, UsuariosRepository usuarioRepository) {
        this.tarjetaRepository = tarjetaRepository;
        this.usuarioRepository = usuarioRepository;
    }//TarjetaService
	
        
    //obtener todas las tarjetas
    public List<Tarjeta> getTarjetas() {
        return tarjetaRepository.findAll();
    }//getTarjetas
    
    //obtener tarjeta por id
    public Tarjeta getTarjeta(Long id) {
        return tarjetaRepository.findById(id).orElseThrow(
        () -> new IllegalArgumentException("La tarjeta con id[" + id + "] no existe"));
    }//getTarjetaId
    
    // Eliminar tarjeta
    public Tarjeta deleteTarjeta(Long id) {
        Tarjeta tmp = null;
        if (tarjetaRepository.existsById(id)) {
            tmp = tarjetaRepository.findById(id).get();
            tarjetaRepository.deleteById(id);
        }
        return tmp;
    }//deleteTarjeta
    
    // Agregar nueva tarjeta
    public Tarjeta addTarjeta(Tarjeta tarjeta) {
        Optional<Tarjeta> tarjetaExistente = tarjetaRepository.findByNumeroTarjeta(tarjeta.getNumeroTarjeta());
        if (tarjetaExistente.isEmpty()) {
            return tarjetaRepository.save(tarjeta);
        } else {
            return null;
        }
    }//addTarjeta
    
    // Actualizar tarjeta
    public Tarjeta updateTarjeta(Long idTarjeta, String nombreTitular, String numeroTarjeta, String vencimiento,
            Integer cvv, Long idUsuario) {
        Tarjeta tmp = null;
        
        if (tarjetaRepository.existsById(idTarjeta)) {
            Tarjeta tarjeta = tarjetaRepository.findById(idTarjeta).get();
            
            if (nombreTitular != null) tarjeta.setNombreTitular(nombreTitular);
            if (numeroTarjeta != null) tarjeta.setNumeroTarjeta(numeroTarjeta);
            if (vencimiento != null) tarjeta.setVencimiento(vencimiento);
            if (cvv != null) tarjeta.setCvv(cvv);
            // Corregir la asignación de usuario
            if (idUsuario != null) {
                Usuario usuario = usuarioRepository.findById(idUsuario).orElse(null);
                if(usuario != null) {
                    tarjeta.setUsuario(usuario);
                }
            }
            
            tarjetaRepository.save(tarjeta);
            tmp = tarjeta;
        }
        return tmp;
    }//updateTarjeta
    
}//classTarjetaServices


