package org.xmen.dev;

import com.sun.javafx.fxml.expression.BinaryExpression;

/**
 * only support 8x8 matrix
 * @author David.Garay
 *
 */
public class IsMutantV2 implements DNAEvaluation{

	int n;
	long upToRightChecker;
	long upToLeftChecker;
	long vertical;
	long horizontal;
	
	long adnL;
	
	@Override
	public boolean execute(String[] adn) {
		
		this.n = adn.length;
		this.horizontal= 0b1111;
		this.vertical=(long) ((((((1<<n)+1)<<n)+1)<<n)+1);
				
		
		this.upToLeftChecker=(long) ((((((1<<(n-1))+1)<<(n-1))+1)<<(n-1))+1);
				
		this.upToRightChecker=(long) ((((((1<<(n+1))+1)<<(n+1))+1)<<(n+1))+1);		
		 
		for(char c:"ATCG".toCharArray()) {
			long andLong=0;
			for(String str: adn) {
				str = str.replaceAll("(?!"+c+").", "0");
				str = str.replace(c, '1');
				andLong=andLong<<n;
				andLong += Long.parseLong(str,2);
			}
			if(checkDNA(andLong))
				return true;
		}
		return false;
		
	}
	
	private boolean checkDNA(Long andLong) {
		long upToRightChecker=this.upToRightChecker;
		long upToLeftChecker=this.upToLeftChecker;
		long vertical=this.vertical;
		long horizontal=this.horizontal;
		for(int j =0; j+4 <=n;j++) {
			for(int i =0; i+4 <=n;i++) {
				long temUR =  andLong&upToRightChecker;
				if(temUR==upToRightChecker) {
					return true;
				}
				long temUL =  andLong&upToLeftChecker;
				if(temUL==upToLeftChecker) {
					return true;
				}
				upToLeftChecker=upToLeftChecker<<1;
				upToRightChecker=upToRightChecker<<1;
			}
			upToLeftChecker=upToLeftChecker<<4;
			upToRightChecker=upToRightChecker<<4;
		}
		
		for(int j =0; j+4 <=n;j++) {
			for(int i =0; i <n;i++) {
				long temV=andLong&vertical;
				if(temV==vertical) {
					return true;
				}
				long temH=andLong&horizontal;
				if(temH==horizontal) {
					return true;
				}
				horizontal=horizontal<<n;
				vertical=vertical<<1;
			}
			vertical=vertical<<1;
			horizontal=this.horizontal<<(j+1);
		}
		return false;
	}
	

}
