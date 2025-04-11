package CodeWars._3kyu;

import java.util.Arrays;
import java.util.TreeMap;

public class CodeWars_HowManyAreSmallerThanMe_II {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/56a1c63f3bc6827e13000006/train/java
//        This is a hard version of How many are smaller than me?. If you have troubles solving this one, have a look at the easier kata first.
//        Write:
//        function smaller(arr)
//        that given an array arr, you have to return the amount of numbers that are smaller than arr[i] to the right.
//
//       For example:
//        smaller([5, 4, 3, 2, 1]) === [4, 3, 2, 1, 0]
//        smaller([1, 2, 0]) === [1, 1, 0]

//         non funziona, troppo lento, passo gli small e medium case, ma fallisco nei large. per ora dumpo.
        System.out.println("CASO 1:" + Arrays.toString(smaller(new int[]{5, 4, 3, 2, 1})));
        System.out.println("CASO 2:" + Arrays.toString(smaller(new int[]{1, 2 ,0})));
    }

    public static int[] smaller(int[] unsorted) {

        int[] risultato = new int[unsorted.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = unsorted.length - 1; i >= 0; i--) {
            int conto = 0;
            // prendo tutti i valori minori di arr[i]
            for (int valore : map.headMap(unsorted[i], false).values()) {
                conto += valore;
            }
            risultato[i] = conto;
            // inserisco il valore attuale
            map.put(unsorted[i], map.getOrDefault(unsorted[i], 0) + 1);
        }
        return risultato;
    }
}
