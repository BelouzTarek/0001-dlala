package com.dlala.dao.db.annoncedb;

import java.util.List;

import com.dlala.bean.Annonce;
import com.dlala.bean.AnnonceRequest;

public abstract class AnnonceDataDAO {
	
	public abstract Annonce getAnnonceByID(Annonce annonce);
	
	public abstract boolean ajouterAnnonce(Annonce annonce) throws Exception;
	
	public abstract void supprimerAnnonce(Annonce annonce);
	
	public abstract List<Annonce> getListAnnonce(AnnonceRequest annonce) throws Exception;
	
}
