package br.ufc.cryptography.protocol.dsa;

import java.math.BigInteger;

public class Key extends KeyPublic{
    private BigInteger d, kE;

	public BigInteger getD() {
		return d;
	}

	public void setD(BigInteger d) {
		this.d = d;
	}

	public BigInteger getkE() {
		return kE;
	}

	public void setkE(BigInteger kE) {
		this.kE = kE;
	}
}
