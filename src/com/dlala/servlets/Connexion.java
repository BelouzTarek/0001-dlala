package com.dlala.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlala.Utils.ServletUtils;
import com.dlala.Vue.Vues;
import com.dlala.bean.Annonce;
import com.dlala.bean.Utilisateur;
import com.dlala.dao.ajouterutilisateur.AjouterUtilisateurDAO;
import com.dlala.dao.ajouterutilisateur.impl.AjouterUtilisateurDAOImpl;
import com.dlala.dao.connexion.ConnexionDAO;
import com.dlala.dao.connexion.impl.ConnexionDAOImpl;
import com.dlala.dao.connexion.impl.ConnexionForme;
import com.dlala.dao.gesparams.GestParamsDAO;
import com.dlala.dao.gesparams.impl.GestParamsDAOImp;
import com.dlala.dao.injection.GuiceEntryPoint;
import com.dlala.params.Constant;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestParamsDAO dao = new GestParamsDAOImp();
		dao.setParams(request);
		Annonce annonce = new Annonce();
		annonce.setCategorie("100");
		request.setAttribute("annonce", annonce);
		this.getServletContext().getRequestDispatcher( Vues.connexionVue ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean rederection;
		Utilisateur utilisateur;
		switch (request.getParameter(Constant.ACTION)) {
		case Constant.ACTION_AJOUTERUTILISATEUR:
			utilisateur = GuiceEntryPoint.getInstance().getAjouterUtilisateurDAO().ajouterUtilisateur(request);
			rederection = utilisateur.getErreurs().isEmpty();
			this.dispach(request, response, rederection, utilisateur);
			break;
		case Constant.ACTION_CONNEXION:
			utilisateur = GuiceEntryPoint.getInstance().getConnexionDAO().connexion(request);
			rederection = utilisateur.getErreursconnexion().isEmpty();
			this.dispach(request, response, rederection, utilisateur);
			break;
		}
		
	}
	
	private void dispach(HttpServletRequest request, HttpServletResponse response,boolean rederection, Utilisateur utilisateur) throws ServletException, IOException {
		
		if(!rederection) {
			GestParamsDAO dao = new GestParamsDAOImp();
			dao.setParams(request);
			Annonce annonce = new Annonce();
			request.setAttribute("annonce", annonce);
			request.setAttribute(Constant.UTILISATEUR, utilisateur);
			this.getServletContext().getRequestDispatcher( Vues.connexionVue ).forward( request, response );
			
		}else {
			String url = request.getRequestURL().toString();
			String path = request.getServletPath();
			String redirection = url.substring(0, url.length() - path.length()) + "/";
			ServletUtils.setSessionUtilisateur(request, utilisateur);
			response.sendRedirect(redirection);
		}
		
	}

}
