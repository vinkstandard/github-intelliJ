package CodeWars;

import java.util.*;


public class CodeWars_NextSmallerNumberWithTheSameDigits {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5659c6d896bc135c4c00021e/train/java
//        Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.
//        For example:
//        nextSmaller(21) == 12
//        nextSmaller(531) == 513
//        nextSmaller(2071) == 2017
//        Return -1 (for Haskell: return Nothing, for Rust: return None), when there is no smaller number that contains the same digits.
//        Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.
//        nextSmaller(9) == -1
//        nextSmaller(111) == -1
//        nextSmaller(135) == -1
//        nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
//        some tests will include very large numbers.
//        test data only employs positive integers.
//        The function you write for this challenge is the inverse of this kata: "Next bigger number with the same digits."

        long n = 202233445566L;
        System.out.println(nextSmaller(n));


    }
    public static long nextSmaller(long n) {

        String num = String.valueOf(n);
        List<String> permutazioni = new ArrayList<>();
        generaPermutazioni(num, "", permutazioni);

        ArrayList<Long> combinazioni = new ArrayList<>();
        // aggiungo tutte le combinazioni in un array, rimuovendo però quelle che iniziano con 0
        for(String s : permutazioni){
            if(s.startsWith("0")){
                continue;
            }
            combinazioni.add(Long.parseLong(s));
        }
        // e lo ordino in ordine crescente
        Collections.sort(combinazioni);

        int indiceInizio = combinazioni.indexOf(n);
         // se n è in prima posizione, allora non ci sono numeri più bassi di lui
        if(indiceInizio == 0){
            return -1;
        }else{
            return combinazioni.get(indiceInizio - 1);
        }

    }
    public static void generaPermutazioni(String s, String prefisso, List<String> risultato) {
        if (s.isEmpty()) {
            risultato.add(prefisso);
        } else {
            for (int i = 0; i < s.length(); i++) {
                generaPermutazioni(s.substring(0, i) + s.substring(i + 1),
                        prefisso + s.charAt(i), risultato);
            }
        }
    }

}
