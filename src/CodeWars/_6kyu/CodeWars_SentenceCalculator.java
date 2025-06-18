package CodeWars._6kyu;

import java.util.HashMap;

public class CodeWars_SentenceCalculator {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5970fce80ed776b94000008b
//        Sentence Calculator
//        Calculate the total score (sum of the individual character scores) of a sentence given the following score rules
//        for each allowed group of characters:
//
//        Lower case [a-z]: 'a'=1, 'b'=2, 'c'=3, ..., 'z'=26
//        Upper case [A-Z]: 'A'=2, 'B'=4, 'C'=6, ..., 'Z'=52
//        Digits [0-9] their numeric value: '0'=0, '1'=1, '2'=2, ..., '9'=9
//        Other characters: 0 value
//        Note: input will always be a string
        System.out.println("Risultato: " + lettersToNumbers("I Love You") + " Expected (170)");
        System.out.println("Risultato: " + lettersToNumbers("ILoveYou") + " Expected (170)");
        System.out.println("Risultato: " + lettersToNumbers("ARE YOU HUNGRY?") + " Expected (356)");
        System.out.println("Risultato: " + lettersToNumbers("oops, i did it again!") + " Expected (152)");
    }

    public static int lettersToNumbers(String s) {

        HashMap<Character, Integer> mappa = new HashMap<>();
        int num = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            mappa.put(c, num++);
        }
        num = 2;
        for (char c = 'A'; c <= 'Z'; c++) {
            mappa.put(c, num);
            num += 2;
        }
        int totale = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                totale += Character.getNumericValue(s.charAt(i));
            }
            if (mappa.containsKey(s.charAt(i))) {
                totale += mappa.get(s.charAt(i));
            }
        }
        return totale;
    }
}
