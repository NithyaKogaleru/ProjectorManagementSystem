package com.leantaas.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.leantaas.model.ProjectorManagement;

public interface IProjectorManagementRepository extends CrudRepository<ProjectorManagement, Long> {
	
	List<ProjectorManagement> findAll();

}
