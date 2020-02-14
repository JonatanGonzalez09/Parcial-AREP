package edu.escuelaing.arep.app;

import java.util.ArrayList;


public class App {
    MergeSort mS = new MergeSort();
    public int getSum(ArrayList<Float> lista){
        int suma = 0;
		for (int i = 0; i < lista.size(); i++){
			suma+= lista.get(i);
		}
        return suma;
    }

    public ArrayList<Float> listaOrdenada(float arreF[]){
        mS.sort(arreF, 0, arreF.length-1);
        ArrayList<Float> arr = new ArrayList<Float>();
        int n = arreF.length; 
        for (int i=0; i<n; ++i) 
            arr.add(arreF[i]);
        return arr;
        
    } 


}
