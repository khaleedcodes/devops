package com.example.comp367;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) throws Exception {
        // Create HTTP server listening on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        
        // Define a context to handle HTTP requests
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Get the current time and decide the greeting
                LocalTime currentTime = LocalTime.now();
                int hour = currentTime.getHour();
                String greeting;
                
                if (hour < 12) {
                    greeting = "Good morning, Khaleed Opeloyeru, Welcome to COMP367, have a good day";
                } else {
                    greeting = "Good afternoon, Khaleed Opeloyeru, Welcome to COMP367, how is your day going?";
                }

                // Send the response
                exchange.sendResponseHeaders(200, greeting.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(greeting.getBytes());
                os.close();
            }
        });

        // Start the server
        server.start();
        System.out.println("Server started on port 8080...");
    }
}
