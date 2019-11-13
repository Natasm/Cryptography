package br.ufc.cryptography.rsa;

import java.math.BigInteger;
import java.security.SecureRandom;

import br.ufc.cryptography.utils.SquareMultiply;

public class RSA implements Operation{
	@Override
	public Key generateKey(int sizeBit) {
		  SecureRandom RANDOM = new SecureRandom();
		  Key key = new Key();
		
		  BigInteger p = BigInteger.probablePrime(sizeBit/2, RANDOM);
	      BigInteger q = BigInteger.probablePrime(sizeBit/2, RANDOM);
	      
	      BigInteger n = p.multiply(q); 
	      
	      BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
	      
	      BigInteger e  = new BigInteger("65537"); 
	      BigInteger d = e.modInverse(phi);
		  
	      key.setEND(e, n, d);
		
		  return key;
	}

	@Override
	public BigInteger[] encrypt(BigInteger e, BigInteger n, char[] mensage) {
		BigInteger[] crypt = new BigInteger[mensage.length];
		for(int i = 0; i < mensage.length; i++) {
			crypt[i] = SquareMultiply.squareMultiply(e, n, new BigInteger(String.valueOf(Integer.valueOf(mensage[i]))));
		}
		return crypt;
	}

	@Override
	public char[] decrypt(BigInteger d, BigInteger n, BigInteger[] mensage) {
		char[] decrypt = new char[mensage.length];
		for(int i = 0; i < mensage.length; i++) {
			decrypt[i] = (char) SquareMultiply.squareMultiply(d, n, new BigInteger(String.valueOf(mensage[i]))).intValue();
		}
		return decrypt;
	}
}
