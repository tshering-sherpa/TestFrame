package com.automa.factory;

public class PathFactory {

	public static String login() {
		String path = "/auth/login";
		return path;
	}

	public static String logout() {
		String path = "/auth/logout?device_id={device_id} ";
		return path;
	}

	public static String logoutOthers() {
		String path = "/auth/logoutFromOtherDevice";
		return path;
	}

	public static String CreateQuote() {
		String path = "/quote/add";
		return path;
	}

	public static String GetNotifications() {
		String path = "/notification/listNotification/?page={page}";
		return path;
	}

	public static String getMarkupvalues() {
		String path = "/profile/getSettingValues";
		return path;
	}

	public static String listQuote() {
		String path = "/quote/listQuote?type={type}&orderby={orderby}&order={order}&page={page}&search={search}&search_all={search_all}\r\n";
		return path;
	}
	
}
