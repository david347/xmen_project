package org.xmen.devapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xmen.devapi.models.DNASample;

@Repository
public interface DNARepository extends JpaRepository<DNASample, String>{

	@Override
	public List<DNASample> findAll();
	
	@Override
	public DNASample  save(DNASample s);
}
