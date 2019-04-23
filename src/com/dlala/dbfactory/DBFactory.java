package com.dlala.dbfactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dlala.Utils.PropertiesUtils;

public class DBFactory {

	public static Connection connexion;

	public static Connection getInstance() throws Exception {

		Properties properties = PropertiesUtils.getProperties("dao");

		String url = properties.getProperty("url");
		String utilisateur = properties.getProperty("nomutilisateur");
		String motDePasse = properties.getProperty("motdepasse");
		String driver = properties.getProperty("driver");

		Class.forName(driver);

		if (connexion == null) {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
		}

		return connexion;

	}
	
	
	
	public static String getQuery(Object objet, String idQuery, String dossier) {
		String query = null;
		String path = "/com/dlala/dao/ws/query/" + dossier + ".xml";
		NodeList nList = null;

		try {
			
		

			InputStream is = objet.getClass().getResourceAsStream(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			nList = doc.getElementsByTagName("requete");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					if (eElement.getAttribute("id").equals(idQuery)) {
						query = eElement.getElementsByTagName("contenue").item(0).getTextContent();
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return query;
	}

}
