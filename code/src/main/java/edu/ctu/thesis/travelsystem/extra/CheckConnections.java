package edu.ctu.thesis.travelsystem.extra;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CheckConnections {
	public static boolean checkConnect(String address) {
		boolean result = false;
		try {
			URL url = new URL(address);
			try {
				URLConnection conn = url.openConnection();
				conn.connect();
				return true;
			} catch (IOException e) {
				result = false;
			}
		} catch (MalformedURLException e) {
			result = false;
		}
		
		return result;
	}
}
