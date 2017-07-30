package com.leantaas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.leantaas.model.Projector;

public interface IProjectorRepository extends CrudRepository<Projector, Long>{
	
	/**
	 * gets all the entities of Projector in the database 
	 * using JPA by creating a query on the fly.
	 */
	List<Projector> findAll();
}
