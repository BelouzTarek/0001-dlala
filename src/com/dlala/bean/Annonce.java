package com.dlala.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Annonce {
	
	String idannonce,categorie,titre,description,prix,type,adresse,wilaya,email,telephone,afficherTelephone,datetime;
	Vehicule vehicule;
	Immobilier immobilier;
	ArrayList<String> images = new ArrayList<String>();
	ArrayList<String> urlImages = new ArrayList<String>();
	Map<String,String> erreurs = new HashMap<String, String>();
	


	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Immobilier getImmobilier() {
		return immobilier;
	}

	public void setImmobilier(Immobilier immobilier) {
		this.immobilier = immobilier;
	}

	public Annonce() {
		super();
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getIdannonce() {
		return idannonce;
	}

	public void setIdannonce(String idannonce) {
		this.idannonce = idannonce;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getWilaya() {
		return wilaya;
	}

	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}

	public ArrayList<String> getImages() {
		return images;
	}

	public void setImages(ArrayList<String> images) {
		this.images = images;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAfficherTelephone() {
		return afficherTelephone;
	}

	public void setAfficherTelephone(String afficherTelephone) {
		this.afficherTelephone = afficherTelephone;
	}

	public ArrayList<String> getUrlImages() {
		return urlImages;
	}

	public void setUrlImages(ArrayList<String> urlImages) {
		this.urlImages = urlImages;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}	
	
}
