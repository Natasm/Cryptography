package br.ufc.cryptography.rsa;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		RSA rsa = new RSA();
		Key key = new Key();
		
		key = rsa.generateKey(128);
		
		String mensage = "Nata Santana de Morais";
		
		System.out.println("Public key = " + key.getE() + "\nMod = " + key.getN() + "\nPrivate key = "+ key.getD()+"\n");
		
		BigInteger[] encrypt = rsa.encrypt(key.getE(), key.getN(), mensage.toCharArray());
		char[] decrypt = rsa.decrypt(key.getD(), key.getN(), encrypt);
		
		System.out.println("ENCRYPT");
	    for(int i = 0; i < encrypt.length;i++) {
	    	System.out.println(encrypt[i]);
	    }
	    
	    System.out.println("\nDECRYPT");
	    for(int i = 0; i < decrypt.length;i++) {
	    	System.out.print(decrypt[i]);
	    }
		
	}

}
