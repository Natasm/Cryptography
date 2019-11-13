package br.ufc.cryptography.protocol.dsa;

import java.math.BigInteger;
import java.security.SecureRandom;

import br.ufc.cryptography.utils.SquareMultiply;

public class GenerateKey{
	
	public Key generateKey() {
		Key key = new Key();

		key = findPrime(key);
		key = generateAlpha(key);
		key = generateD(key);
		key = computeBeta(key);
		
		return key;
	}
	
	private Key computeBeta(Key key) {
		key.setBeta(SquareMultiply.squareMultiply(key.getD(), key.getP(), key.getAlpha()));
		return key;
	}
	
	private Key generateD(Key key) {
		SecureRandom secRandom = new SecureRandom();
		BigInteger d = BigInteger.probablePrime(128, secRandom);
		key.setD(d);
		return key;
	}
	
	private Key generateAlpha(Key key) {
		BigInteger g = new BigInteger("65537");
		BigInteger h = key.getP().subtract(BigInteger.ONE).divide(key.getQ());
		BigInteger alpha;
		alpha = SquareMultiply.squareMultiply(h, key.getP(), g);
		key.setAlpha(alpha);
		return key;
	}

	private Key findPrime(Key key) {
		SecureRandom random = new SecureRandom();
		BigInteger q = BigInteger.probablePrime(160, random);
		
		for(int i = 0; i < 4096;i++) {
			BigInteger m = BigInteger.probablePrime(200, random);
			BigInteger mr = m.mod(q.multiply(new BigInteger("2")));
			BigInteger pSub = m.subtract(mr);
			BigInteger p = pSub.add(BigInteger.ONE);
			if(p.isProbablePrime(1)) {
				key.setP(p);
				key.setQ(q);
				return key;
			}
		}
		return key;
	}
}
