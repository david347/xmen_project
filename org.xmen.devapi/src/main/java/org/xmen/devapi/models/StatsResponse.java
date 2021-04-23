package org.xmen.devapi.models;

public class StatsResponse {

	int count_mutant_dna;
	int count_human_dna;
	double ratio;
	
	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}
	public StatsResponse setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
		return this;
	}
	public int getCount_human_dna() {
		return count_human_dna;
	}
	public StatsResponse setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
		return this;
	}
	public double getRatio() {
		return ratio;
	}
	public StatsResponse setRatio(double ratio) {
		this.ratio = ratio;
		return this;
	}
		
	
}
