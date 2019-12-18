package com.automa.configurations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestConfigs {

	
	private static Logger l1= LogManager.getLogger(TestConfigs.class.getName());

	
	public static Properties getEnvironmentProperties() throws IOException{
		 Properties p1= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Tshering\\TestFramework\\src\\main\\java\\resources\\env.properties");
		p1.load(fis);
		l1.info("Env.properties file loaded");
		return p1;
	
	}
	
}
