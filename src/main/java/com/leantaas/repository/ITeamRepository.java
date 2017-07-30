package com.leantaas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leantaas.model.Team;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

	/**
	 * gets all the entities of Team in the database using JPA by creating a query
	 * on the fly.
	 */
	List<Team> findAll();

	Team findById(Long id);
}
