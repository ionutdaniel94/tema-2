package com.ionut.Curs3;
import java.util.Scanner;
import java.io.IOException;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
@SuppressWarnings("restriction")

public class MyScannerHandler implements HttpHandler {

	public void handle(HttpExchange t) throws IOException {
		Scanner bucky = new Scanner(System.in);
		System.out.println("Introdu numele tau:");
		String response = "Numele tau este "+bucky.nextLine();
		System.out.println("Numele tau este "+bucky);
		//set headers and status code
		t.sendResponseHeaders(200, response.length());
		OutputStream os = t.getResponseBody();
		//send response
		os.write(response.getBytes());
		//close request
		os.close();	
	}

}