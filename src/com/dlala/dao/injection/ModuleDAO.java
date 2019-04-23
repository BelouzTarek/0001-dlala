package com.dlala.dao.injection;
import com.dlala.dao.ajouterutilisateur.AjouterUtilisateurDAO;
import com.dlala.dao.ajouterutilisateur.impl.AjouterUtilisateurDAOImpl;
import com.dlala.dao.connexion.ConnexionDAO;
import com.dlala.dao.connexion.impl.ConnexionDAOImpl;
import com.dlala.dao.db.annoncedb.AnnonceDataDAO;
import com.dlala.dao.db.annoncedb.impl.AnnonceDataDAOImpl;
import com.dlala.dao.db.utilisateurdb.UtilisateurDataDAO;
import com.dlala.dao.db.utilisateurdb.impl.UtilisateurDataDAOImpl;
import com.dlala.dao.deposerannonce.DeposerAnnonceDAO;
import com.dlala.dao.deposerannonce.impl.DeposerAnnonceDAOImpl;
import com.dlala.dao.listeannonces.ListeAnnoncesDAO;
import com.dlala.dao.listeannonces.impl.ListeAnnoncesDAOImpl;
import com.dlala.dao.ws.annoncews.ServicesAnnonceDAO;
import com.dlala.dao.ws.annoncews.impl.ServiceAnnonceDAOImp;
import com.dlala.dao.ws.utilisateurws.ServiceUtilisateurDAO;
import com.dlala.dao.ws.utilisateurws.impl.ServiceUtilisateurDAOImpl;
import com.google.inject.AbstractModule;


public class ModuleDAO extends AbstractModule{

	@Override
	protected void configure() {
		bind(ServiceUtilisateurDAO.class).to(ServiceUtilisateurDAOImpl.class);
		bind(UtilisateurDataDAO.class).to(UtilisateurDataDAOImpl.class);
		bind(AjouterUtilisateurDAO.class).to(AjouterUtilisateurDAOImpl.class);
		bind(ConnexionDAO.class).to(ConnexionDAOImpl.class);
		
		bind(ServicesAnnonceDAO.class).to(ServiceAnnonceDAOImp.class);
		bind(AnnonceDataDAO.class).to(AnnonceDataDAOImpl.class);
		bind(DeposerAnnonceDAO.class).to(DeposerAnnonceDAOImpl.class);
		bind(ListeAnnoncesDAO.class).to(ListeAnnoncesDAOImpl.class);
		
	}

}
