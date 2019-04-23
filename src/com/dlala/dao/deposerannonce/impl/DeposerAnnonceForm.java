package com.dlala.dao.deposerannonce.impl;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dlala.Utils.EmailTelephoneUtils;
import com.dlala.bean.Annonce;

import com.dlala.bean.Immobilier;
import com.dlala.bean.Vehicule;
import com.dlala.params.Constant;
import com.dlala.params.GestParames;

public class DeposerAnnonceForm {

	private static final String LISTE_WILAYAS = "listewilayas";
	private static final String LISTE_CATEGORIE = "listecategorie";
	private static final String LISTE_TYPEDEBIEN = "listtypedebien";
	private static final String LISTE_MARQUE = "listmarque";
	private static final String LISTE_BOITEVITESSE = "listboitevitesse";
	private static final String LISTE_CARBURANT = "listcarburant";
	private static final String ERREURS = "erreurs";
	private static final String ANNONCE = "annonce";

	// Commun
	private static final String CHAMP_TITRE = "titreannonce";
	private static final String CHAMP_DESCRIPTION = "descriptionannonce";
	private static final String CHAMP_CATEGORIE = "categorie";
	private static final String CHAMP_ADRESSE = "adresse";
	private static final String CHAMP_WILAYA = "wilaya";
	private static final String CHAMP_PRIX = "prix";
	private static final String CHAMP_TYPE = "typeannonce";
	private static final String CHAMP_EMAIL = "email";
	private static final String CHAMP_TELEPHONE = "telephone";

	// IMMOBILIER
	private static final String CHAMP_SURFACE = "surface";
	private static final String CHAMP_TYPEDEBIEN = "typedebien";
	private static final String CHAMP_PIECES = "pieces";
	private static final String CHAMP_MEUBLE = "meuble";

	// VEHICULES
	private static final String CHAMP_ANNEE = "annee";
	private static final String CHAMP_MODELE = "modele";
	private static final String CHAMP_MARQUE = "marque";

	private static final String CHAMP_KILOMETRAGE = "kilometrage";
	private static final String CHAMP_CARBURANT = "carburant";
	private static final String CHAMP_BOITEVITESSE = "boitevitesse";

	// LIBELLE COMMUN
	private static final String LIBELLE_TITRE = "Titre de l'annonce";
	private static final String LIBELLE_DESCRIPTION = "Description de l'annonce";
	private static final String LIBELLE_CATEGORIE = "Catégorie";
	private static final String LIBELLE_WILAYAS = "Wilaya";
	private static final String LIBELLE_ADRESSE = "Adresse";
	private static final String LIBELLE_PRIX = "Prix";
	private static final String LIBELLE_TYPE = "Type d'annonce";

	// LIBELLE IMMOBILIER
	private static final String LIBELLE_SURFACE = "Surface";
	private static final String LIBELLE_TYPEDEBIEN = "Type de bien";
	private static final String LIBELLE_PIECES = "Piéces";
	private static final String LIBELLE_MEUBLE = "Meublé";

	// LBELLE VEHICULES
	private static final String LIBELLE_ANNEE = "Année";
	private static final String LIBELLE_MODELE = "Modéle";
	private static final String LIBELLE_MARQUE = "Marque";
	private static final String LIBELLE_KILOMETRAGE = "Kilométrage";
	private static final String LIBELLE_CARBURANT = "Carburant";
	private static final String LIBELLE_BOITEVITESSE = "Boite Vitesse";

	// Tel
	private static final String CHAMP_AFFICHERTELEPHONE = "afficherTelephone";

	private Map<String, String> erreurs = new HashMap<String, String>();
	Annonce annonce = new Annonce();
	UploadImageForm uploadImageForm = new UploadImageForm();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	private void setErreur(String key, String value) {
		erreurs.put(key, value);
	}

	private void validationChamps(String champs, String libelle) throws Exception {
		if (champs == null || champs.isEmpty()) {
			throw new Exception("Le champs <strong>" + libelle + " </strong>est obligatoir");
		}

	}

	private void validationEmail(String email) throws Exception {
		EmailTelephoneUtils.checkEmail(email);
	}

	private void validationTelephone(String telephone) throws Exception {
		EmailTelephoneUtils.checkPhoneNumber(telephone);
	}

	private void validationCombo(String champs, String libelle) throws Exception {
		if (champs == null || champs.equals("0")) {
			throw new Exception("Le champs <strong>" + libelle + " </strong>est obligatoir");
		}

	}

	private void validationCategorie(String champs, String libelle) throws Exception {
		if (champs == null || champs.equals("0") || champs.equals(Constant.CATEGORIE_TOUTECATEGORIE)) {
			throw new Exception("Le champs <strong>" + libelle + " </strong>est obligatoir");

		}

	}

	public Annonce deposerAnnonceForme(HttpServletRequest request) {

		String titre = request.getParameter(CHAMP_TITRE);
		String description = request.getParameter(CHAMP_DESCRIPTION);
		String categorie = request.getParameter(CHAMP_CATEGORIE);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String wilaya = request.getParameter(CHAMP_WILAYA);
		String prix = request.getParameter(CHAMP_PRIX);
		String type = request.getParameter(CHAMP_TYPE);
		String afficherTelephone = request.getParameter(CHAMP_AFFICHERTELEPHONE);
		String email = request.getParameter(CHAMP_EMAIL);
		String telephone = request.getParameter(CHAMP_TELEPHONE);
		
		annonce.setImmobilier(new Immobilier());
		annonce.setVehicule(new Vehicule());

		try {
			annonce.setCategorie(categorie);
			validationCategorie(categorie, LIBELLE_CATEGORIE);

		} catch (Exception e) {
			setErreur(CHAMP_CATEGORIE, e.getMessage());
		}

		try {
			annonce.setTitre(titre);
			validationChamps(titre, LIBELLE_TITRE);

		} catch (Exception e) {
			setErreur(CHAMP_TITRE, e.getMessage());
		}

		if (null != categorie && Constant.CATEGORIE_IMMOBILIER_LIST.contains(categorie)) {
			validerImmobilier(request);
		} else if (null != categorie && Constant.CATEGORIE_VEHICULES_LIST.contains(categorie)) {
			validerVehicule(request);
		}

		try {
			annonce.setDescription(description);
			validationChamps(description, LIBELLE_DESCRIPTION);

		} catch (Exception e) {
			setErreur(CHAMP_DESCRIPTION, e.getMessage());
		}

		try {
			annonce.setType(type);
			validationChamps(type, LIBELLE_TYPE);

		} catch (Exception e) {
			setErreur(CHAMP_TYPE, e.getMessage());
		}

		try {
			annonce.setPrix(prix);
			validationChamps(prix, LIBELLE_PRIX);

		} catch (Exception e) {
			setErreur(CHAMP_PRIX, e.getMessage());
		}

		try {
			annonce.setWilaya(wilaya);
			validationCombo(wilaya, LIBELLE_WILAYAS);

		} catch (Exception e) {
			setErreur(CHAMP_WILAYA, e.getMessage());
		}

		try {
			annonce.setAdresse(adresse);
			validationChamps(adresse, LIBELLE_ADRESSE);

		} catch (Exception e) {
			setErreur(CHAMP_ADRESSE, e.getMessage());
		}

		try {
			annonce.setTelephone(telephone);
			validationTelephone(telephone);
		} catch (Exception e) {
			setErreur(CHAMP_TELEPHONE, e.getMessage());
		}

		
		try {
			annonce.setEmail(email);
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}

		annonce.setAfficherTelephone(afficherTelephone);

		return annonce;

	}

	private void validerImmobilier(HttpServletRequest request) {

		String surface = request.getParameter(CHAMP_SURFACE);
		String typedebien = request.getParameter(CHAMP_TYPEDEBIEN);
		String pieces = request.getParameter(CHAMP_PIECES);
		String meuble = request.getParameter(CHAMP_MEUBLE);


		try {

			annonce.getImmobilier().setSurface(surface);
			validationChamps(surface, LIBELLE_SURFACE);
		} catch (Exception e) {
			setErreur(CHAMP_SURFACE, e.getMessage());
		}

		try {
			annonce.getImmobilier().setTypedebien(typedebien);
			validationCombo(typedebien, LIBELLE_TYPEDEBIEN);
		} catch (Exception e) {
			setErreur(CHAMP_TYPEDEBIEN, e.getMessage());
		}

		try {
			annonce.getImmobilier().setPieces(pieces);
			validationChamps(pieces, LIBELLE_PIECES);
		} catch (Exception e) {
			setErreur(CHAMP_PIECES, e.getMessage());
		}

		try {
			annonce.getImmobilier().setMeuble(meuble);
			validationCombo(meuble, LIBELLE_MEUBLE);
		} catch (Exception e) {
			setErreur(CHAMP_MEUBLE, e.getMessage());
		}

	}

	private void validerVehicule(HttpServletRequest request) {

		String annee = request.getParameter(CHAMP_ANNEE);
		String modele = request.getParameter(CHAMP_MODELE);
		String marque = request.getParameter(CHAMP_MARQUE);
		String kilometrage = request.getParameter(CHAMP_KILOMETRAGE);
		String carburant = request.getParameter(CHAMP_CARBURANT);
		String boitevitesse = request.getParameter(CHAMP_BOITEVITESSE);


		try {
			annonce.getVehicule().setAnnee(annee);
			validationChamps(annee, LIBELLE_ANNEE);
		} catch (Exception e) {
			setErreur(CHAMP_ANNEE, e.getMessage());
		}

		try {
			annonce.getVehicule().setModele(modele);
			validationChamps(modele, LIBELLE_MODELE);
		} catch (Exception e) {
			setErreur(CHAMP_MODELE, e.getMessage());
		}

		try {
			annonce.getVehicule().setMarque(marque);
			validationCombo(marque, LIBELLE_MARQUE);
		} catch (Exception e) {
			setErreur(CHAMP_MARQUE, e.getMessage());
		}

		try {
			annonce.getVehicule().setKilometrage(kilometrage);
			validationChamps(kilometrage, LIBELLE_KILOMETRAGE);
		} catch (Exception e) {
			setErreur(CHAMP_KILOMETRAGE, e.getMessage());
		}

		try {
			annonce.getVehicule().setCarburant(carburant);
			validationCombo(carburant, LIBELLE_CARBURANT);
		} catch (Exception e) {
			setErreur(CHAMP_CARBURANT, e.getMessage());
		}

		try {
			annonce.getVehicule().setBoitevitesse(boitevitesse);
			validationCombo(boitevitesse, LIBELLE_BOITEVITESSE);
		} catch (Exception e) {
			setErreur(CHAMP_BOITEVITESSE, e.getMessage());
		}

	}

	public void setAttribut(HttpServletRequest request, Annonce annonce) {

		GestParames gestParames = new GestParames();

		request.setAttribute(LISTE_WILAYAS, gestParames.getWilayas());
		request.setAttribute(LISTE_TYPEDEBIEN, gestParames.getTypeDeBien());
		request.setAttribute(LISTE_CARBURANT, gestParames.getListCarburant());
		request.setAttribute(LISTE_BOITEVITESSE, gestParames.getListBoiteVitesse());
		request.setAttribute(LISTE_MARQUE, gestParames.getMarqueList());
		request.setAttribute(LISTE_CATEGORIE, gestParames.getCategories());
		request.setAttribute(ERREURS, erreurs);
		request.setAttribute(ANNONCE, annonce);

	}

}
