package fr.dwaps.main;

import java.io.FileInputStream;
import java.util.Properties;

public final class PropertiesReader {
	private static Properties properties;
	
	private PropertiesReader() {}
	
	static {
		properties = new Properties();
	}
	
	public static void getPro(String filename) {
		try {
			properties.load(new FileInputStream(filename));
		} catch (Exception e) {}
	}
}
