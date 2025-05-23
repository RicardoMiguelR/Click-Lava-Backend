package org.clicLava.repository;

import java.util.Optional;

import org.clicLava.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    Optional<Tarjeta> findByNumeroTarjeta(String numeroTarjeta);
   
}