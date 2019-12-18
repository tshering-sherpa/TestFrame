package com.automa.factory;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.automa.configurations.ExcelReader;
import com.automa.entity.User;
//import com.automa.entity.User;

public class PayLoadFactory {

	static User re;
	ExcelReader rd;
	private static Logger l1 = LogManager.getLogger(PayLoadFactory.class.getName());
	
	PayLoadFactory() throws Exception {
		rd= new ExcelReader();
		excelToEntityMapper();
	}
	
	 void excelToEntityMapper() throws Exception {
		 Object[] ob= rd.readLoginData();
		 String user[]= Arrays.asList(ob).toArray(new String[1]);
				System.out.println(Arrays.toString(user));
				
	}
	
	public static String loginData() {
		String email = re.getEmail();
		String password = re.getPassword();
		String type = re.getDeviceType();
		String id = re.getDeviceId();
		String token = re.getToken();

		String b = "{\r\n" + "  \"email\": \"email\",\r\n" + "  \"password\": \"password\",\r\n"
				+ "  \"device_type\": \"type\",\r\n" + "  \"device_id\": \"id\",\r\n"
				+ "  \"device_token\": \"token\"\r\n" + "}";
		// l1.info("Inserting Payload of loginData() as | email: " + lemail + "
		// password: " + lpassword + "deviceType: " + ldeviceType + " deviceId: " +
		// ldeviceId + " token: " + ltoken);
		System.out.println("Inserting Payload of loginData() as | email: " + email + " password: " + password
				+ "deviceType: " + type + " deviceId: " + id + " token: " + token);
		return b;
	}
	
}
