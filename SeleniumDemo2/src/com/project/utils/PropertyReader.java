package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static FileInputStream inputStream;
	public static Properties prop;

	public static String getProperty(String propertyName) throws IOException {
		
		inputStream = new FileInputStream(new File(System.getProperty("user.dir")+"/src/com/project/config/config.properties"));
		prop = new Properties();
		prop.load(inputStream);
		
		String propertyValue= prop.getProperty(propertyName);
		
		return propertyValue;
	} 

}
