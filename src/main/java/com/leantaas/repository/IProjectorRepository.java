package com.leantaas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leantaas.model.Projector;

@Repository
public interface IProjectorRepository extends JpaRepository<Projector, Long> {

	/**
	 * gets all the entities of Projector in the database using JPA by creating a
	 * query on the fly.
	 */
	List<Projector> findAll();

	Projector findById(Long id);
}
