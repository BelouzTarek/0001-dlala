package com.dlala.dao.ws.annoncews;

import java.util.List;

import com.dlala.bean.Annonce;
import com.dlala.bean.AnnonceRequest;

public interface ServicesAnnonceDAO {
	
	public void ajouterAnnonce(Annonce annonce) throws Exception;
	
	public void modifierAnnonce(Annonce annonce) throws Exception;
	
	public void supprimerAnnonce(Annonce annonce) throws Exception;
	
	public List<Annonce> getListeAnnonce(AnnonceRequest annonce) throws Exception;
	
	public Annonce getAnnonceById(Annonce annonce) throws Exception;

}
