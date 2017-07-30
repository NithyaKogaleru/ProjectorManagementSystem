package com.leantaas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantaas.model.ProjectorManagement;
import com.leantaas.repository.IProjectorManagementRepository;
import com.leantaas.services.IProjectorManagementService;

@Service
public class ProjectorManagementService implements IProjectorManagementService {

	@Autowired
	IProjectorManagementRepository projectorManagementRepository;

	@Override
	public List<ProjectorManagement> getAll() {
		return projectorManagementRepository.findAll();
	}

}
