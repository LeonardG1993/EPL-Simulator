package com.revature.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Prediction;
import com.revature.models.User;

@Repository
public interface PredictionRepo extends JpaRepository<Prediction, Integer>{
	
	List<Prediction> findPredictionByUserId(User user);

}
