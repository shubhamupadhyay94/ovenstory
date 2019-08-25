package com.automate.framework.config;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ConfigReader {

	static String configPath = "\\input\\config.properties";
	static Logger logger = Logger.getLogger(ConfigReader.class);
	public static String log4jPath = "log4j.properties";

	static HashMap<String, String> configMap = null;

	static {
		configPath = System.getProperty("user.dir") + "\\" + configPath;
		System.out.println("Config "+configPath);
	}

	public static Properties readConfig() {

		PropertyConfigurator.configure(log4jPath);
		Properties prop = new Properties();
		try {

			File configFile = new File(configPath);
			FileReader reader = new FileReader(configFile);
			prop.load(reader);
		} catch (IOException e) {
			logger.error("error while reading config file .File path is " + configPath);
		} catch (Exception e) {
			logger.error("Error while reading config file");
		}
		return prop;

	}

	public static Map<String, String> loadConfig() {
		Properties props = readConfig();
		Set<Object> allKeys = props.keySet();
		configMap = new HashMap<String, String>();

		for (Object key : allKeys) {
			String setKey = (String) key;
			String setValue = props.getProperty(setKey);
			configMap.put(setKey, setValue);
			logger.info(setKey + " ______" + setValue);

		}
		return configMap;

	}

	public static String getConfig(String key) {

		return configMap.get(key);

	}

	public static void main(String args[]) {
		loadConfig();
		String str = ConfigReader.getConfig("chromePath");
		logger.info("Name is " + str);
	}
}
