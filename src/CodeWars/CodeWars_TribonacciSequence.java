package CodeWars;

import java.util.*;

public class CodeWars_TribonacciSequence {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/556deca17c58da83c00002db
//        But what if we started with [0, 0, 1] as a signature? As starting with [0, 1] instead of [1, 1] basically shifts the common Fibonacci
//        sequence by once place, you may be tempted to think that we would get the same sequence shifted by 2 places,
//        but that is not the case and we would get:
//        [0, 0, 1, 1, 2, 4, 7, 13, 24, ...]

        int n = 31;
        double[] s = {18.0, 11.0, 12.0};
        System.out.println(Arrays.toString(tribonacci(s, n)));
    }
    public static double[] tribonacci(double[] s, int n) {

//        se n == 0, allora restituisco un array vuoto
        if (n == 0) {
            return new double[0];
        }
        ArrayList<Double> listaTribonacci = new ArrayList<>(Arrays.stream(s).boxed().toList()); // converto l'array in arraylist
        if (n <= 2) {
//            se n == 2 rimuovo un numero dalla lista e poi la restituisco
            if (n == 2) {
                listaTribonacci.remove(listaTribonacci.size() - 1);
                return listaTribonacci.stream().mapToDouble(Double::doubleValue).toArray();}

//            altrimenti vuol dire che n == 1 allora rimuovo 2 elementi alla fine, poi restituisco
            else {
                listaTribonacci.remove(listaTribonacci.size() - 1);
                listaTribonacci.remove(listaTribonacci.size() - 1);
                return listaTribonacci.stream().mapToDouble(Double::doubleValue).toArray();
            }
        }
//        se n >= 3 allora genero la sequenza fino ad ottenere una sequenza grande quanto n, e poi la restituisco
        while (listaTribonacci.size() < n) {
            listaTribonacci.add(listaTribonacci.get(listaTribonacci.size() - 1) + listaTribonacci.get(listaTribonacci.size() - 2) + listaTribonacci.get(listaTribonacci.size() - 3));
        }
        return listaTribonacci.stream().mapToDouble(Double::doubleValue).toArray(); // converto l'arraylist in array prima di restituire
    }
}