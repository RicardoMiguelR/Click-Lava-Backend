package org.clicLava.repository;

import java.util.Optional;

import org.clicLava.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
	Optional<Rol> findByRol (String rol);
}