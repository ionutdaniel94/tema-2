package com.ionut.Curs3;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")

public class MyFormHandler implements HttpHandler {
	public void handle(HttpExchange t) throws IOException {
		//declaram stringurile care vor fi luate din URL
				String parametrii = t.getRequestURI().getQuery();
				//cream un array numit parrams care contine stringuri
				ArrayList<String> params=new ArrayList<String>();
				//facem un for care trece prin toate stringurile... le imparte prin "split" in mai multe stringuri
				String response = "<html><body>";
				for(int i=0;i<parametrii.split("&").length;i++) {
					
					String setParametru=parametrii.split("&")[i];
					params.add(setParametru.split("=")[1]);
					response +="Parametrul numarul "+i+" este: "+setParametru.split("=")[1]+"<br>";
				}
					response += "</body></html>";
					t.sendResponseHeaders(200, response.length());
					OutputStream os = t.getResponseBody();
					//send response
					os.write(response.getBytes());
					//close request
					os.close();	
				
				
	
	}
}
