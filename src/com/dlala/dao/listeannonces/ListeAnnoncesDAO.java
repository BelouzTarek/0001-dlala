package com.dlala.dao.listeannonces;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.dlala.bean.Annonce;

public interface ListeAnnoncesDAO {

	public List<Annonce> getAnnonces(HttpServletRequest request);
	
}
