package com.dlala.params;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.dlala.bean.Categorie;
import com.dlala.bean.TypeDeBien;
import com.dlala.bean.Wilaya;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class GestParames {

	private static final String CONF_TYPEDEBIEN = "/com/dlala/confs/typedebien.xml";
	private static final String CONF_CATEGORIES = "/com/dlala/confs/categories.xml";
	private static final String CONF_WILAYAS = "/com/dlala/confs/wilayas.xml";
	private static final String CONF_CARBURANT = "/com/dlala/confs/carburant.xml";
	private static final String CONF_MARQUE = "/com/dlala/confs/marque.xml";
	private static final String CONF_BOITEVITESSE = "/com/dlala/confs/boitevitesse.xml";
	
	private static final String TAG_TYPEDEBIEN = "typedebien";
	private static final String TAG_WILAYA = "wilaya";
	private static final String TAG_CATEGORIE = "categorie";
	private static final String TAG_CARBURANT = "carburant";
	private static final String TAG_MARQUE = "marque";
	private static final String TAG_BOITEVITESSE = "boitevitesse";
	
	private static final String TAG_NUMERO = "numero";
	private static final String TAG_NOM = "nom";
	private static final String TAG_DISABLE = "disable";
	private static final String TAG_STYLE = "style";

	Wilaya wilaya;
	Categorie categorie;
	TypeDeBien typeDeBien;

	List<Wilaya> wilayaList = new ArrayList<>();
	List<Categorie> categoriesList = new ArrayList<>();
	List<TypeDeBien> typeDeBiensList = new ArrayList<>();
	Map<String,String> carburantList = new HashMap<>();
	Map<String,String> boitevitesseList = new HashMap<>();
	Map<String,String> marqueList = new HashMap<>();
	Map<String,String> nombrePieces = new HashMap<>();
	Map<String,String> annee = new HashMap<>();

	public List<Wilaya> getWilayas() {

		try {
			InputStream is = this.getClass().getResourceAsStream(CONF_WILAYAS);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(TAG_WILAYA);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String numero = eElement.getElementsByTagName(TAG_NUMERO).item(0).getTextContent();

					String nom = eElement.getElementsByTagName(TAG_NOM).item(0).getTextContent();

					wilaya = new Wilaya(numero, nom);
					wilayaList.add(wilaya);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return wilayaList;
	}

	public List<Categorie> getCategories() {
		try {
			InputStream is = this.getClass().getResourceAsStream(CONF_CATEGORIES);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			
			List<String> numeros = java.util.Arrays.asList(
					Constant.CATEGORIE_TOUTECATEGORIE,
					Constant.CATEGORIE_EMPLOI,
					Constant.CATEGORIE_IMMOBILIER,
					Constant.CATEGORIE_LOISIRS,
					Constant.CATEGORIE_MAISON,
					Constant.CATEGORIE_MATERIELPROFESSIONNEL,
					Constant.CATEGORIE_MULTIMEDIA,
					Constant.CATEGORIE_VEHICULES,
					Constant.CATEGORIE_VACANCE);
			
			NodeList nList = doc.getElementsByTagName(TAG_CATEGORIE);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String numero = eElement.getElementsByTagName(TAG_NUMERO).item(0).getTextContent();

					String nom = eElement.getElementsByTagName(TAG_NOM).item(0).getTextContent();
					
					String disable =""; 
					
					String style =""; 
					
					if(numeros.contains(numero)) {
						style = eElement.getElementsByTagName(TAG_STYLE).item(0).getTextContent();
						disable = eElement.getElementsByTagName(TAG_DISABLE).item(0).getTextContent();
					}
					
					categorie = new Categorie(numero, nom,disable,style);
					System.out.println(categorie.getValue());
					categoriesList.add(categorie);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoriesList;
	}

	public List<TypeDeBien> getTypeDeBien() {
		try {

			InputStream is = this.getClass().getResourceAsStream(CONF_TYPEDEBIEN);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(TAG_TYPEDEBIEN);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String numero = eElement.getElementsByTagName(TAG_NUMERO).item(0).getTextContent();

					String nom = eElement.getElementsByTagName(TAG_NOM).item(0).getTextContent();

					typeDeBien = new TypeDeBien(nom, numero);
					typeDeBiensList.add(typeDeBien);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return typeDeBiensList;
	}
	
	public Map<String,String> getListCarburant(){
		
		try {

			InputStream is = this.getClass().getResourceAsStream(CONF_CARBURANT);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(TAG_CARBURANT);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String numero = eElement.getElementsByTagName(TAG_NUMERO).item(0).getTextContent();

					String nom = eElement.getElementsByTagName(TAG_NOM).item(0).getTextContent();

					carburantList.put(numero, nom);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return carburantList;
	}
	
	public Map<String,String> getListBoiteVitesse(){
		
		try {

			InputStream is = this.getClass().getResourceAsStream(CONF_BOITEVITESSE);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(TAG_BOITEVITESSE);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String numero = eElement.getElementsByTagName(TAG_NUMERO).item(0).getTextContent();

					String nom = eElement.getElementsByTagName(TAG_NOM).item(0).getTextContent();

					boitevitesseList.put(numero, nom);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boitevitesseList;
	}
	
	public Map<String,String> getMarqueList(){
		
		try {

			InputStream is = this.getClass().getResourceAsStream(CONF_MARQUE);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(is);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(TAG_MARQUE);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String numero = eElement.getElementsByTagName(TAG_NUMERO).item(0).getTextContent();

					String nom = eElement.getElementsByTagName(TAG_NOM).item(0).getTextContent();

					marqueList.put(numero, nom);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return marqueList;
	}
	
	public Map<String,String> getNombrePieces(){
		
		for(int i = 1; i <=10; i++) {
			nombrePieces.put(Integer.toString(i), Integer.toString(i));
		}
		
		return nombrePieces;
	}
	
	public Map<String,String> getAnnees(){
		
		for(int i = 1980; i <=2019; i++) {
			annee.put(Integer.toString(i), Integer.toString(i));
		}
		
		return annee;
	}
	
	
	
	
}
