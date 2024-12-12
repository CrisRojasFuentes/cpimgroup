package com.cpimgroup.evaluacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cpimgroup.evaluacion.models.TelefonoModel;

@Repository
public interface ITelefonoRepository extends JpaRepository<TelefonoModel, Long>{

}
