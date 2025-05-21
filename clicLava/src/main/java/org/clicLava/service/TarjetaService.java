package org.clicLava.service;

import java.util.ArrayList;
import java.util.List;
import org.clicLava.model.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaService {
    private final List<Tarjeta> listaTarjetas = new ArrayList<>();
@Autowired
    public TarjetaService() {
        // Datos de ejemplo iniciales
	listaTarjetas.add(new Tarjeta("Peter Parker", "5656343456789098", "12/25", 245, 1));
    listaTarjetas.add(new Tarjeta( "Ruby Sunday", "9384756823405698", "09/26", 643, 2));
    listaTarjetas.add(new Tarjeta("Jack Harkness", "9384567150987563", "05/27", 459, 3));
    listaTarjetas.add(new Tarjeta("Rose Taylor", "5039494555959567", "09/26", 345, 4));
    listaTarjetas.add(new Tarjeta("Clara Oswald", "5465360929323335", "04/28", 184, 5));
        
    }//Tarjeta service
    
    public List<Tarjeta> getTarjetas() {
        return listaTarjetas;
    }
    
    public Tarjeta getTarjeta(Long idTarjeta) {
        for (Tarjeta tarjeta : listaTarjetas) {
            if (tarjeta.getIdTarjeta().equals(idTarjeta)) {
                return tarjeta;
            }
        }
        return null;
    }
    
    public Tarjeta deleteTarjeta(Long idTarjeta) {
        Tarjeta tarjetaAEliminar = getTarjeta(idTarjeta);
        if (tarjetaAEliminar != null) {
            listaTarjetas.remove(tarjetaAEliminar);
        }
        return tarjetaAEliminar;
    }
    
    public Tarjeta addTarjeta(Tarjeta tarjeta) {
        listaTarjetas.add(tarjeta);
        return tarjeta;
    }
    

	public Tarjeta updateTarjeta(Long idTarjeta, String nombreTitular, String numeroTarjeta, String vencimiento,
			Integer cvv, Integer idUsuario) {
		 Tarjeta tarjetaActualizar = getTarjeta(idTarjeta);
	        if (tarjetaActualizar != null) {
	            if (nombreTitular != null) tarjetaActualizar.setNombreTitular(nombreTitular);
	            if (numeroTarjeta != null) tarjetaActualizar.setNumeroTarjeta(numeroTarjeta);
	            if (vencimiento != null) tarjetaActualizar.setVencimiento(vencimiento);
	            if (cvv != null) tarjetaActualizar.setCvv(cvv);
	            if (idUsuario != null) tarjetaActualizar.setIdUsuario(idUsuario);
	        }//if
			return tarjetaActualizar;
	        
    }//upsateTarjeta

}//class

	



