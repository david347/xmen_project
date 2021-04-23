package org.xmen.devapi.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmen.dev.IsMutant;
import org.xmen.devapi.models.DNARequest;
import org.xmen.devapi.models.DNASample;
import org.xmen.devapi.models.StatsResponse;
import org.xmen.devapi.services.DNAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Api(tags="DNA")
public class DNAController {

	@Autowired
	public DNAService service;
		
	@PostMapping("/mutant")
	@ApiOperation(value = "Evaluate DNA", notes = "Evaluate a given DNA to determine whether or not it is from a mutant")
	@ApiResponses(value = {@ApiResponse(code= 200, message = "is a mutant!"),
			@ApiResponse(code= 403, message = "is a human :(")})
	public ResponseEntity<?> evaluateDNA(@RequestBody DNARequest dna) {
		
		DNASample result = new DNASample()
				.setDna(Arrays.toString(dna.getDna()))
				.setIsMutant(new IsMutant().execute(dna.getDna()));
		service.save(result);
		return (result.getIsMutant())?
				new ResponseEntity<Object>(HttpStatus.OK):
				new ResponseEntity<Object>(HttpStatus.FORBIDDEN);
	}

	@GetMapping("/stats")
	@ApiOperation(value = "Check Statistics", notes = "Returns the number of mutants and humans that have been processed")
	public ResponseEntity<StatsResponse> stats() {
		List<DNASample> result= service.getAll();
		Integer mutants = (int)result.stream().filter((a)-> a.getIsMutant()).count();
		Integer humans = (int)result.stream().filter((a)-> !a.getIsMutant()).count();
		return new ResponseEntity<StatsResponse>(
				new StatsResponse()
					.setCount_human_dna(humans)
					.setCount_mutant_dna(mutants)
					.setRatio((double)mutants/(double)humans),
				HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@ApiOperation(value = "Check all DNA samples", notes = "Returns all processed DNA samples")
	public ResponseEntity<?> getall() {
		return new ResponseEntity<Object>(service.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/wipedata")
	@ApiOperation(value = "Wipe Data", notes = "Delete all registered information")
	public void wipeData(){
		service.wipeData();
	}
	
	
	
}

