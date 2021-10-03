package org.raghu.opensource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 
 * @author raghavendragr
 *
 */
public class RestServiceClients {
	
	/**
	 *  
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String url = scanner.next();

		//Press enter after the Entering the URL
		scanner.next();
		
		Map<String,String> requestParameter = new HashMap<>();
		int num_of_paramerter = scanner.nextInt();
		while(num_of_paramerter-- > 0) {
			String key = scanner.next();
			String value = scanner.next();
			if(key == null) {
				System.out.println("Key is null");
				return;
			}
			if(key.isEmpty()) {
				System.out.println("Key is empty");
				return;
			}
			requestParameter.put(key,value);
		}
		String requestType = scanner.next();
		String apiType = scanner.next();
		
		
		RestServiceClients  restServiceClients = new RestServiceClients();
		switch(requestType) {
			
			case "GET" : String result = restServiceClients.getRequest(url,requestType);
						 break;
		}
	}
	
	// http://localhost:8080/cities
	public String getRequest(String urlString, String requestType) {
		URL url =  null;
		HttpURLConnection connection = null;
		InputStream responseStream = null;
		InputStream errorStream = null;
		OutputStream outputStream = null;
		try {
			 url = new URL(urlString);
			 connection = (HttpURLConnection) url.openConnection();
			 connection.setInstanceFollowRedirects(false); 
			 //connection.setRequestProperty("Content-Type", "application/json");
			 connection.setRequestProperty("accept", "application/json");
			 connection.setRequestMethod(requestType);
			 connection.getOutputStream();
			 responseStream = connection.getInputStream();
			 outputStream = connection.getOutputStream();
			 if(outputStream!= null) {
				 outputStream.toString();
			 }
			 System.out.println();
			 if(responseStream == null) {
				 errorStream = connection.getErrorStream();
				 return errorStream.toString();
			 }
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseStream.toString();
	}
	
	
	
}
