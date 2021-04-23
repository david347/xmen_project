package org.xmen.dev;

public class IsMutant implements DNAEvaluation {
	
	public boolean execute(String[] dna) {
		
		for(int y=0; y<dna.length;y++) {
			for(int x=0; x<dna.length;x++) {
				if(isMutant(dna, x, y))
					return true;
			}
		}
		return false;
	}
	
	public Boolean isMutant(String[] dna, int x, int y) {
		char ref = dna[y].charAt(x);
		if(!"ATCG".contains(""+ref))
			return null;
		int ismuttant =1;
		//evaluate horizontal
		for(int i=x+1; i < dna[y].length(); i++) {
			if(ref == dna[y].toCharArray()[i]) {
				ismuttant++;
				if(ismuttant>=4)
					return true;
			}else {
				break;
			}
		}
		ismuttant=1;
		//evaluate vertical
		for(int j=y+1; j < dna.length; j++) {
			if(ref == dna[j].toCharArray()[x]) {
				ismuttant++;
				if(ismuttant>=4)
					return true;
			}else {
				break;
			}
		}
		ismuttant=1;
		//evaluate up to right 
		for(int i=1; i+y < dna.length && x+i<dna[y].length(); i++) {
			if(ref == dna[y+i].toCharArray()[x+i]) {
				ismuttant++;
				if(ismuttant>=4)
					return true;
			}else {
				break;
			}
		}
		ismuttant=1;
		//evaluate up to left
		for(int i=1; y+i < dna.length && x-i>=0; i++) {
			if(ref == dna[y+i].toCharArray()[x-i]) {
				ismuttant++;
				if(ismuttant>=4)
					return true;
			}else {
				break;
			}
		}
		return false;
	}
}
