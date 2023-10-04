package com.amajon.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {
	Properties properties;
	String path = System.getProperty("user.dir");
	String otherPath= path + "\\Configuration\\config.properties";

	// constructor
	public ReadConfig() {
		try {
			properties = new Properties();

			FileInputStream fis = new FileInputStream(otherPath);
			properties.load(fis);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getBaseUrl() {

		String value = properties.getProperty("baseUrl");
		if (value != null)
			return value;
		else {
			throw new RuntimeException("URL not specified in properties file");
		}

	}

	public String getBrowser() {
		String value = properties.getProperty("browser");

		if (value != null)
			return value;
		else {
			throw new RuntimeException("Browser not specified in properties file");
		}
	}

}
