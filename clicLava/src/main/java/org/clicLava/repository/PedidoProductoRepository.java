package org.clicLava.repository;

import java.util.Optional;

import org.clicLava.model.PedidoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoProductoRepository extends JpaRepository<PedidoProducto, Long> {
	
}
