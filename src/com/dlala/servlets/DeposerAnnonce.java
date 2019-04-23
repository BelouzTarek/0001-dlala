package com.dlala.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlala.Utils.ServletUtils;
import com.dlala.Vue.Vues;
import com.dlala.bean.Annonce;
import com.dlala.dao.gesparams.GestParamsDAO;
import com.dlala.dao.gesparams.impl.GestParamsDAOImp;
import com.dlala.dao.injection.GuiceEntryPoint;
import com.dlala.params.Constant;

/**
 * Servlet implementation class DeposerAnnonce
 */
@WebServlet("/DeposerAnnonce")
public class DeposerAnnonce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeposerAnnonce() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestParamsDAO dao = new GestParamsDAOImp();
		dao.setParams(request);
		request.setAttribute(Constant.UTILISATEUR, ServletUtils.getUtilisateurFromSession(request));
		this.getServletContext().getRequestDispatcher( Vues.deposerAnnonceVue ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Annonce annonce = GuiceEntryPoint.getInstance().getDeposerAnnonceDAO().ajouterAnnonce(request);
		 Map<String, String> erreurs = new HashMap<String, String>();
		 erreurs.putAll(annonce.getErreurs());
		 
		 if(erreurs.isEmpty()) {
			 response.sendRedirect("https://www.google.fr/");
		 }else {
			 this.getServletContext().getRequestDispatcher(Vues.deposerAnnonceVue).forward(request, response);
		 }
		 
	}
	

}
