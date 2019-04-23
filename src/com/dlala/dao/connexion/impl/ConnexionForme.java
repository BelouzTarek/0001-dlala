package com.dlala.dao.connexion.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dlala.Utils.EmailTelephoneUtils;
import com.dlala.bean.Utilisateur;

public class ConnexionForme {
	
	private static String CHAMP_EMAIL = "emailconnexion";
	private static String CHAMP_MOT_DE_PASSE = "motdepasseconnexion";
	private Map<String, String> erreurs = new HashMap<String, String>();
	
	public Utilisateur connexionForm(HttpServletRequest request) {
		Utilisateur utilisateur = new Utilisateur();
		
		String emailconnexion = request.getParameter(CHAMP_EMAIL);
		String motdepasseconnexion = request.getParameter(CHAMP_MOT_DE_PASSE);
		
		try {
			utilisateur.setEmailconnexion(emailconnexion);
			validationEmail(emailconnexion);
		} catch (Exception e) {
			addErreur(CHAMP_EMAIL, e);
		}
		
		try {
			utilisateur.setMotdepasseconnexion(motdepasseconnexion);
			validationMotDePasse(motdepasseconnexion);
		} catch (Exception e) {
			addErreur(CHAMP_MOT_DE_PASSE, e);
		}
		
		utilisateur.setErreursconnexion(erreurs);
		
		return utilisateur;
	}
	
	private void validationMotDePasse(String motdepasse) throws Exception {
		if (motdepasse == null || motdepasse.isEmpty()) {
			throw new Exception("Le mot de passe est invalide");
		}
	}
	
	
	private void validationEmail(String email) throws Exception {
		EmailTelephoneUtils.checkEmail(email);
	}
	
	private void addErreur(String champ, Exception erreur) {
		erreurs.put(champ, erreur.getMessage());
	}

}
