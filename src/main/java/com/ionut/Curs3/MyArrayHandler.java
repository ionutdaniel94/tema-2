package com.ionut.Curs3;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")

public class MyArrayHandler implements HttpHandler {
	
	public void handle(HttpExchange t) throws IOException {
		//declaram stringurile care vor fi luate din URL
		String parametrii = t.getRequestURI().getQuery();
		//cream un array numit parrams care contine stringuri
		ArrayList<String> params=new ArrayList<String>();
		//facem un for care trece prin toate stringurile... le imparte prin "split" in mai multe stringuri
		for(int i=0;i<parametrii.split("&").length;i++) {
			
			String setParametru=parametrii.split("&")[i];
			params.add(setParametru.split("=")[1]);
			System.out.println("Parametrul numarul "+i+" este:"+setParametru.split("=")[1]);			
		}
		System.out.println(parametrii);
		//for enhaced A ... care apare doar ce e dupa = 
		for(String x:params) {
			System.out.println(x);
		}
		//for enhanced B ... care apare totul ce e intre &
		for(String a:parametrii.split("&")) {
			System.out.println(a);			
		}
		
		//set the response as a normal string
		String response = "This is the response";
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();	
	}

}
