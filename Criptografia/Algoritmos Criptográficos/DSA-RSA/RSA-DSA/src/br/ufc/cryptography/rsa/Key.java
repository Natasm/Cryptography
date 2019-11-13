package br.ufc.cryptography.rsa;

import java.math.BigInteger;

public class Key {
    private BigInteger e, n, d;

	public BigInteger getE() {
		return e;
	}

	public void setE(BigInteger e) {
		this.e = e;
	}

	public BigInteger getN() {
		return n;
	}

	public void setN(BigInteger n) {
		this.n = n;
	}

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}
	
	public void setEND(BigInteger e, BigInteger n, BigInteger d) {
		this.e = e;
		this.n = n;
		this.d = d;
	}
    
}
