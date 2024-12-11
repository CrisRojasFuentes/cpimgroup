package com.cpimgroup.evaluacion.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpimgroup.evaluacion.models.UsuarioModel;

@Repository
public interface IUsuarioRepository extends JpaRepository<UsuarioModel, Long>{

	Optional<UsuarioModel> findByEmail(String email);
	
}
