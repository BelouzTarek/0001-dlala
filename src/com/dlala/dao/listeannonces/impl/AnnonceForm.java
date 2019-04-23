package com.dlala.dao.listeannonces.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.dlala.bean.AnnonceRequest;
import com.dlala.params.Constant;

public class AnnonceForm {
	
	// Commun
	private static final String CHAMP_TITRE = "titreannonce";
	private static final String CHAMP_CATEGORIE = "categorie";
	private static final String CHAMP_WILAYA = "wilaya";
	private static final String CHAMP_PRIX_MIN = "prixmin";
	private static final String CHAMP_PRIX_MAX = "prixmax";
	private static final String CHAMP_TYPE = "typeannonce";

	// IMMOBILIER
	private static final String CHAMP_SURFACE_MIN = "surfacemin";
	private static final String CHAMP_SURFACE_MAX = "surfacemax";
	private static final String CHAMP_TYPEDEBIEN = "typedebien";
	private static final String CHAMP_PIECES_MIN = "piecesmin";
	private static final String CHAMP_PIECES_MAX = "piecesmax";
	private static final String CHAMP_MEUBLE = "meuble";

	// VEHICULES
	private static final String CHAMP_ANNEE_MAX = "anneemax";
	private static final String CHAMP_ANNEE_MIN = "anneemin";
	private static final String CHAMP_MODELE = "modele";
	private static final String CHAMP_MARQUE = "marque";
	private static final String CHAMP_KILOMETRAGE_MAX = "kilometragemax";
	private static final String CHAMP_KILOMETRAGE_MIN = "kilometragemin";
	private static final String CHAMP_CARBURANT = "carburant";
	private static final String CHAMP_BOITEVITESSE = "boitevitesse";

	
	public AnnonceRequest setAnnonce(HttpServletRequest request) {
		
		List<String> categories = java.util.Arrays.asList(
				Constant.CATEGORIE_TOUTECATEGORIE,
				Constant.CATEGORIE_EMPLOI,
				Constant.CATEGORIE_IMMOBILIER,
				Constant.CATEGORIE_LOISIRS,
				Constant.CATEGORIE_MAISON,
				Constant.CATEGORIE_MATERIELPROFESSIONNEL,
				Constant.CATEGORIE_MULTIMEDIA,
				Constant.CATEGORIE_VEHICULES,
				Constant.CATEGORIE_VACANCE);
		
		AnnonceRequest annonce = new AnnonceRequest();
		
		annonce.setCategorie(request.getParameter(CHAMP_CATEGORIE));
		annonce.setTitre(request.getParameter(CHAMP_TITRE));
		annonce.setPrixmin(request.getParameter(CHAMP_PRIX_MIN));
		annonce.setPrixmax(request.getParameter(CHAMP_PRIX_MAX));
		annonce.setType(request.getParameter(CHAMP_TYPE));
		annonce.setWilaya(request.getParameter(CHAMP_WILAYA));

		annonce.setSurfacemin(request.getParameter(CHAMP_SURFACE_MIN));
		annonce.setSurfacemax(request.getParameter(CHAMP_SURFACE_MAX));
		annonce.setTypedebien(request.getParameter(CHAMP_TYPEDEBIEN));
		annonce.setPiecesmin(request.getParameter(CHAMP_PIECES_MIN));
		annonce.setPiecesmax(request.getParameter(CHAMP_PIECES_MAX));
		annonce.setMeuble(request.getParameter(CHAMP_MEUBLE));
		
		annonce.setAnneemax(request.getParameter(CHAMP_ANNEE_MAX));
		annonce.setAnneemin(request.getParameter(CHAMP_ANNEE_MIN));
		annonce.setModele(request.getParameter(CHAMP_MODELE));
		annonce.setMarque(request.getParameter(CHAMP_MARQUE));
		annonce.setKilometragemax(request.getParameter(CHAMP_KILOMETRAGE_MAX));
		annonce.setKilometragemin(request.getParameter(CHAMP_KILOMETRAGE_MIN));
		annonce.setCarburant(request.getParameter(CHAMP_CARBURANT));
		annonce.setBoitevitesse(request.getParameter(CHAMP_BOITEVITESSE));
		
		return annonce;
	}
}
