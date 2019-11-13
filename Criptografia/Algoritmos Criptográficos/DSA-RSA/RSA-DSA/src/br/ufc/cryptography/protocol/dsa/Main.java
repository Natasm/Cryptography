package br.ufc.cryptography.protocol.dsa;

public class Main {

	public static void main(String[] args){
		DSA dsa = new DSA();
		Key key = new Key();
		String mensage = "Natan";
		
		key = dsa.generateKey();
		key = dsa.generateSignature(key, mensage);
		
		KeyPublic keyPublic = (KeyPublic) key;
		System.out.print("Autentico? ");
		System.out.println(dsa.verificationSignature(keyPublic, mensage));
	}

}
