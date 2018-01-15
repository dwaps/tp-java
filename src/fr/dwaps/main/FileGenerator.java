package fr.dwaps.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
			dataTab = Arrays.copyOfRange(dataTab, 2, dataTab.length);
			String lastPairOfKeyValue = dataTab[dataTab.length-1];
			String veryLastValue = lastPairOfKeyValue.substring(lastPairOfKeyValue.lastIndexOf(VALUE_CHAR)+1);
			String key = dataTab[0];
			
			json = "{\"" + firstData + "\": [";
			
			for (int i = 0; i < dataTab.length; i++) {
				String element = dataTab[i];
				String prop = "", value = "";
				
				if (element.equals(key)) {
					if (i ==0) json += "{";
					else json = json.replaceAll(",$", "},{");
				}
				
				try {
					prop = element.substring(0, element.indexOf(VALUE_CHAR));
					value = element.substring(element.lastIndexOf(VALUE_CHAR)+1);
					
					if (!prop.isEmpty()) {
						json += "\"" + prop + "\":\"" + value + "\"";
						if (value.equals(veryLastValue)) json += "}";
						else json += ",";
					}
				} catch (IndexOutOfBoundsException e) {}
			}
			
			json += "]}";
		}
		
		return json;
	}
}
