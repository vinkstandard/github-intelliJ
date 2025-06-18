package CodeWars._6kyu;

import java.util.*;

public class CodeWars_IfYouCanReadThis {
    static Map<Character, String> alfabetoNato = new HashMap<>();

    static {
        alfabetoNato.put('A', "Alfa");
        alfabetoNato.put('B', "Bravo");
        alfabetoNato.put('C', "Charlie");
        alfabetoNato.put('D', "Delta");
        alfabetoNato.put('E', "Echo");
        alfabetoNato.put('F', "Foxtrot");
        alfabetoNato.put('G', "Golf");
        alfabetoNato.put('H', "Hotel");
        alfabetoNato.put('I', "India");
        alfabetoNato.put('J', "Juliett");
        alfabetoNato.put('K', "Kilo");
        alfabetoNato.put('L', "Lima");
        alfabetoNato.put('M', "Mike");
        alfabetoNato.put('N', "November");
        alfabetoNato.put('O', "Oscar");
        alfabetoNato.put('P', "Papa");
        alfabetoNato.put('Q', "Quebec");
        alfabetoNato.put('R', "Romeo");
        alfabetoNato.put('S', "Sierra");
        alfabetoNato.put('T', "Tango");
        alfabetoNato.put('U', "Uniform");
        alfabetoNato.put('V', "Victor");
        alfabetoNato.put('W', "Whiskey");
        alfabetoNato.put('X', "Xray");
        alfabetoNato.put('Y', "Yankee");
        alfabetoNato.put('Z', "Zulu");
    }

    public static void main(String[] args) {


//        https://www.codewars.com/kata/586538146b56991861000293/train/java
//        You'll have to translate a string to Pilot's alphabet (NATO phonetic alphabet). https://en.wikipedia.org/wiki/NATO_phonetic_alphabet
//
//        Input:
//        If, you can read?
//
//        Output:
//        India Foxtrot , Yankee Oscar Uniform Charlie Alfa November Romeo Echo Alfa Delta ?
//
//        Note:
//        There is a preloaded dictionary that you can use, named NATO. It uses uppercase keys, e.g. NATO['A'] is "Alfa".
//        See comments in the initial code to see how to access it in your language.
//        The set of used punctuation is ,.!?.
//        Punctuation should be kept in your return string, but spaces should not.
//        Xray should not have a dash within.
//        Every word and punctuation mark should be separated by a space ' '.
//        There should be no trailing whitespace

        System.out.println("Test 1: Risultato: (" + toNATO("  p ? u . n  c t u  , a t i o n  ! ") + ")\nTest 1:  Expected: (Papa ? Uniform . November Charlie Tango Uniform , Alfa Tango India Oscar November !)");
        System.out.println("Test 2: Risultato: (" + toNATO("go for it!") + ")\nTest 2:  Expected: (Golf Oscar Foxtrot Oscar Romeo India Tango !)");
        System.out.println("Test 3: Risultato: (" + toNATO(",u,ct") + ")\nTest 3:  Expected: (, Uniform , Charlie Tango)");
    }

    public static String toNATO(String string) {

//        su codewars invece che alfabetoNato.get() faccio Helper.NATO.get()
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char carattere = string.charAt(i);
            if (Character.isAlphabetic(carattere)) {
                sb.append(alfabetoNato.get(Character.toUpperCase(carattere))).append(" ");
            } else if (!Character.isAlphabetic(carattere) && carattere != ' ') {
                switch (carattere) {
                    case '!' -> sb.append("!").append(" ");
                    case '?' -> sb.append("?").append(" ");
                    case ',' -> sb.append(",").append(" ");
                    case '.' -> sb.append(".").append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}
