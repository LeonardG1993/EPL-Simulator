package com.revature.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.Team;

@Repository
public interface TeamRepo extends JpaRepository <Team, Integer> {
	
	Optional<Team> findByName (String name);
	
//	@Query("SELECT * FROM teams ORDER BY points DESC")
//	List<Team> filterByPoints();
	

}
