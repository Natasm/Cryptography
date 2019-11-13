package br.ufc.cryptography.protocol.dsa;

import java.math.BigInteger;

public class KeyPublic {
    private BigInteger p, q, alpha, beta, r ,s;

	public BigInteger getP() {
		return p;
	}

	public void setP(BigInteger p) {
		this.p = p;
	}

	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger q) {
		this.q = q;
	}

	public BigInteger getAlpha() {
		return alpha;
	}

	public void setAlpha(BigInteger alpha) {
		this.alpha = alpha;
	}

	public BigInteger getBeta() {
		return beta;
	}

	public void setBeta(BigInteger beta) {
		this.beta = beta;
	}

	public BigInteger getR() {
		return r;
	}

	public void setR(BigInteger r) {
		this.r = r;
	}

	public BigInteger getS() {
		return s;
	}

	public void setS(BigInteger s) {
		this.s = s;
	}
}
