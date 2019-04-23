package com.dlala.dao.ajouterutilisateur;

import javax.servlet.http.HttpServletRequest;

import com.dlala.bean.Utilisateur;

public interface AjouterUtilisateurDAO {
	
	public Utilisateur ajouterUtilisateur(HttpServletRequest request);

}
