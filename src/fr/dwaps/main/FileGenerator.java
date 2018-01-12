package fr.dwaps.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FileGenerator {
	public static final String JSON = "json";
	
	private static final String PROP_CHAR = "#";
	private static final String VALUE_CHAR = "|";
	
	private Map<String,String> properties = new HashMap<>();
	
	public void generateDoc(String entity) {
		generateDoc(JSON, properties.get(entity+"-json"));
	}
	
	private void generateDoc(String doctype, String data) {
		
		String doc = "";
		
		switch (doctype) {
			case JSON:
				doc = generateJsonFile(data);
		}
		
		System.out.println(doc);
	}
	
	public List<String> getEntitiesName(String filename) {
		List<String> entities = new ArrayList<>();
		
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream(filename));
			Set<String> keys = prop.stringPropertyNames();
			
			for (String key : keys) {
				properties.put(key, prop.getProperty(key));
				entities.add(key.replace("-json", ""));
			}
		}
		catch (IOException e) {
			System.out.println("Le fichier n'a pas pu s'ouvrir : arrêt du programme...");
			System.exit(0);
		}
		
		return entities;
	}
	
	private String generateJsonFile(String data) {
		String json = "";
		
		if (!data.isEmpty()) {
			String[] dataTab = data.split(PROP_CHAR);
			String firstData = dataTab[1];
			String lastItemOfDataTab = dataTab[dataTab.length-1];
			String lastData = lastItemOfDataTab.substring(lastItemOfDataTab.lastIndexOf(VALUE_CHAR)+1);
			
			json = "[{\"" + firstData + "\": {";
			
			for (String element : dataTab) {
				String prop = "";
				String value = "";
				
				try {
					prop = element.substring(0, element.indexOf(VALUE_CHAR));
					value = element.substring(element.lastIndexOf(VALUE_CHAR)+1);
				} catch (Exception e) {}
				
				if (!prop.isEmpty()) {
					json += "\"" + prop + "\": \"" + value + "\"";
					if (!value.equals(lastData)) json += ",";
				}
				
			}
			
			json += "}}]";
		}
		
		return json;
	}
}
