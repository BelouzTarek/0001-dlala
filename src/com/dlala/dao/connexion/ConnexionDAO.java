package com.dlala.dao.connexion;

import javax.servlet.http.HttpServletRequest;

import com.dlala.bean.Utilisateur;

public interface ConnexionDAO {
	
	public Utilisateur connexion(HttpServletRequest request);

}
