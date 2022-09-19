package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dtos.PredictionRequest;
import com.revature.models.Prediction;
import com.revature.services.PredictionService;

@RestController
@RequestMapping("/prediction")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PredictionController {
	
	private final PredictionService pserv;
	
	public PredictionController (PredictionService pserv) {
		this.pserv = pserv;
	}
	
	@GetMapping("/{predictionId}")
	public ResponseEntity<Prediction> getPredictionById(@PathVariable("predictionId") int id){
		return ResponseEntity.ok(pserv.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Prediction>> getPredictions(){
		return ResponseEntity.ok(pserv.findAll());
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Prediction>> getPredictionsByUser (@PathVariable("userId") int id){
		return ResponseEntity.ok(pserv.findByUserId(id));
	}
	
	@PostMapping
	public ResponseEntity<Prediction> addPrediction(@RequestBody PredictionRequest pRequest){
		return ResponseEntity.ok(pserv.add(pRequest));
	}

}
