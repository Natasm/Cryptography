package br.ufc.cryptography.rsa;

import java.math.BigInteger;

public interface Operation {
     Key generateKey(int sizeBit);
     BigInteger[] encrypt(BigInteger e, BigInteger n, char[] mensage);
     char[] decrypt(BigInteger d, BigInteger n, BigInteger[] mensage);
}

