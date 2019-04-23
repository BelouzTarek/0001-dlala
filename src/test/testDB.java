package test;


import org.junit.jupiter.api.Test;
import com.dlala.bean.AnnonceRequest;
import com.dlala.dao.db.annoncedb.AnnonceDataDAO;
import com.dlala.dao.db.annoncedb.impl.AnnonceDataDAOImpl;
import com.dlala.dao.injection.GuiceEntryPoint;
import com.dlala.dao.ws.annoncews.ServicesAnnonceDAO;
import com.dlala.dao.ws.annoncews.impl.ServiceAnnonceDAOImp;


class testDB {


	@Test
	void test() {
		
		AnnonceRequest annonce = new AnnonceRequest();
		try {
			AnnonceDataDAO dao = new AnnonceDataDAOImpl();
			dao.getListAnnonce(annonce);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
