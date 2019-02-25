package com.ionut.Curs3;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")

public class MyLoginHandler implements HttpHandler {

	public void handle(HttpExchange t) throws IOException {
		//set the response as a string containing html code
		String response2 = "<html><body><form action=\"/verify\">\r\n" + 
				"  Username:<br>\r\n"+
				"  <input type=\"text\" name=\"username\" value=\"\"><br><br>\r\n "+
				//"  Password:<br>\r\n"+
				//"  <input type=\"text\" name=\"password\" value=\"\"><br><br>\r\n "+

				"  <input type=\"submit\" value=\"Submit\">\r\n" + 
				"</form></body></html>";
		
		//set headers and status code
		t.sendResponseHeaders(200, response2.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response2.getBytes());
		//close request
		os.close();	

}
}
