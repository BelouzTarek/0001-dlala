package com.dlala.dao.ajouterutilisateur.impl;

import javax.servlet.http.HttpServletRequest;

import com.dlala.bean.Utilisateur;
import com.dlala.dao.ajouterutilisateur.AjouterUtilisateurDAO;
import com.dlala.dao.ws.utilisateurws.ServiceUtilisateurDAO;
import com.dlala.dao.ws.utilisateurws.impl.ServiceUtilisateurDAOImpl;

public class AjouterUtilisateurDAOImpl implements AjouterUtilisateurDAO{

	@Override
	public Utilisateur ajouterUtilisateur(HttpServletRequest request) {
		
		ServiceUtilisateurDAO dao = new ServiceUtilisateurDAOImpl();
		AjouterUtilisateurForm form = new AjouterUtilisateurForm();
		
		 Utilisateur utilisateur = form.ajouterUtilisateurForm(request);
		 
		 if(utilisateur.getErreurs().isEmpty()) {
			 try {
				dao.ajouterUtilisateur(utilisateur);
			} catch (Exception e) {
				String message = e.getMessage();
				
				if(message.contains("Duplicate entry") && message.contains("telephone")) {
					utilisateur.getErreurs().put("telephone", "Le numéro de téléphone existe déja");
				}else if(message.contains("Duplicate entry") && message.contains("email")) {
					utilisateur.getErreurs().put("email", "L'email existe déja");
				}else {
					utilisateur.getErreurs().put("erreur", "Erreur technique");
				}
				
			}
		 }
		 
		
		return utilisateur;
	}

}
