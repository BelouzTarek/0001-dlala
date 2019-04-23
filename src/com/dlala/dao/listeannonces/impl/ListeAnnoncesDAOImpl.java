package com.dlala.dao.listeannonces.impl;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.dlala.bean.Annonce;
import com.dlala.dao.gesparams.GestParamsDAO;
import com.dlala.dao.gesparams.impl.GestParamsDAOImp;
import com.dlala.dao.listeannonces.ListeAnnoncesDAO;
import com.dlala.dao.ws.annoncews.ServicesAnnonceDAO;
import com.google.inject.Inject;

public class ListeAnnoncesDAOImpl implements ListeAnnoncesDAO{

	@Inject
	ServicesAnnonceDAO dao;
	
	@Override
	public List<Annonce> getAnnonces(HttpServletRequest request) {
		List<Annonce> annonces = new ArrayList<Annonce>();
		GestParamsDAO gestParamsDAO = new GestParamsDAOImp();
		AnnonceForm form = new AnnonceForm();
		try {
			annonces.addAll(dao.getListeAnnonce(form.setAnnonce(request)));
			for(Annonce annonce : annonces) {
				gestParamsDAO.setParamsKeyToValue(annonce);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return annonces;
	}

}
