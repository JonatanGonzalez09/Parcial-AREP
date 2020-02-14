package edu.escuelaing.arep.app;

import java.io.*;
import java.net.*;
public class Client {
    
    public static void main(String[] args) throws Exception {

        URL url1 = new URL("https://vast-caverns-05430.herokuapp.com/");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url1.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);            
            }   
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}