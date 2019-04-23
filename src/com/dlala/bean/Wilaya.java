package com.dlala.bean;

public class Wilaya {
	public Wilaya(String numeroWilaya, String nomWilaya) {
		super();
		this.numeroWilaya = numeroWilaya;
		this.nomWilaya = nomWilaya;
	}


	String numeroWilaya,nomWilaya;

	public String getNumeroWilaya() {
		return numeroWilaya;
	}

	public void setNumeroWilaya(String numeroWilaya) {
		this.numeroWilaya = numeroWilaya;
	}

	public String getNomWilaya() {
		return nomWilaya;
	}

	public void setNomWilaya(String nomWilaya) {
		this.nomWilaya = nomWilaya;
	}
	
	
}
