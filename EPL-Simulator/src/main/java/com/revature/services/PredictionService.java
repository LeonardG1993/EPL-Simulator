package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.revature.dtos.PredictionRequest;
import com.revature.models.Prediction;
import com.revature.models.User;
import com.revature.repo.PredictionRepo;

@Service
public class PredictionService {
	
	private final PredictionRepo pRepo;
	private final UserService userv;
	
	public PredictionService (PredictionRepo pRepo, UserService userv) {
		this.pRepo = pRepo;
		this.userv = userv;
	}
	
	public List<Prediction> findAll(){
		return pRepo.findAll();
	}
	
	public List<Prediction> findByUserId(int id){
		Optional<User> optionalUser = this.userv.findById(id);
		if (!optionalUser.isPresent()) {
			throw new RuntimeException(String.format("User not found", id));
		}
		
		return pRepo.findPredictionByUserId(optionalUser.get());
	}
	
	public List<Prediction> findByUserUsernameAndPassword(String username, String password){
		Optional<User> optionalUser = this.userv.findByUsernameAndPassword(username, password);
		if (!optionalUser.isPresent()) {
			throw new RuntimeException(String.format("User not found", username));
		}
		
		return pRepo.findPredictionByUserId(optionalUser.get());
	}
	
	public Prediction add (PredictionRequest pRequest) {
		Optional<User> optionalUser = userv.findByUsernameAndPassword(pRequest.getUser().getUsername(), 
				pRequest.getUser().getUsername());
		if(!optionalUser.isPresent()) {
			throw new RuntimeException("User does not exist");
		}
		
		Prediction prediction = new Prediction(
				pRequest.getFirst(),
				pRequest.getSecond(),
				pRequest.getThird(),
				pRequest.getFourth(),
				pRequest.getUser());
		
		Optional<Prediction> optionalPrediction = this.findByUserUsernameAndPassword(pRequest.getUser().getUsername(), 
				pRequest.getUser().getPassword()).stream()
				.filter(p -> p.getUser().getUsername() == pRequest.getUser().getUsername())
				.filter(p -> p.getUser().getPassword() == pRequest.getUser().getPassword())
				.findFirst();
		
		if (optionalPrediction.isPresent()) {
			throw new RuntimeException("You have already made a prediction for this season");
		}
		
		return prediction;
	}
	
	public Prediction findById(int id) {
		Optional<Prediction> optionalPrediction = pRepo.findById(id);
		if (!optionalPrediction.isPresent()) {
			throw new RuntimeException("Prediction not found");
		}
		
		return optionalPrediction.get();
	}
	
	public Prediction save(Prediction prediction) {
		return pRepo.save(prediction);
	}

}



























