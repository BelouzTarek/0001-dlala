package com.dlala.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dlala.Utils.ServletUtils;
import com.dlala.Vue.Vues;
import com.dlala.bean.Wilaya;
import com.dlala.params.Constant;
import com.dlala.params.GestParames;

/**
 * Servlet implementation class Acceuil
 */
@WebServlet("/Acceuil")
public class Acceuil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Wilaya> wilayaList = new ArrayList<>();
	List<Wilaya> wilayaListP1 = new ArrayList<>();
	List<Wilaya> wilayaListP2 = new ArrayList<>();
	private static final String LISTE_WILAYAS_P1 = "listewilayasp1";
	private static final String LISTE_WILAYAS_P2 = "listewilayasp2";
       
    public Acceuil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestParames gestParames = new GestParames();
		wilayaList = gestParames.getWilayas();
		wilayaListP1.clear();
		wilayaListP2.clear();
		for(int i = 0; i < 24; i++) {
			wilayaListP1.add(wilayaList.get(i));
		}
		
		for(int i = 24; i < 48; i++) {
			wilayaListP2.add(wilayaList.get(i));
		}
		

		this.setRequest(request);
		
		
		this.getServletContext().getRequestDispatcher( Vues.acceuilVue ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	private void setRequest(HttpServletRequest request) {
		request.setAttribute(LISTE_WILAYAS_P1, wilayaListP1);
		request.setAttribute(LISTE_WILAYAS_P2, wilayaListP2);
		request.setAttribute(Constant.UTILISATEUR, ServletUtils.getUtilisateurFromSession(request));
	}

}
