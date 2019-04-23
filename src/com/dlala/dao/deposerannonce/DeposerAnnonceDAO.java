package com.dlala.dao.deposerannonce;


import javax.servlet.http.HttpServletRequest;
import com.dlala.bean.Annonce;

public interface DeposerAnnonceDAO {
	public Annonce ajouterAnnonce(HttpServletRequest request);
}
