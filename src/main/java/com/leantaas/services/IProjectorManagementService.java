package com.leantaas.services;

import java.util.Date;
import java.util.List;

import com.leantaas.model.ProjectorManagement;
import com.leantaas.model.Reservation;

public interface IProjectorManagementService {
	List<ProjectorManagement> getAllReservations();

	ProjectorManagement addReservation(ProjectorManagement projectorManagement);

	ProjectorManagement cancelReservation(Long id);
	
	Reservation checkAvailability(Date startTime, Date endTime);
}
