package CodeWars._6kyu;
import java.util.*;

public class CodeWars_DuplicateEncoder {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/54b42f9314d9229fd6000d9c
//        The goal of this exercise is to convert a string to a new string where each character in the new string is
//        "(" if that character appears only once in the original string, or ")" if that character appears more than once in the original string.
//        Ignore capitalization when determining if a character is a duplicate.
//
//        Examples
//        "din"      =>  "((("
//        "recede"   =>  "()()()"
//        "Success"  =>  ")())())"
//        "(( @"     =>  "))(("

//        Notes:
//        Assertion messages may be unclear about what they display in some languages.
//        If you read "...It Should encode XXX", the "XXX" is the expected result, not the input!

        String word = "Success";
        System.out.println(encode(word));


    }
    static String encode(String word) {

        ArrayList<Character> caratteriUsciti = new ArrayList<>();
        ArrayList<Character> piuDiuno = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (caratteriUsciti.contains(c) && !piuDiuno.contains(c)) {
                piuDiuno.add(c);
            }
            if (!caratteriUsciti.contains(c)) {
                caratteriUsciti.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = Character.toLowerCase(word.charAt(i));
            if (piuDiuno.contains(c)) {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }
        return sb.toString();
    }
}
