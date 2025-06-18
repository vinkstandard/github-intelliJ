package CodeWars._7kyu;

import java.util.*;

public class CodeWars_ShortestWord {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9
//        Simple, given a string of words, return the length of the shortest word(s).
//
//        String will never be empty and you do not need to account for different data types.
        System.out.println(findShort("bitcoin take over the world maybe who knows perhaps"));
    }
    public static int findShort(String s) {

        ArrayList<String> lista = new ArrayList<>(List.of(s.split(" ")));
        int lunghezza = Integer.MAX_VALUE;
        System.out.println(lunghezza);
        for(String elemento : lista){
            if(elemento.length() < lunghezza){
                lunghezza = elemento.length();
            }
        }
        return lunghezza;
    }
}
