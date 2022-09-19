package com.revature;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.league.League;
import com.revature.models.Team;

@SpringBootApplication
public class EplSimulatorApplication {

	public static void main(String[] args) {
		League epl = new League();
		
		List<Team> league = epl.getLeague();
		
		Team liverpool = new Team ("Liverpool", 0.7, 0.15, 0.15);
		Team manCity = new Team ("Man City", 0.7, 0.16, 0.14);
		
		league.add(liverpool);
		league.add(manCity);
		
		epl.kickoff();
		
		System.out.println(liverpool);
		System.out.println(manCity);
		System.out.println(liverpool.getPoints());
		
		SpringApplication.run(EplSimulatorApplication.class, args);
	}
	
	

}
