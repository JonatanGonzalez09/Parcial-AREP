package edu.escuelaing.arep.app;

import static spark.Spark.*;

import java.util.ArrayList;

import com.google.gson.Gson;

import spark.QueryParamsMap;


public class WebServer {

    public static void main(String[] args) {
        App app = new App();
        port(getPort());
        staticFiles.location("/public");

        post("/listaOrdenada",(req, res) -> {
            ArrayList <Float> lista = new ArrayList < Float > ();
            QueryParamsMap map = req.queryMap();
            String[] nums = req.queryParams("numbers").split("\n");
            float[] arreF = new float[nums.length];
            for (int a = 0; a < nums.length; a++) {
                lista.add(Float.parseFloat(nums[a]));
                arreF[a] = Float.parseFloat(nums[a]);
            }
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(app.listaOrdenada(arreF).toString())));
        });

        

        get("/sumatoria",(req, res) -> {
            ArrayList <Float> lista = new ArrayList < Float > ();
            QueryParamsMap map = req.queryMap();
            String[] nums = map.get("numbers").value().split("\n"); 
            for (int a = 0; a < nums.length; a++) {
                lista.add(Float.parseFloat(nums[a]));
            }
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, new Gson().toJsonTree(app.getSum(lista))));
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; 
    }
}