package com.dlala.dao.deposerannonce.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dlala.Utils.DossierUtils;
import com.dlala.bean.Annonce;
import com.dlala.dao.deposerannonce.DeposerAnnonceDAO;
import com.dlala.dao.gesparams.GestParamsDAO;
import com.dlala.dao.gesparams.impl.GestParamsDAOImp;
import com.dlala.dao.ws.annoncews.ServicesAnnonceDAO;
import com.google.inject.Inject;

public class DeposerAnnonceDAOImpl implements DeposerAnnonceDAO{

	@Inject
	ServicesAnnonceDAO servicesAnnonceDAO;
	@Override
	public Annonce ajouterAnnonce(HttpServletRequest request){
		Map<String, String> erreurs = new HashMap<String, String>();
		Annonce annonce = new Annonce();
		UploadImageForm uploadImageForm = new UploadImageForm();
		DeposerAnnonceForm deposerAnnonce = new DeposerAnnonceForm();
		GestParamsDAO gestParamsDAO = new GestParamsDAOImp();
		annonce = deposerAnnonce.deposerAnnonceForme(request);
		erreurs = deposerAnnonce.getErreurs();
		
		if(erreurs.size() == 0) {
			uploadImageForm.enregistrerFichier(request, annonce, erreurs);
		}
		
		if(erreurs.size() ==0) {
			try {
				servicesAnnonceDAO.ajouterAnnonce(annonce);
			} catch (Exception e) {
				e.printStackTrace();
				DossierUtils.supprimerDossier(annonce.getImages());
				erreurs.put("Technique", "Erreur technique est produit");
			}
		}
		
		gestParamsDAO.setParams(request);
		annonce.setErreurs(erreurs);
		request.setAttribute("annonce", annonce);
		
		return annonce;
	}

}
