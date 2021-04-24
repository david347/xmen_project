package org.xmen.dev;

import static org.junit.Assert.assertEquals;

import com.sun.jmx.snmp.Timestamp;

public class main {

	public static void main(String[] args) {
		DNAEvaluation comand = new IsMutant();
		DNAEvaluation comand2 = new IsMutantV2();
		
		String[] dna8x8 = {"ATCGATCG",
				"CGATCGAT",
				"ATCGATCG",
				"CGATCGAT",
				"ATCGATCG",
				"CGATCGAT",
				"ATCGATCG",
				"CGATCGAT"};
		
		
		String[] dna5x5 = {
				"ATGCGA",
				"CAGTGC",
				"TTCTGT",
				"AGAATG",
				"CCTCTA",
				"TCACTG"};
		String[] dna6x6 = {
				"GTGCGAC",
				"CGGTGCA",
				"TTATGTC",
				"AGACTGA",
				"CCCCAAC",
				"CCTAGAC",
				"TCACTGC"};
		int loop=1;
		
		Long start =  System.currentTimeMillis();
		for(int i=0;i<loop;i++) {
			comand.execute(dna5x5);
		}
		Long end =  System.currentTimeMillis();
		System.out.println((end-start)/1000d + " sconds");
		
		start =  System.currentTimeMillis();
		for(int i=0;i<loop;i++) {
			comand.execute(dna6x6);
		}
		end =  System.currentTimeMillis();
		System.out.println((end-start)/1000d + " sconds");
			
		start =  System.currentTimeMillis();
		for(int i=0;i<loop;i++) {
			comand.execute(dna8x8);
		}
		end =  System.currentTimeMillis();
		System.out.println((end-start)/1000d + " sconds");
		
		
		start =  System.currentTimeMillis();
		for(int i=0;i<loop;i++) {
			comand2.execute(dna5x5);
		}
		end =  System.currentTimeMillis();
		System.out.println((end-start)/1000d + " sconds");
		
		start =  System.currentTimeMillis();
		for(int i=0;i<loop;i++) {
			comand2.execute(dna6x6);
		}
		end =  System.currentTimeMillis();
		System.out.println((end-start)/1000d + " sconds");
			
		start =  System.currentTimeMillis();
		for(int i=0;i<loop;i++) {
			comand2.execute(dna8x8);
		}
		end =  System.currentTimeMillis();
		System.out.println((end-start)/1000d + " sconds");
		

		
	}

}
