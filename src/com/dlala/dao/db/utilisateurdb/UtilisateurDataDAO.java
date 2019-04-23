package com.dlala.dao.db.utilisateurdb;

import com.dlala.bean.Utilisateur;

public interface UtilisateurDataDAO {
	
	public void ajouterUtilisateur(Utilisateur utilisateur) throws Exception;
	
	public void connexion(Utilisateur utilisateur) throws Exception;

}
