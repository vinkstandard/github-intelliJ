package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.Arrays;

public class CodeWars_StripComments {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/51c8e37cee245da6b40000bd/train/java
//        Complete the solution so that it strips all text that follows any of a set of comment markers passed in. Any whitespace at the end of the line should also be stripped out.
//
//        Example:
//
//        Given an input string of:
//
//        apples, pears # and bananas
//        grapes
//        bananas !apples
//
//        The output expected would be:
//        apples, pears
//        grapes
//        bananas
//        The code would be called like so:
//
//        var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
//        result should == "apples, pears\ngrapes\nbananas"

        String testo = "apples, pears # and bananas\ngrapes\nbananas !apples";
        String[] simboli = {"#", "!"};
        System.out.println(stripComments(testo, simboli));
    }

    public static String stripComments(String text, String[] commentSymbols) {

        ArrayList<String> listaCommenti = new ArrayList<>(Arrays.asList(commentSymbols));
        StringBuilder testoCompleto = new StringBuilder();

        String[] testi = text.split("\n");
        for (String testo : testi) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < testo.length(); i++) {
                char c = testo.charAt(i);
                if (listaCommenti.contains(String.valueOf(c))) {
                    break;
                } else {
                    if (i == testo.length() - 1 && c == ' ') {
                        continue;
                    }
                    sb.append(c);
                }
            }
            String riga = sb.toString().replaceAll("\\s+$", "") + "\n";
            testoCompleto.append(riga);
        }
        if (!testoCompleto.isEmpty()) {
            testoCompleto.setLength(testoCompleto.length() - 1);
        }

        return testoCompleto.toString();
    }
}


//expected:<apples, pears[
//grapes
//bananas]>
//
// but was:<apples, pears[
//grapes
//        bananas
//]>