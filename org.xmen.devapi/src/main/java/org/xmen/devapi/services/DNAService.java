package org.xmen.devapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmen.devapi.models.DNASample;
import org.xmen.devapi.repository.DNARepository;


@Service
public class DNAService {

	@Autowired
	private DNARepository dnarepository;
	
	public List<DNASample> getAll(){
		return dnarepository.findAll();
	}
	
	public DNASample save(DNASample dna) {
		return dnarepository.save(dna);
	}
	
	public void wipeData() {
		dnarepository.deleteAll();
	}
}
