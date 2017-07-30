package com.leantaas.services;

import java.util.List;

import com.leantaas.model.ProjectorManagement;

public interface IProjectorManagementService {
	List<ProjectorManagement> getAllReservations();

	ProjectorManagement addReservation(ProjectorManagement projectorManagement);

	ProjectorManagement cancelReservation(Long id);
}
