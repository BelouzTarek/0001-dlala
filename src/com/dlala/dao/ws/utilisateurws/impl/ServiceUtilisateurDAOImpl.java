package com.dlala.dao.ws.utilisateurws.impl;


import com.dlala.bean.Utilisateur;
import com.dlala.dao.db.utilisateurdb.UtilisateurDataDAO;
import com.dlala.dao.db.utilisateurdb.impl.UtilisateurDataDAOImpl;
import com.dlala.dao.ws.utilisateurws.ServiceUtilisateurDAO;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ServiceUtilisateurDAOImpl implements ServiceUtilisateurDAO{
	
	@Inject
	UtilisateurDataDAO dao;
	
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) throws Exception {
		dao.ajouterUtilisateur(utilisateur);
	}

	@Override
	public void Connexion(Utilisateur utilisateur) throws Exception{
		dao.connexion(utilisateur);
	}

}
