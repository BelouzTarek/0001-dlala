package com.dlala.bean;

import java.util.HashMap;
import java.util.Map;

public class Utilisateur {
	
	private String idUtilisateur,nom,prenom,email,motdepasse,telephone,adresse,wilaya,connexion,connexionlink;
	private Map<String, String> erreurs = new HashMap<String, String>();
	private Map<String, String> erreursconnexion = new HashMap<String, String>();
	String emailconnexion,motdepasseconnexion;
	boolean connecte;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getConnexion() {
		return connexion;
	}

	public void setConnexion(String connexion) {
		this.connexion = connexion;
	}

	public boolean isConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

	public String getConnexionlink() {
		return connexionlink;
	}

	public void setConnexionlink(String connexionlink) {
		this.connexionlink = connexionlink;
	}

	public String getEmailconnexion() {
		return emailconnexion;
	}

	public void setEmailconnexion(String emailconnexion) {
		this.emailconnexion = emailconnexion;
	}

	public String getMotdepasseconnexion() {
		return motdepasseconnexion;
	}

	public void setMotdepasseconnexion(String motdepasseconnexion) {
		this.motdepasseconnexion = motdepasseconnexion;
	}

	public Map<String, String> getErreursconnexion() {
		return erreursconnexion;
	}

	public void setErreursconnexion(Map<String, String> erreursconnexion) {
		this.erreursconnexion = erreursconnexion;
	}

	
}
