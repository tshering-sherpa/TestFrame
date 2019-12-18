package com.automa.entity;

public class User {

	String email;
	String password;
	
	String userId;
	String deviceId;
	String deviceType;
	String token;
	String jwtToken;
	
	public User() {
		super();
	}
	
	public User(String email, String password, String userId, String deviceId, String deviceType, String token,
			String jwtToken) {
		super();
		this.email = email;
		this.password = password;
		this.userId = userId;
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.token = token;
		this.jwtToken = jwtToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	
	
	
	
}
