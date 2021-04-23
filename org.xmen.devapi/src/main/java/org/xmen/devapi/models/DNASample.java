package org.xmen.devapi.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "dna_sample")
public class DNASample {

    @Id
    @GeneratedValue(generator = "system--uuid")
    @GenericGenerator(name = "system--uuid", strategy = "uuid2")
    String dna_sample_id;
    @CreationTimestamp
    Timestamp created;
    Boolean isMutant;
    String dna;

    public String getDna_sample_id() {
        return dna_sample_id;
    }

    public DNASample setDna_sample_id(String dna_sample_id) {
        this.dna_sample_id = dna_sample_id;
        return this;
    }

    public Timestamp getCreated() {
        return created;
    }

    public DNASample setCreated(Timestamp created) {
        this.created = created;
        return this;
    }

	public String getDna() {
		return dna;
	}

	public DNASample setDna(String dna) {
		this.dna = dna;
		return this;
	}

	public Boolean getIsMutant() {
		return isMutant;
	}

	public DNASample setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
		return this;
	}

    
  
}
