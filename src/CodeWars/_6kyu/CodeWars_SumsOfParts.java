package CodeWars._6kyu;

import java.util.*;
import java.util.stream.IntStream;

public class CodeWars_SumsOfParts {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5ce399e0047a45001c853c2b
//        Let us consider this example (array written in general format):
//
//        ls = [0, 1, 3, 6, 10]
//
//        Its following parts:
//
//        ls = [0, 1, 3, 6, 10]
//        ls = [1, 3, 6, 10]
//        ls = [3, 6, 10]
//        ls = [6, 10]
//        ls = [10]
//        ls = []
//        The corresponding sums are (put together in a list): [20, 20, 19, 16, 10, 0]
//
//        The function parts_sums (or its variants in other languages) will take as parameter a list ls and return a list of the sums of its parts as defined above.
//
//        Other Examples:
//        ls = [1, 2, 3, 4, 5, 6]
//        parts_sums(ls) -> [21, 20, 18, 15, 11, 6, 0]
//
//        ls = [744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358]
//        parts_sums(ls) -> [10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0]
//        Notes
//        Take a look at performance: some lists have thousands of elements.

        System.out.println(Arrays.toString(sumParts(new int[]{0, 1, 3, 6, 10})));
        System.out.println(Arrays.toString(sumParts(new int[]{1, 2, 3, 4, 5, 6})));

    }
    public static int[] sumParts(int[] ls) {

        int[] nuovoArr = new int[ls.length + 1]; // dato che vuole uno 0 alla fine
        int somma = 0;
        for (int i = ls.length - 1; i >= 0; i--) {
            somma += ls[i];
            nuovoArr[i] = somma;
        }
        return nuovoArr;
    }
}


//        due soluzioni da timeout, i'm a retard

//        ArrayList<Integer> somme = new ArrayList<>();
//        for(int i = 0; i < ls.length; i++){
//            somme.add(IntStream.of(Arrays.copyOfRange(ls, i, ls.length)).sum());
//        }
//        somme.add(0); // per qualche motivo vuole uno 0 alla fine
//        return somme.stream().mapToInt(Integer::intValue).toArray();



//        ArrayList<Integer> lista = new ArrayList<>();
//        for(int cap = 0; cap < ls.length; cap++){
//            int somma = 0;
//            for(int num = cap; num < ls.length; num++){
//                somma += ls[num];
//            }
//            lista.add(somma);
//        }
//        lista.add(0);
//        return lista.stream().mapToInt(Integer::intValue).toArray();

