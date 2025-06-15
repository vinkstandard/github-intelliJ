package CodeWars._6kyu;

import java.util.*;

public class CodeWars_ArrhGrabScrab {
//    https://www.codewars.com/kata/52b305bec65ea40fe90007a7/train/java
//    Pirates have notorious difficulty with enunciating. They tend to blur all the letters together and scream at people.
//
//    At long last, we need a way to unscramble what these pirates are saying.
//
//    Write a function that will accept a jumble of letters as well as a dictionary, and output a list of words that the pirate might have meant.
//
//    For example:
//
//    grabscrab( "ortsp", ["sport", "parrot", "ports", "matey"] )
//    Should return ["sport", "ports"].
//
//    Return matches in the same order as in the dictionary. Return an empty array if there are no matches.

    public static void main(String[] args) {

        String s = "ortsp";
        List<String> words = Arrays.asList("sport", "parrot", "ports", "matey");
        System.out.println(grabscrab(s, words));
    }

    public static List<String> grabscrab(String s, List<String> words){

        Map<Character, Integer> mappaParolaOriginale = costruisciMappa(s);
        List<String> paroleApprovate = new ArrayList<>();

        for (String parola : words) {
            Map<Character, Integer> mappa = costruisciMappa(parola);
            if(mappa.equals(mappaParolaOriginale)){
                paroleApprovate.add(parola);
            }
        }
        return paroleApprovate;
    }

    public static Map<Character, Integer> costruisciMappa(String parola){

        Map<Character, Integer> mappa = new HashMap<>();
        for(int i = 0; i < parola.length(); i++){
            char carattere = parola.charAt(i);
            mappa.putIfAbsent(carattere, 0);
            mappa.put(carattere, mappa.get(carattere) + 1);
        }
        return mappa;
    }

}
