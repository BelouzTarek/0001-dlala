package com.dlala.Utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dlala.bean.Utilisateur;
import com.dlala.params.Constant;

public class ServletUtils {

	public static Utilisateur getUtilisateurFromSession(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constant.UTILISATEUR);

		if (null != utilisateur) {
			utilisateur.setConnexion("Déconexion");
			utilisateur.setConnecte(true);
			utilisateur.setConnexionlink("deconnexion");
		}else {
			utilisateur = new Utilisateur(); 
			utilisateur.setConnexion("Connexion");
			utilisateur.setConnecte(false);
			utilisateur.setConnexionlink("connexion");
		}
		return utilisateur;
	}
	
	public static void setSessionUtilisateur(HttpServletRequest request,Utilisateur utilisateur) {
		HttpSession session = request.getSession();
		session.setAttribute(Constant.UTILISATEUR, utilisateur);
	}
	
}
