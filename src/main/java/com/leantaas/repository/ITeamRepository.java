package com.leantaas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.leantaas.model.Team;

public interface ITeamRepository extends CrudRepository<Team, Long> {
	
	/**
	 * gets all the entities of Team in the database 
	 * using JPA by creating a query on the fly.
	 */
	List<Team> findAll();
}
