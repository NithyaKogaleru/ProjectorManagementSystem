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
	public List<ProjectorManagement> getAllReservations() {
		return projectorManagementRepository.findAll();
	}

	@Override
	public ProjectorManagement addReservation(ProjectorManagement projectorManagement) {
		return projectorManagementRepository.save(projectorManagement);
	}

	@Override
	public ProjectorManagement cancelReservation(Long id) {
		ProjectorManagement toUpdate = projectorManagementRepository.getOne(id);
		toUpdate.setActive(false);
		return projectorManagementRepository.save(toUpdate);
	}
}
