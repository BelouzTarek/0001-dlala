package com.dlala.dao.gesparams.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.dlala.bean.Annonce;
import com.dlala.bean.Categorie;
import com.dlala.bean.TypeDeBien;
import com.dlala.bean.Utilisateur;
import com.dlala.bean.Wilaya;
import com.dlala.dao.gesparams.GestParamsDAO;
import com.dlala.params.Constant;
import com.dlala.params.GestParames;

public class GestParamsDAOImp implements GestParamsDAO {

	private static final String LISTE_WILAYAS = "listewilayas";
	private static final String LISTE_CATEGORIE = "listecategorie";
	private static final String LISTE_TYPEDEBIEN = "listtypedebien";
	private static final String LISTE_MARQUE = "listmarque";
	private static final String LISTE_BOITEVITESSE = "listboitevitesse";
	private static final String LISTE_CARBURANT = "listcarburant";
	private static final String LISTE_ANNEES = "listcannees";
	private static final String LISTE_PIECES = "listpieces";
	
	@Override
	public void setParams(HttpServletRequest request) {
		GestParames gestParames = new GestParames();

		request.setAttribute(LISTE_WILAYAS, gestParames.getWilayas());
		request.setAttribute(LISTE_TYPEDEBIEN, gestParames.getTypeDeBien());
		request.setAttribute(LISTE_CARBURANT, gestParames.getListCarburant());
		request.setAttribute(LISTE_BOITEVITESSE, gestParames.getListBoiteVitesse());
		request.setAttribute(LISTE_MARQUE, gestParames.getMarqueList());
		request.setAttribute(LISTE_CATEGORIE, gestParames.getCategories());
		request.setAttribute(LISTE_ANNEES, gestParames.getAnnees());
		request.setAttribute(LISTE_PIECES, gestParames.getNombrePieces());
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constant.UTILISATEUR);
		Annonce annonce = new Annonce();
		annonce.setCategorie("100");
		
		if(null != utilisateur) {
			annonce.setTelephone(utilisateur.getTelephone());
			annonce.setEmail(utilisateur.getEmail());
			annonce.setAdresse(utilisateur.getAdresse());
			annonce.setWilaya(utilisateur.getWilaya());
		}
		
		request.setAttribute("annonce", annonce);

	}

	@Override
	public void setParamsKeyToValue(Annonce annonce) {

		GestParames gestParames = new GestParames();
		if(annonce.getImmobilier() != null ) {
			for(TypeDeBien typeDeBien : gestParames.getTypeDeBien()) {
				if(annonce.getImmobilier().getTypedebien().equals(typeDeBien.getNumero()) ) {
					annonce.getImmobilier().setTypedebien(typeDeBien.getNom());
				}
			}
		}
		
		for(Categorie categorie : gestParames.getCategories()) {
			if(annonce.getCategorie().equals(categorie.getValue())) {
				annonce.setCategorie(categorie.getName());
			}
		}
		
		for(Wilaya wilaya : gestParames.getWilayas()) {
			if(annonce.getWilaya().equals(wilaya.getNumeroWilaya())) {
				annonce.setWilaya(wilaya.getNomWilaya());
			}
		}
		
	}

}
