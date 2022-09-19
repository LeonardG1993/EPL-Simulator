package com.revature.league;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Team;

public class League {
	
	private List<Team> league = new ArrayList<>();

	public List<Team> getLeague() {
		return league;
	}

	public void setLeague(List<Team> league) {
		this.league = league;
	}

	public static Double getRandomNumber(Double min, Double max){
	    return (Double)(Math.random()*(max-min) + min);
	  }
	
	public void result(Team home, Team away){
	    Double homeWin = home.getWinRate() + away.getLossRate();
	    Double draw = home.getDrawRate() + away.getDrawRate() + homeWin;
	    Double awayWin = home.getLossRate() + away.getWinRate() + draw;

	    Double what = getRandomNumber(0.0, 2.0);
	    
	    if (what <= homeWin){
	      home.setPoints(home.getPoints() + 3); 
	      home.setWins(home.getWins() + 1);
	      
	      away.setLosses(away.getLosses() + 1);
	    }else if (homeWin< what && what <= draw){
	      home.setPoints(home.getPoints() + 1);
	      home.setDraws(home.getDraws() + 1);
	      
	      away.setPoints(away.getPoints() + 1);
	      away.setDraws(away.getDraws() + 1);
	    }else if (what > draw && what <= awayWin){
	      away.setPoints(away.getPoints() + 3); 
		  away.setWins(away.getWins() + 1);
		      
		  home.setLosses(home.getLosses() + 1);
	    }
	  }
	
	public void kickoff() {		
		for (Team j: league) {
			for (Team i: league) {
				if (i.equals(j)) {
					continue;
				} else {
					result(i, j);
				}
			}
		}
	}

}
