package com.ionut.Curs3;

import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")

public class MyHtmlHandler implements HttpHandler {

	public void handle(HttpExchange t) throws IOException {
		//set the response as a string containing html code
		String response = "<html><body><form action=\"/form\">\r\n" + 
				"  First name:<br>\r\n" + 
				"  <input type=\"text\" name=\"firstname\" value=\"\"><br>\r\n" + 
				"  Last name:<br>\r\n" + 
				"  <input type=\"text\" name=\"lastname\" value=\"\"><br><br>\r\n "+
				"  Username:<br>\r\n"+
				"  <input type=\"text\" name=\"username\" value=\"\"><br><br>\r\n "+
				"  Password:<br>\r\n"+
				"  <input type=\"text\" name=\"password\" value=\"\"><br><br>\r\n "+
			    "  <input type=\"radio\" name=\"gender\" value=\"male\" checked> Male<br>\r\n" + 
				"  <input type=\"radio\" name=\"gender\" value=\"female\"> Female<br>\r\n" + 
				"  <input type=\"radio\" name=\"gender\" value=\"other\"> Other<br>\r\n" + 
				"  <input type=\"submit\" value=\"Submit\">\r\n" + 
				"</form></body></html>";
		
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();	
	}
	

}