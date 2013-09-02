package org.nic.xhtmlparser.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ConnectionHelper {
	
	private static final String PROXY_IP = "10.140.142.10";
	private static final String PROXY_PORT = "3128";
	
	public static final String PARSE_URL = "http://www.diabetes-typ1.net/";
	
	
	private static void setSystemProperties() {
		
		Properties systemProperties = System.getProperties();
		systemProperties.setProperty("http.proxyHost", PROXY_IP);
		systemProperties.setProperty("http.proxyPort", PROXY_PORT);	
		
	}
	
	public static HttpURLConnection getURLConnection(String theURL) {
		
		setSystemProperties();
		
		try {
			
			URL url = new URL(theURL);
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			int responceCode = con.getResponseCode();
			
			if(responceCode==HttpURLConnection.HTTP_OK)
				return con;
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("No Connection!!");
		
		return null;
		
	}
	
	
	

	
	
}
