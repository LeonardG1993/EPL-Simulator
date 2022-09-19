package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.models.Team;
import com.revature.repo.TeamRepo;

@Service
public class TeamService {
	
	private final TeamRepo tRepo;
	
	public TeamService(TeamRepo tRepo) {
		this.tRepo = tRepo;
	}
	
	public List<Team> findAll() {
		return tRepo.findAll();
	}
	
	public Optional<Team> findById(int id){
		Optional<Team> optionalTeam = tRepo.findById(id);
		
		if (optionalTeam.isPresent()) {
			return optionalTeam;
		} else {
			throw new RuntimeException(String.format("Team not found", id));
		}
	}
	
	public Team save (Team team) {
		return tRepo.save(team);
	}
	
//	public List<Team> getLeagueTable() {
//		return tRepo.filterByPoints();
//	}
	

}
