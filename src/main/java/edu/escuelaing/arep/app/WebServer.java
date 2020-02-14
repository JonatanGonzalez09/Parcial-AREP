package edu.escuelaing.arep.app;

import java.util.ArrayList;

import static spark.Spark.port;
import static spark.Spark.get;

import spark.Request;
import spark.Response;



public class WebServer {
    static ArrayList < Float > lista = new ArrayList < Float > ();
    static App app = new App();
    static MergeSort mS = new MergeSort();

    public static void main(String[] args){
        WebServer ws = new WebServer();
    }

    public WebServer() {
        System.out.println("Iniciando Server...");
        port(getPort());
        get("/numbers", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent =
            "<!DOCTYPE html>" +
            "<html>" +
            "<body>" +
            "<h3>Ingrese los números de la lista separados por espacios:  </h3>" +
            "<form action=\"/results\">" +
            "  <input type=\"text\" name=\"num\" value=\"\">" +
            "  <br>" +
            "  <br> <br>" +
            "  <input type=\"submit\" value=\"Enviar\">" +
            "</form>" +
            "<p>Al hacer click en el botón \"Enviar\",sus datos serán procesados y será redirigido a la página \"/results\".</p>" +
            "</body>" +
            "</html>";
        return pageContent;
    }

    private static String resultsPage(Request req, Response res) {
        String[] arre = req.queryParams("num").split("\\s+");
        float[] arreF = new float[arre.length];
        for (int a = 0; a < arre.length; a++) {
            lista.add(Float.parseFloat(arre[a]));
            arreF[a] = Float.parseFloat(arre[a]);
        }

        mS.sort(arreF, 0, arreF.length-1);

        String result = "{\"lista recibida: \":" + "\"" + lista + "\"" 
                        + ",\"La suma es: \":" + "\"" + app.getSum(lista) + "\"" 
                        + ",\"La lista ordenada es: \":" + "\""+ app.listaOrdenada(arreF)+"}";
        return result;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }

}