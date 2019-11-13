package br.ufc.cryptography.protocol.dsa;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import br.ufc.cryptography.utils.SquareMultiply;

public class DSA extends GenerateKey{

   public boolean verificationSignature(KeyPublic key, String mensage) {
	   BigInteger w = key.getS().modInverse(key.getQ());
	   BigInteger u1 = w.multiply(new BigInteger(String.valueOf(mensage.hashCode()))).mod(key.getQ());
	   BigInteger u2 = w.multiply(key.getR()).mod(key.getQ());
	   BigInteger a = SquareMultiply.squareMultiply(u1, key.getP(), key.getAlpha());
	   BigInteger b = SquareMultiply.squareMultiply(u2, key.getP(), key.getBeta());
	   BigInteger aMultb = a.multiply(b).mod(key.getP());
	   BigInteger v = aMultb.mod(key.getQ());
	   
	   if(v.compareTo(key.getR().mod(key.getQ())) == 0) return true;
	   else return false;
   } 
   
   public Key generateSignature(Key key, String mensage) {
	   key = generateKE(key);
	   key.setR(SquareMultiply.squareMultiply(key.getkE(), key.getP(), key.getAlpha()).mod(key.getQ()));
	   BigInteger keInv = key.getkE().modInverse(key.getQ());
	   BigInteger multAdd = (key.getR().multiply(key.getD())).add(new BigInteger(String.valueOf(mensage.hashCode())));
	   key.setS((multAdd.multiply(keInv)).mod(key.getQ()));
	   return key;
   }
	
   private Key generateKE(Key key) {
	  SecureRandom secRandom = new SecureRandom();
	  Random random = new Random();
	  int num = random.nextInt(key.getD().bitLength()) + 2;
	  if(num < 0) num*=-1;
	  BigInteger kE = BigInteger.probablePrime(num, secRandom);
	  key.setkE(kE);
	  return key;
   }
}
