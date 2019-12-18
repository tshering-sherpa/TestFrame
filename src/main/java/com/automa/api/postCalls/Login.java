package com.automa.api.postCalls;

import static io.restassured.RestAssured.given;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.automa.configurations.Reusable;
import com.automa.configurations.TestConfigs;
import com.automa.entity.User;
import com.automa.factory.PathFactory;
import com.automa.factory.PayLoadFactory;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Login {
	
	Reusable r = new Reusable();
	User data;
	Response loginRes;
	Properties p1 = new Properties();

	Login() throws Exception {

		p1 = TestConfigs.getEnvironmentProperties();
	}
	
	private static Logger l1 = LogManager.getLogger(Login.class.getName());

	@Test
	public void loginAction() {
		l1.info("Calling Login method");
		RestAssured.baseURI = p1.getProperty("BASEURI");
		Response loginRes = given().header("Content-Type", "application/json").header("Accept", "application/json")
				.body(PayLoadFactory.loginData()).when()
				.post(PathFactory.login()).then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and(). // validating
				extract().response();
		l1.info("Login Response generated");
		// and().body("results.data.jwt_token","").and().body("device_id","").and().body("device_type","");
		// //validating the response body for object value
		// j.get("results.data.jwt_token")
		JsonPath j = Reusable.RawToJson(loginRes);
		if (loginRes.getStatusCode() == 431) {
			data.setDeviceType(j.getString("results.data.device_type"));
			data.setDeviceId(j.getString("results.data.device_id"));
			data.setJwtToken(j.getString("results.data.jwt_token"));
			data.setUserId(j.getString("results.data.user_id"));
			l1.info("User is logged in another device");
		} else if (loginRes.getStatusCode() == 200) {
			data.setToken(j.getString("results.token"));
			l1.info("User successfully logged in");
		} else if (loginRes.getStatusCode() == 401) {
			l1.error("Invalid Credentials");
		} else if (loginRes.getStatusCode() == 403) {
			l1.error("Inactive user");
		} else if (loginRes.getStatusCode() == 412) {
			l1.error("Validation error");
		} else if (loginRes.getStatusCode() == 500) {
			l1.error("Internal Server error");
		} else {
			l1.error("Unknown error on QuoteUp login attempt. Getting Error code" + loginRes.getStatusCode());
		}
	}
	
	

}
