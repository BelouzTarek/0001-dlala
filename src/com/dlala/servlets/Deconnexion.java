package com.dlala.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dlala.bean.Utilisateur;
import com.dlala.params.Constant;

/**
 * Servlet implementation class Deconnexion
 */
@WebServlet("/Deconnexion")
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Deconnexion() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constant.UTILISATEUR);
		
		String url = request.getRequestURL().toString();
		String path = request.getServletPath();
		String redirection = url.substring(0, url.length() - path.length()) + "/";
		
		if(null != utilisateur && utilisateur.isConnecte()) {
			session.invalidate();
	        response.sendRedirect( redirection );
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
