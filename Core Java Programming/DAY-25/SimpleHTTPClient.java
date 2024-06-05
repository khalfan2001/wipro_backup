package com.day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHTTPClient {
    public static void main(String[] args) {
        String urlStr = "https://www.example.com";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder responseContent = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();

            System.out.println("Response Body:");
            System.out.println(responseContent.toString());

            System.out.println("Response Headers:");
            connection.getHeaderFields().forEach((key, value) -> System.out.println(key + ": " + value));

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}