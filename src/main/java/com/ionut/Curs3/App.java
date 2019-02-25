package com.ionut.Curs3;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

import com.sun.net.httpserver.HttpServer;
@SuppressWarnings("restriction")

public class App 
{
	public static Map<String,String> db;
    public static void main( String[] args ) throws IOException
    {	
		//create webserver service
		HttpServer server = HttpServer.create(new InetSocketAddress(8002),0);
		//set handler to specified path
		server.createContext("/", new MyArrayHandler());
		server.createContext("/html", new MyHtmlHandler());
		server.createContext("/scanner", new MyScannerHandler());
		server.createContext("/form", new MyFormHandler());
		server.createContext("/login", new MyLoginHandler());
		server.createContext("/verify", new MyLoginHandler());
		//creates a default executor
		server.setExecutor(null);
		//start the server
		server.start();
        System.out.println( "Server Started on port 8002" );
    }
}
