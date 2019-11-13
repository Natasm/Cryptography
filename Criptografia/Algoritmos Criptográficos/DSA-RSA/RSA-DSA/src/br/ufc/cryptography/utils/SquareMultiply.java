package br.ufc.cryptography.utils;

import java.math.BigInteger;

public class SquareMultiply {
	
	public static BigInteger squareMultiply(BigInteger h, BigInteger m, BigInteger x) {
	    String representBinary = h.toString(2);
	    BigInteger number = new BigInteger("1");
	    
	    for(int i = 0; i < representBinary.length(); i++) {
	    	number = number.modPow(new BigInteger("2"), m);
	    	if(representBinary.charAt(i) == '1') {
	    		number = number.multiply(x);
	    		number = number.modPow(new BigInteger("1"), m);
	    	};
	    }
	    return number;
	}
}
