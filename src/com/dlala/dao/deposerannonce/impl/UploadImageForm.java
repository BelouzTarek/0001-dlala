package com.dlala.dao.deposerannonce.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.dlala.bean.Annonce;

@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024,
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class UploadImageForm {

	private static final String CHAMP_IMAGE1 = "imageInput1";
	private static final String CHAMP_IMAGE2 = "imageInput2";
	private static final String CHAMP_IMAGE3 = "imageInput3";
	private static final String CHAMP_ERREUR = "image";
	private static final int TAILLE_TAMPON = 10240;

	private String resultat;
	private List<Part> images = new ArrayList<>();
	ArrayList<String> imagesPath = new ArrayList<String>();
	ArrayList<String> urlImages = new ArrayList<String>();
	Part image1, image2, image3;

	public String getResultat() {
		return resultat;
	}


	public void enregistrerFichier(HttpServletRequest request,Annonce annonce,Map<String, String> erreurs) {
		String idAnnonce = setNomFichier();
        String chemin = request.getServletContext().getRealPath("") + "photos/"
                + idAnnonce;
        String url = request.getRequestURL().toString();
        url = url.substring(0, url.length() - "deposerannonce".length()) + "photos/" + idAnnonce;
       
		File uploadDir = new File(chemin);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

		String nomFichier = null;
		InputStream contenuFichier = null;

		try {

			image1 = request.getPart(CHAMP_IMAGE1);
			image2 = request.getPart(CHAMP_IMAGE2);
			image3 = request.getPart(CHAMP_IMAGE3);

			if (image1 != null && image1.getSize() != 0) {
				images.add(image1);
			}

			if (image2 != null && image2.getSize() != 0) {
				images.add(image2);
			}

			if (image3 != null && image3.getSize() != 0) {
				images.add(image3);
			}

		} catch (IllegalStateException e) {
			e.printStackTrace();
			erreurs.put(CHAMP_ERREUR, "Les données envoyées sont trop volumineuses.");
		} catch (IOException e) {
			e.printStackTrace();
			erreurs.put(CHAMP_ERREUR, "Erreur de configuration du serveur.");
		} catch (ServletException e) {
			e.printStackTrace();
			erreurs.put(CHAMP_ERREUR,
					"Ce type de requête n'est pas supporté, merci d'utiliser le formulaire prévu pour envoyer votre fichier.");
		}
		
		if(erreurs.size() == 0) {

			for (Part image : images) {
				nomFichier = setNomImage();
				try {
					contenuFichier = image.getInputStream();
					ecrireFichier(contenuFichier, nomFichier, chemin,url);
				} catch (Exception e) {
					erreurs.put(CHAMP_ERREUR, "Erreur lors de l'écriture du fichier " + nomFichier + "sur le disque : " + chemin);
				}

			}
			
			annonce.setImages(imagesPath);
			annonce.setUrlImages(urlImages);
			annonce.setIdannonce(idAnnonce);
		}
	}

	private void ecrireFichier(InputStream contenu, String nomFichier, String chemin, String url) throws Exception {

		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		try {

			entree = new BufferedInputStream(contenu, TAILLE_TAMPON);
			File file = new File(chemin + "/" + nomFichier);
			FileOutputStream fos = new FileOutputStream(file);
			sortie = new BufferedOutputStream(fos, TAILLE_TAMPON);

			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur = 0;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
			
			imagesPath.add(chemin + "/" + nomFichier);
			urlImages.add(url + "/" + nomFichier);
			
			
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {
			}
			try {
				entree.close();
			} catch (IOException ignore) {
			}
		}
	}

	private String setNomImage() {
		int count = 10;
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString() + ".jpg";
	}
	
	private String setNomFichier() {
		int count = 10;
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}
}
