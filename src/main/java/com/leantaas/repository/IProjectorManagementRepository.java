package com.leantaas.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leantaas.model.Projector;
import com.leantaas.model.ProjectorManagement;

@Repository
public interface IProjectorManagementRepository extends JpaRepository<ProjectorManagement, Long> {

	@Query("SELECT pm FROM ProjectorManagement pm WHERE pm.isActive = true")
	List<ProjectorManagement> findAll();

	@SuppressWarnings("unchecked")
	ProjectorManagement save(ProjectorManagement projectorManagement);

	ProjectorManagement getOne(Long id);

	@Query(nativeQuery = true)
	Projector findAvailableProjector(Date start_time, Date end_time);

	@Query("SELECT pm FROM ProjectorManagement pm WHERE pm.isActive = true AND pm.team.id = ?1")
	List<ProjectorManagement> find(Long id);
}
