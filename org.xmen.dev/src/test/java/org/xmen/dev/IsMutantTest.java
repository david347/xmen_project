package org.xmen.dev;

import static org.junit.Assert.*;

import org.junit.Test;
import org.xmen.dev.IsMutant;

public class IsMutantTest {

	DNAEvaluation comand = new IsMutant();
	@Test
	public void isMutantUpToRight() {
		String[] dna5x5 = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGAATG",
				"CCTCTA",
				"TCACTG"};
		String[] dna6x6 = {
				"GTGCGAC",
				"CGGTGCA",
				"TTATGTC",
				"AGAATGA",
				"CCTCAAC",
				"CCTCGAC",
				"TCACTGC"};
		assertEquals(true, comand.execute(dna5x5));
		assertEquals(true, comand.execute(dna6x6));
	}

	@Test
	public void isMutantUpToLeft() {
		String[] dna5x5 = {
				"ATGCGA",
				"CAGTGC",
				"TTATGT",
				"AGTATG",
				"CTTCTA",
				"TCACTG"};
		String[] dna6x6 = {
				"GTGCGAC",
				"CGGTGCA",
				"TTCTGTC",
				"AGAATGA",
				"CCTTAAC",
				"CCTCGAC",
				"TCACTGC"};
		assertEquals(true, comand.execute(dna5x5));
		assertEquals(true, comand.execute(dna6x6));
	}
	
	@Test
	public void isMutantHorizontal() {
		String[] dna5x5 = {
				"ATGCGA",
				"CAGTGC",
				"TTCTGT",
				"AAAATG",
				"CTTCTA",
				"TCACTG"};
		String[] dna6x6 = {
				"GTGCGAC",
				"CGGTGCA",
				"TTCTGTC",
				"AGAATGA",
				"CCAAAAC",
				"CCTCGAC",
				"TCACTGC"};
		assertEquals(true, comand.execute(dna5x5));
		assertEquals(true, comand.execute(dna6x6));
	}
	
	@Test
	public void isMutantVertical() {
		String[] dna5x5 = {
				"ATGCGA",
				"CAGTGC",
				"TTCTGT",
				"TACATG",
				"CTCCTA",
				"TCCCTG"};
		String[] dna6x6 = {
				"GTGCGAC",
				"CGGTGTA",
				"TTCTGCC",
				"AGAATCA",
				"CCAAACC",
				"CCTCGCA",
				"TCACTGC"};
		assertEquals(true, comand.execute(dna5x5));
		assertEquals(true, comand.execute(dna6x6));
	}
	
	@Test
	public void isHuman() {
		String[] dna5x5 = {
				"ATGCGA",
				"CAGTGC",
				"TTCTGT",
				"TACATG",
				"CTACTA",
				"TCGCTG"};
		String[] dna6x6 = {
				"GTGCGAC",
				"CGGTGTA",
				"TTCTGCC",
				"AGAATGA",
				"CCAGACC",
				"CCTCGCA",
				"TCACTGC"};
		assertEquals(false, comand.execute(dna5x5));
		assertEquals(false, comand.execute(dna6x6));
	}
}
