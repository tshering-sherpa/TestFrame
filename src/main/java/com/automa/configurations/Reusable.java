package com.automa.configurations;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Reusable {

	// the type of our raw data is Response

	public static JsonPath RawToJson(Response res) {
		String respo = res.asString();
		JsonPath js = new JsonPath(respo);
		return js;
	}

	public static XmlPath xml(Response rep) {
		String respo = rep.asString();
		XmlPath xm = new XmlPath(respo);
		return xm;

	}
}
