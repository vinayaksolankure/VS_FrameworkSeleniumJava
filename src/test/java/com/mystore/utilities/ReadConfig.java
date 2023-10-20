package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties properties;

	// Below path is config.properties file path.
	String path = "D:\\Eclipse Project\\Github Projects\\VS_FrameworkSeleniumJava\\Configuration\\config.properties";

	public ReadConfig() {
		try {
			properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getBaseUrl() {
		String value = properties.getProperty("baseUrl");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");
	}


	public String getBrowser() {
		String value = properties.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file.");
	}
	
	public String getUsername() {
		String value = properties.getProperty("username");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("username not specified in config file.");
	}
	
	public String getPassword() {
		String value = properties.getProperty("password");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("password not specified in config file.");
	}
	
	public String getUTubeURL() {
		String value = properties.getProperty("YoutubeURL");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("YoutubeURL not specified in config file.");
	}
}
