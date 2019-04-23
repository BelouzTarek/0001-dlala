package com.dlala.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	
	public static Properties getProperties(String nomfichier) throws IOException {
		String FICHIER_PROPERTIES = "com/dlala/confs/xxx.properties";
		FICHIER_PROPERTIES = FICHIER_PROPERTIES.replace("xxx", nomfichier);
		Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );
        properties.load( fichierProperties );
        
		return properties;
	}
}
