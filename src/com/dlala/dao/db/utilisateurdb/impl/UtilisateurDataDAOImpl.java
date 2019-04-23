package com.dlala.dao.db.utilisateurdb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dlala.bean.Utilisateur;
import com.dlala.dao.db.utilisateurdb.UtilisateurDataDAO;
import com.dlala.dbfactory.DBFactory;

public class UtilisateurDataDAOImpl implements UtilisateurDataDAO {

	private static final String AJOUTER_UTILISATEUR_ID = "AJOUTER_UTILISATEUR_ID";
	private static final String DOSSIER = "utilisateurquery";
	private static final String CONNEXION_ID = "CONNEXION_ID";

	Connection connect;

	public UtilisateurDataDAOImpl() throws Exception {
		super();
		this.connect = DBFactory.getInstance();
	}

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) throws Exception {

		String query = DBFactory.getQuery(this, AJOUTER_UTILISATEUR_ID, DOSSIER);

		PreparedStatement prepare = connect.prepareStatement(query);

		prepare.setString(1, utilisateur.getIdUtilisateur());
		prepare.setString(2, utilisateur.getNom());
		prepare.setString(3, utilisateur.getPrenom());
		prepare.setString(4, utilisateur.getEmail());
		prepare.setString(5, utilisateur.getMotdepasse());
		prepare.setString(6, utilisateur.getTelephone());
		prepare.setString(7, utilisateur.getAdresse());
		prepare.setString(8, utilisateur.getWilaya());

		System.out.println(prepare.toString());
		prepare.execute();

	}

	@Override
	public void connexion(Utilisateur utilisateur) throws Exception {
		String query = DBFactory.getQuery(this, CONNEXION_ID, DOSSIER);

		PreparedStatement prepare = connect.prepareStatement(query);
		prepare.setString(1, utilisateur.getEmailconnexion());
		prepare.setString(2, utilisateur.getMotdepasseconnexion());
		System.out.println(prepare.toString());
		ResultSet result = prepare.executeQuery();

		int size = setUtilisateur(result, utilisateur);

		if (size == 0) {
			utilisateur.getErreursconnexion().put("erreurconnexion", "Email ou mot de passe incorrecte");
		}
	}

	private int setUtilisateur(ResultSet result, Utilisateur utilisateur) throws Exception {
		int size = 0;

		while (result.next()) {
			utilisateur.setIdUtilisateur(result.getNString("idutilisateur"));
			utilisateur.setNom(result.getNString("nom"));
			utilisateur.setPrenom(result.getNString("prénom"));
			utilisateur.setEmail(result.getNString("email"));
			utilisateur.setMotdepasse(result.getNString("motdepasse"));
			utilisateur.setTelephone(result.getNString("telephone"));
			utilisateur.setAdresse(result.getNString("adresse"));
			utilisateur.setWilaya(result.getNString("wilaya"));
			size++;
		}

		return size;
	}

}
