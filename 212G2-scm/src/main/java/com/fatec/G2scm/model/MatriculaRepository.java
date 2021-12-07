package com.fatec.G2scm.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends CrudRepository<Matricula, Long> {
	public Optional<Matricula> findById(@Param("id") Long id);
}