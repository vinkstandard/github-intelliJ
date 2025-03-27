package CodeWars._6kyu;
import java.util.*;

public class CodeWars_DuplicateEncoder {
    static String encode(String word) {
        //        "din"      =>  "((("
        //        "recede"   =>  "()()()"
        //        "Success"  =>  ")())())"
        //        "(( @"     =>  "))(("

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
