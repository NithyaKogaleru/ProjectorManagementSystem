package com.leantaas.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leantaas.model.Team;
import com.leantaas.repository.ITeamRepository;

@Service
public class TeamService {

	@Autowired
	ITeamRepository teamRepository;
	
	public List<Team> getAll(){
		return teamRepository.findAll();
	}
}
