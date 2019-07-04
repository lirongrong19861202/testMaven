package com.chillax.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class UtilClass {

	public static String loadPath(){
		String key = "";
		Properties properties = new Properties();
		try {
			properties = PropertiesLoaderUtils.loadAllProperties("util.properties");
			key = properties.getProperty("downLoadPath");  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return key;
	}
}
