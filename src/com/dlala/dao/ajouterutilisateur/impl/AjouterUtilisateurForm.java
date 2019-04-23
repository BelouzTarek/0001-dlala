package com.dlala.dao.ajouterutilisateur.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dlala.Utils.EmailTelephoneUtils;
import com.dlala.bean.Utilisateur;

public class AjouterUtilisateurForm {
	
	private static String CHAMP_NOM = "nom";
	private static String CHAMP_PRENOM = "prenom";
	private static String CHAMP_EMAIL = "email";
	private static String CHAMP_MOT_DE_PASSE = "motdepasse";
	private static String CHAMP_CONFIRMATION = "confirmation";
	private static String CHAMP_TELEPHONE = "telephone";
	private static String CHAMP_ADRESSE = "adresse";
	private static String CHAMP_WILAYA = "wilaya";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public Utilisateur ajouterUtilisateurForm(HttpServletRequest request) {
		
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String email = request.getParameter(CHAMP_EMAIL);
		String motdepasse = request.getParameter(CHAMP_MOT_DE_PASSE);
		String confirmation = request.getParameter(CHAMP_CONFIRMATION);
		String telephone = request.getParameter(CHAMP_TELEPHONE);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String wilaya = request.getParameter(CHAMP_WILAYA);
		
		Utilisateur utilisateur = new Utilisateur();
		String idUtilisateur = Long.toString(System.currentTimeMillis());
		
		try {
			utilisateur.setNom(nom);
			validationNom(nom);
		} catch (Exception erreur) {
			addErreur(CHAMP_NOM, erreur);
		}
		
		try {
			utilisateur.setPrenom(prenom);
			validationPrenom(prenom);
		} catch (Exception erreur) {
			addErreur(CHAMP_PRENOM, erreur);
		}
		
		try {
			utilisateur.setEmail(email);
			validationEmail(email);
		} catch (Exception erreur) {
			addErreur(CHAMP_EMAIL, erreur);
		}
		
		try {
			utilisateur.setMotdepasse(motdepasse);
			validationMotDePasse(motdepasse);
		} catch (Exception erreur) {
			addErreur(CHAMP_MOT_DE_PASSE, erreur);
			utilisateur.setMotdepasse("");
		}
		
		try {
			validationConfirmation(confirmation, motdepasse);
		} catch (Exception erreur) {
			addErreur(CHAMP_CONFIRMATION, erreur);
			utilisateur.setMotdepasse("");
		}
		
		try {
			utilisateur.setTelephone(telephone);
			validationTelephone(telephone);
		} catch (Exception erreur) {
			addErreur(CHAMP_TELEPHONE, erreur);
		}
		
		try {
			utilisateur.setAdresse(adresse);
			validationAdresse(adresse);
		} catch (Exception erreur) {
			addErreur(CHAMP_ADRESSE, erreur);
		}
		
		utilisateur.setWilaya(wilaya);
		utilisateur.setIdUtilisateur(idUtilisateur);
		
		utilisateur.setErreurs(erreurs);
		
		return utilisateur;
		
	}
	
	
	private void validationNom(String nom) throws Exception {
		if (nom == null || nom.isEmpty()) {
			throw new Exception("Le nom est obligatoir");
		}
	}
	
	private void validationPrenom(String prenom) throws Exception {
		if (prenom == null || prenom.isEmpty()) {
			throw new Exception("Le prénom est obligatoir");
		}
	}
	
	private void validationEmail(String email) throws Exception {
		EmailTelephoneUtils.checkEmail(email);
	}
	
	private void validationMotDePasse(String motdepasse) throws Exception {
		if (motdepasse == null || motdepasse.isEmpty()) {
			throw new Exception("Le mot de passe est obligatoir");
		}
	}
	
	private void validationConfirmation(String confirmation, String motdepasse) throws Exception {
		if (confirmation == null || confirmation.isEmpty() || !motdepasse.equals(confirmation)) {
			throw new Exception("le mot de passe et la confirmation sont différents");
		}
	}
	
	private void validationTelephone(String telephone) throws Exception {
		EmailTelephoneUtils.checkPhoneNumber(telephone);
	}
	
	private void validationAdresse(String adresse) throws Exception {
		if (adresse == null || adresse.isEmpty()) {
			throw new Exception("Le adresse est obligatoir");
		}
	}
	
	private void addErreur(String champ, Exception erreur) {
		erreurs.put(champ, erreur.getMessage());
	}


	public Map<String, String> getErreurs() {
		return erreurs;
	}


	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
	

}
