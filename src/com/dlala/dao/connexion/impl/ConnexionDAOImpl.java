package com.dlala.dao.connexion.impl;

import javax.servlet.http.HttpServletRequest;

import com.dlala.bean.Utilisateur;
import com.dlala.dao.connexion.ConnexionDAO;
import com.dlala.dao.ws.utilisateurws.ServiceUtilisateurDAO;
import com.google.inject.Inject;

public class ConnexionDAOImpl implements ConnexionDAO{
	
	@Inject
	ServiceUtilisateurDAO dao;
	@Override
	public Utilisateur connexion(HttpServletRequest request) {
		
		ConnexionForme forme = new ConnexionForme();
		
		Utilisateur utilisateur = forme.connexionForm(request);
		
		if(utilisateur.getErreursconnexion().isEmpty()) {
			try {
				dao.Connexion(utilisateur);
			} catch (Exception e) {
				utilisateur.getErreursconnexion().put("erreurtechnique", "Erreur technique !");
			}
		}
		return utilisateur;
	}

}
