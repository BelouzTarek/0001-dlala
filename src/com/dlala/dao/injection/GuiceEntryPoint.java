package com.dlala.dao.injection;

import com.dlala.dao.ajouterutilisateur.AjouterUtilisateurDAO;
import com.dlala.dao.connexion.ConnexionDAO;
import com.dlala.dao.deposerannonce.DeposerAnnonceDAO;
import com.dlala.dao.listeannonces.ListeAnnoncesDAO;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceEntryPoint {

	private static AjouterUtilisateurDAO ajouterUtilisateurDAO;
	private static ConnexionDAO connexionDAO;
	private static DeposerAnnonceDAO deposerAnnonceDAO;
	private static ListeAnnoncesDAO listeAnnoncesDAO;
	
	private static GuiceEntryPoint guiceEntryPoint;
	
	public static GuiceEntryPoint getInstance() {
		Injector injector = Guice.createInjector(new ModuleDAO());
		ajouterUtilisateurDAO = injector.getInstance(AjouterUtilisateurDAO.class);
		connexionDAO = injector.getInstance(ConnexionDAO.class);
		deposerAnnonceDAO = injector.getInstance(DeposerAnnonceDAO.class);
		listeAnnoncesDAO = injector.getInstance(ListeAnnoncesDAO.class);
		
		if(guiceEntryPoint == null) {
			guiceEntryPoint = new GuiceEntryPoint();
		}
		
		return guiceEntryPoint;
	}

	public static ListeAnnoncesDAO getListeAnnoncesDAO() {
		return listeAnnoncesDAO;
	}

	public static AjouterUtilisateurDAO getAjouterUtilisateurDAO() {
		return ajouterUtilisateurDAO;
	}

	public static ConnexionDAO getConnexionDAO() {
		return connexionDAO;
	}

	public static DeposerAnnonceDAO getDeposerAnnonceDAO() {
		return deposerAnnonceDAO;
	}

	

}
