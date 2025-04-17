package CodeWars._6kyu;

import java.util.*;

public class CodeWars_MissingAlphabet {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5ad1e412cc2be1dbfb000016
//        In this Kata you have to create a function,named insertMissingLetters,that takes in a string and outputs the same string processed in a particular way.
//
//        The function should insert only after the first occurrence of each character of the input string, all the alphabet letters that:
//
//        -are NOT in the original string
//        -come after the letter of the string you are processing
//
//        Each added letter should be in uppercase, the letters of the original string will always be in lowercase.
//        Example:
//
//        input: "holly"
//        missing letters: "a,b,c,d,e,f,g,i,j,k,m,n,p,q,r,s,t,u,v,w,x,z"
//        output: "hIJKMNPQRSTUVWXZoPQRSTUVWXZlMNPQRSTUVWXZlyZ"
//
//        You don't need to validate input, the input string will always contain a certain amount of lowercase letters (min 1 / max 50).

        String input = "holly";
        System.out.println(insertMissingLetters(input));
        System.out.println("hIJKMNPQRSTUVWXZoPQRSTUVWXZlMNPQRSTUVWXZlyZ   PREVISTO");
    }

    public static String insertMissingLetters(String str) {
        StringBuilder sb = new StringBuilder();
        Character[] caratteri = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            caratteri[i] = str.charAt(i);
        }
        ArrayList<Character> caratteriStringa = new ArrayList<>(Arrays.asList(caratteri));
        ArrayList<Character> caratteriUsati = new ArrayList<>();

        for (char carattereStringa : caratteriStringa) {
            sb.append(carattereStringa);

            boolean usato = caratteriUsati.contains(carattereStringa);
            caratteriUsati.add(carattereStringa);

            if (!usato) {
                for (char c = Character.toUpperCase(carattereStringa); c <= 'Z'; c++) {
                    if (caratteriStringa.contains(Character.toLowerCase(c))) {
                        continue;
                    }
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}

//IJKMNPQRSTUVWXZ
//IJKMNPQRSTUVWXZ
// PQRSTUVWXZ
// PQRSTUVWXZ
// MNPQRSTUVWXZ