package com.dlala.dao.ws.utilisateurws;


import com.dlala.bean.Utilisateur;

public interface ServiceUtilisateurDAO {
	
	public void ajouterUtilisateur(Utilisateur utilisateur) throws Exception;
	
	public void Connexion(Utilisateur utilisateur) throws Exception;

}
