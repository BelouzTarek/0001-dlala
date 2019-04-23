package com.dlala.bean;

import java.util.HashMap;
import java.util.Map;

public class ListeAnnonceParamsBean {

	Map<String, String> kilometrage = new HashMap<String, String>();
	Map<String, String> anneevehicule = new HashMap<String, String>();
	Map<String, String> petitprix = new HashMap<String, String>();
	Map<String, String> moyenprix = new HashMap<String, String>();
	Map<String, String> grandprix = new HashMap<String, String>();
	Map<String, String> tresgrandprix = new HashMap<String, String>();

	public ListeAnnonceParamsBean() {
		super();
		this.setKilometrage();
		this.setAnneevehicule();
	}
	
	public Map<String, String> getAnneevehicule() {
		return anneevehicule;
	}

	public Map<String, String> getKilometrage() {
		return kilometrage;
	}
	
	
	

	public void setPetitprix() {
		for(int pprix = 10; pprix <= 100; pprix+= 10) {
			petitprix.put(Integer.toString(pprix), Integer.toString(pprix));
		}
		
		for(int pprix = 150; pprix <= 500; pprix+= 50) {
			petitprix.put(Integer.toString(pprix), Integer.toString(pprix));
		}
	}

	public void setMoyenprix() {
		for(int mprix = 100; mprix <= 1000; mprix+= 100) {
			petitprix.put(Integer.toString(mprix), Integer.toString(mprix));
		}
		
		for(int mprix = 1500; mprix <= 3000; mprix+= 500) {
			petitprix.put(Integer.toString(mprix), Integer.toString(mprix));
		}
	}

	public void setGrandprix(Map<String, String> grandprix) {
		this.grandprix = grandprix;
	}

	public void setTresgrandprix(Map<String, String> tresgrandprix) {
		this.tresgrandprix = tresgrandprix;
	}

	public void setKilometrage() {

		for (int kilometre = 10000; kilometre <= 1000; kilometre += 10000) {
			kilometrage.put(Integer.toString(kilometre), Integer.toString(kilometre));
		}

		for (int kilometre = 125000; kilometre <= 200000; kilometre += 25000) {
			kilometrage.put(Integer.toString(kilometre), Integer.toString(kilometre));
		}

	}

	public void setAnneevehicule() {
		for(int annee=1960; annee <= 2000; annee += 5) {
			anneevehicule.put(Integer.toString(annee), Integer.toString(annee));
		}
		
		for(int annee=2001; annee <= 2019; annee ++) {
			anneevehicule.put(Integer.toString(annee), Integer.toString(annee));
		}
	}

}
