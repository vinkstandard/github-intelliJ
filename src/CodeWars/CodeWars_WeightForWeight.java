package CodeWars;

import java.util.*;
import java.util.stream.Collectors;

public class CodeWars_WeightForWeight {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/55c6126177c9441a570000cc/train/java
//        My friend John and I are members of the "Fat to Fit Club (FFC)".
//        John is worried because each month a list with the weights of members is published and each month he is the last on the list which means he is the heaviest.
//
//        I am the one who establishes the list so I told him: "Don't worry any more, I will modify the order of the list".
//        It was decided to attribute a "weight" to numbers. The weight of a number will be from now on the sum of its digits.
//
//        For example 99 will have "weight" 18, 100 will have "weight" 1 so in the list 100 will come before 99.
//        Given a string with the weights of FFC members in normal order can you give this string ordered by "weights" of these numbers?
//
//        Example:
//        "56 65 74 100 99 68 86 180 90" ordered by numbers weights becomes: "100 180 90 56 65 74 68 86 99"
//
//        When two numbers have the same "weight", let us class them as if they were strings (alphabetical ordering) and not numbers:
//        180 is before 90 since, having the same "weight" (9), it comes before as a string.
//        All numbers in the list are positive numbers and the list can be empty.
//
//        Notes
//        it may happen that the input string have leading, trailing whitespaces and more than a unique whitespace between two consecutive numbers
//        "2000 10003 1234000 44444444 9999 11 11 22 123" == "11 11 2000 10003 22 123 1234000 44444444 9999"
//                        |
//                        v
//           2,   4,    10,     32,     36,  2, 2, 4, 6
        String strng = "56 65 74 100 99 68 86 180 90";
        System.out.println(orderWeight(strng));
    }
    public static String orderWeight(String strng) {

        String[] nums = strng.split(" ");
        // bella scoperta la treemap, ordina automaticamente per chiave, quindi i numeri con peso minore saranno i primi.


        TreeMap<Integer, List<String>> mappaPesi = new TreeMap<>();
        for (String num : nums) {
            int peso = getPeso(num);
            // se la chiave (peso) non esiste creiamo una nuova lista
            mappaPesi.putIfAbsent(peso, new ArrayList<>());

            // se invece esiste, aggiungiamo il numero alla lista corrispondnte al peso
            mappaPesi.get(peso).add(num);
        }
        // con numeri con lo stesso peso, seguiamo l'ordine alfabetico
        for (List<String> numList : mappaPesi.values()) {
            Collections.sort(numList);
        }
        String result = mappaPesi.values().stream().flatMap(List::stream).collect(Collectors.joining(" "));
        return result;
    }
    // metodo per convertire una sequenza di numeri Stringa nella somma dei singoli digit
   public static int getPeso(String num) {
        return num.chars().map(Character::getNumericValue).sum();
    }
}
