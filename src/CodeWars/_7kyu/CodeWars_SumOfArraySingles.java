package CodeWars._7kyu;

import java.util.HashMap;
import java.util.Map;

public class CodeWars_SumOfArraySingles {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/59f11118a5e129e591000134
//        In this Kata, you will be given an array of numbers in which two numbers occur once and the rest occur only twice.
//        Your task will be to return the sum of the numbers that occur only once.
//        For example, repeats([4,5,7,5,4,8]) = 15 because only the numbers 7 and 8 occur once, and their sum is 15. Every other number occurs twice.
//        More examples in the test cases.
//        Good luck!


        System.out.println(repeats(new int []{4,5,7,5,4,8}));
    }
    public static int repeats(int [] arr){
        int risultato = 0;
        HashMap<Integer,Integer> mappa = new HashMap<>();
        for(int num : arr){
            mappa.computeIfPresent(num, (k, v) -> v + 1);
            mappa.putIfAbsent(num, 1);
        }
        for(Map.Entry<Integer, Integer> map : mappa.entrySet()){
            if(map.getValue() == 1) risultato += map.getKey();
        }
        return risultato;
    }
}
