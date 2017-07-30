package com.leantaas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantaas.model.Team;
import com.leantaas.repository.ITeamRepository;
import com.leantaas.services.ITeamService;

@Service
public class TeamService implements ITeamService {

	@Autowired
	ITeamRepository teamRepository;

	public List<Team> getAll() {
		return teamRepository.findAll();
	}
}
