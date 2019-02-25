package com.ionut.Curs3;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
@SuppressWarnings("restriction")

public class MyLoginHandler_verify {
	public void handle(HttpExchange t) throws IOException {
		//set the response as a string containing html code
		String parametrii2 = t.getRequestURI().getQuery();
		//cream un array numit parrams care contine stringuri
		ArrayList<String> params2=new ArrayList<String>();
		//facem un for care trece prin toate stringurile... le imparte prin "split" in mai multe stringuri
		for(int i=0;i<parametrii2.split("&").length;i++) {
			
			String setParametru2=parametrii2.split("&")[i];
			params2.add(setParametru2.split("=")[1]);
			//System.out.println("Parametrul numarul "+i+" este:"+setParametru.split("=")[1]);			
			
			if (setParametru2=="dan") {
				System.out.println("Nume de utilizator existent");
		}
		
		
		} 
		String response2 ="Nume de utilizator existent";
		//set headers and status code
		t.sendResponseHeaders(200, response2.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response2.getBytes());
		//close request
		os.close();	

}
}
