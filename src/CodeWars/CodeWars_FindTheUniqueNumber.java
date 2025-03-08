package CodeWars;
import java.util.*;

public class CodeWars_FindTheUniqueNumber {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java
//        Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
//        Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
        double[] arr = {1, 1, 1, 2, 1, 1};
        System.out.println(findUniq(arr));
    }

    public static double findUniq(double arr[]) {

        HashMap<String,Integer> mappa = new HashMap<>(); // creo una mappa vuota
        for(double d : arr){ // scorro nell'array
            if(!mappa.containsKey(String.valueOf(d))){   // se non esiste una chiave
                mappa.put(String.valueOf(d),0);  // la creo e imposto il valore a 0
            }else{
                if(mappa.get(String.valueOf(d)) != 1){         // se invece esiste e il suo valore non è 1
                    mappa.put(String.valueOf(d), mappa.get(String.valueOf(d)) + 1); // aggiungo +1 al suo valore
                }
            }
        }
        int min = Collections.min(mappa.values()); // prendo il valore più basso della hashmap, che sarebbe il valore del numero unico
        for (Map.Entry<String,Integer> entry : mappa.entrySet()) { // scorro tutta l'hashmap in cerca di quel valore
            if (entry.getValue().equals(min)) {
                return Double.parseDouble(entry.getKey()); // restituisco la chiave(del valore) parsata
            }
        }
        return 0; // restituisco 0 se non ci sono valori unici
    }
}