package com.dlala.dao.ws.annoncews.impl;

import java.util.List;

import com.dlala.bean.Annonce;
import com.dlala.bean.AnnonceRequest;
import com.dlala.dao.db.annoncedb.AnnonceDataDAO;
import com.dlala.dao.ws.annoncews.ServicesAnnonceDAO;
import com.google.inject.Inject;

public class ServiceAnnonceDAOImp implements ServicesAnnonceDAO{

	@Inject
	AnnonceDataDAO dao;
	@Override
	public void ajouterAnnonce(Annonce annonce) throws Exception {
		dao.ajouterAnnonce(annonce);
	}

	@Override
	public void modifierAnnonce(Annonce annonce) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerAnnonce(Annonce annonce) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Annonce> getListeAnnonce(AnnonceRequest annonce) throws Exception{
		return dao.getListAnnonce(annonce);
	}

	@Override
	public Annonce getAnnonceById(Annonce annonce)throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
