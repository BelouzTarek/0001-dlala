package com.dlala.dao.db.annoncedb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dlala.bean.Annonce;
import com.dlala.bean.AnnonceRequest;
import com.dlala.dao.db.annoncedb.AnnonceDataDAO;
import com.dlala.dbfactory.DBFactory;

public class AnnonceDataDAOImpl extends AnnonceDataDAO{
	
	public String AJOUTER_ANNONCE_ID = "AJOUTER_ANNONCE_ID";
	public String GET_LISTE_ANNONCE_ID = "GET_LISTE_ANNONCE_ID";
	public String DOSSIER = "annoncequery";
	
	Connection connect;

	public AnnonceDataDAOImpl() throws Exception{
		super();
		connect = DBFactory.getInstance();
	}

	@Override
	public Annonce getAnnonceByID(Annonce annonce) {
		return null;
	}

	@Override
	public boolean ajouterAnnonce(Annonce annonce) throws Exception {
		
		boolean res = false;
			
			String query = DBFactory.getQuery(this,AJOUTER_ANNONCE_ID,DOSSIER);
			
			PreparedStatement prepare = connect.prepareStatement(query);
			prepare.setString(1, annonce.getIdannonce());
			prepare.setString(2, annonce.getCategorie());
			prepare.setString(3, annonce.getTitre());
			prepare.setString(4, annonce.getDescription());
			prepare.setString(5, annonce.getPrix());
			prepare.setString(6, annonce.getType());
			prepare.setString(7, annonce.getAdresse());
			prepare.setString(8, annonce.getWilaya());
			prepare.setString(9, annonce.getEmail());
			prepare.setString(10, annonce.getTelephone());
			
			//Vehicule
			prepare.setString(11, annonce.getVehicule().getModele());
			prepare.setString(12, annonce.getVehicule().getAnnee());
			prepare.setString(13, annonce.getVehicule().getMarque());
			prepare.setString(14, annonce.getVehicule().getCarburant());
			prepare.setString(15, annonce.getVehicule().getKilometrage());
			prepare.setString(16, annonce.getVehicule().getBoitevitesse());
			
			//Immeuble
			prepare.setString(17, annonce.getImmobilier().getSurface());
			prepare.setString(18, annonce.getImmobilier().getPieces());
			prepare.setString(19, annonce.getImmobilier().getMeuble());
			prepare.setString(20, annonce.getImmobilier().getTypedebien());

			//Photos
			prepare.setString(21, "");
			prepare.setString(22, "");
			prepare.setString(23, "");
			
			for(int i =0; i < annonce.getImages().size();i++) {
				prepare.setString(i + 21, annonce.getUrlImages().get(i));
			}
			
			prepare.setString(24, annonce.getAfficherTelephone());

			
			System.out.println(prepare.toString());
			res = prepare.execute();
		
		return res;
	}

	@Override
	public void supprimerAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Annonce> getListAnnonce(AnnonceRequest annoncerequest) throws Exception{
		
		
		List<Annonce> listAnnonces = new ArrayList<Annonce>();
		
		
		String query = DBFactory.getQuery(this,GET_LISTE_ANNONCE_ID,DOSSIER);
		PreparedStatement prepare = this.setQuery(connect, annoncerequest, query);
		ResultSet result = prepare.executeQuery();
		
		while (result.next()) {
			Annonce annonce = new Annonce();
			ArrayList<String> listeImages = new ArrayList<String>();
			annonce.setIdannonce(result.getString("idAnnonce"));
			annonce.setCategorie(result.getString("categorie"));
			annonce.setTitre(result.getString("titre"));
			annonce.setPrix(result.getString("prix") + " DA");
			annonce.setWilaya(result.getString("wilaya"));
			listeImages.add(result.getString("photo1"));
			listeImages.add(result.getString("photo2"));
			listeImages.add(result.getString("photo3"));
			annonce.setDatetime(result.getString("datetime").substring(0,16));
			annonce.setUrlImages(listeImages);
			
			listAnnonces.add(annonce);

		}
		
		return listAnnonces;
	}
	
	
	private PreparedStatement setQuery(Connection connect,AnnonceRequest annoncerequest,String query) throws Exception {
		int index = 0;
		
		Map<Integer, String> mapper = new HashMap<Integer, String>();
		
		if(annoncerequest.getIdannonce() != null) {
			query += " AND idAnnonce LIKE ?";
			mapper.put(index, annoncerequest.getIdannonce());
			index++;
		}
		
		if(annoncerequest.getCategorie() != null) {
			query += " AND categorie LIKE ?";
			mapper.put(index, annoncerequest.getCategorie());
			index++;
		}
		
		if(annoncerequest.getTitre() != null) {
			query += " AND titre LIKE ?";
			mapper.put(index, annoncerequest.getTitre());
			index++;
		}
		
		if(annoncerequest.getPrixmax() != null) {
			query += " AND prix <= ?";
			mapper.put(index, annoncerequest.getPrixmax());
			index++;
		}
		
		if(annoncerequest.getPrixmin() != null) {
			query += " AND prix >= ?";
			mapper.put(index, annoncerequest.getPrixmin());
			index++;
		}
		
		if(annoncerequest.getWilaya() != null) {
			query += " AND wilaya LIKE ?";
			mapper.put(index, annoncerequest.getWilaya());
			index++;
		}
		
		if(annoncerequest.getType() != null) {
			query += " AND type LIKE ?";
			mapper.put(index, annoncerequest.getType());
			index++;
		}
		
		//Immobilier
		
		if(annoncerequest.getSurfacemax() != null) {
			query += " AND surface <= ?";
			mapper.put(index, annoncerequest.getSurfacemax());
			index++;
		}
		
		if(annoncerequest.getSurfacemin() != null) {
			query += " AND surface >= ?";
			mapper.put(index, annoncerequest.getSurfacemin());
			index++;
		}
		
		if(annoncerequest.getTypedebien() != null) {
			query += " AND typedebien LIKE ?";
			mapper.put(index, annoncerequest.getTypedebien());
			index++;
		}
		
		if(annoncerequest.getMeuble() != null) {
			query += " AND meuble LIKE ?";
			mapper.put(index, annoncerequest.getTypedebien());
			index++;
		}
		
		if(annoncerequest.getPiecesmax() != null) {
			query += " AND pieces <= ?";
			mapper.put(index, annoncerequest.getPiecesmax());
			index++;
		}
		
		if(annoncerequest.getPiecesmin() != null) {
			query += " AND pieces >= ?";
			mapper.put(index, annoncerequest.getPiecesmin());
			index++;
		}
		
		//Vehicule
		
		if(annoncerequest.getMarque() != null) {
			query += " AND marque LIKE ?";
			mapper.put(index, annoncerequest.getMarque());
			index++;
		}
		
		if(annoncerequest.getModele() != null) {
			query += " AND modele LIKE ?";
			mapper.put(index, annoncerequest.getModele());
			index++;
		}
		
		if(annoncerequest.getCarburant() != null) {
			query += " AND carburant LIKE ?";
			mapper.put(index, annoncerequest.getCarburant());
			index++;
		}
		
		if(annoncerequest.getBoitevitesse() != null) {
			query += " AND boitevitesse LIKE ?";
			mapper.put(index, annoncerequest.getBoitevitesse());
			index++;
		}
		
		if(annoncerequest.getAnneemax() != null) {
			query += " AND annee <= ?";
			mapper.put(index, annoncerequest.getAnneemax());
			index++;
		}
		
		if(annoncerequest.getAnneemin() != null) {
			query += " AND annee >= ?";
			mapper.put(index, annoncerequest.getAnneemin());
			index++;
		}
		
		if(annoncerequest.getKilometragemax() != null) {
			query += " AND kilometrage <= ?";
			mapper.put(index, annoncerequest.getKilometragemax());
			index++;
		}
		
		if(annoncerequest.getKilometragemin() != null) {
			query += " AND kilometrage >= ?";
			mapper.put(index, annoncerequest.getKilometragemin());
			index++;
		}
		
		query +=";";
		
		PreparedStatement prepare = connect.prepareStatement(query);
		
		for(int key : mapper.keySet()) {
			prepare.setString(key + 1,mapper.get(key));
		}
		
		return prepare;
	}

}
