package com.dlala.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dlala.Vue.Vues;
import com.dlala.bean.Annonce;
import com.dlala.dao.gesparams.GestParamsDAO;
import com.dlala.dao.gesparams.impl.GestParamsDAOImp;
import com.dlala.dao.injection.GuiceEntryPoint;


@WebServlet("/ListeAnnonces")
public class ListeAnnonces extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListeAnnonces() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestParamsDAO dao = new GestParamsDAOImp();
		dao.setParams(request);
		this.getServletContext().getRequestDispatcher( Vues.listeannoncesVue ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Annonce> listeannonces = GuiceEntryPoint.getInstance().getListeAnnoncesDAO().getAnnonces(request);
		GestParamsDAO dao = new GestParamsDAOImp();
		dao.setParams(request);
		request.setAttribute("listeannonces", listeannonces);
		this.getServletContext().getRequestDispatcher( Vues.listeannoncesVue ).forward( request, response );
	}

}
