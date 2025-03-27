package CodeWars._6kyu;
import java.util.*;
public class CodeWars_AreWeAlternate {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/59325dc15dbb44b2440000af
//        Task: Create a function that accepts a string as an argument and validates whether the vowels
//        (a, e, i, o, u) and consonants are in alternate order.
//        Examples
//        "amazon" --> true
//        "apple" --> false
//        "banana" --> true
//        Note: Arguments consist of only lowercase letters.
        String s = "banana";
        System.out.println(isAlt(s));
    }
    public static boolean isAlt(String word) {

        ArrayList<Character> vocali = new ArrayList<>();
        vocali.add('a');vocali.add('e');vocali.add('i');vocali.add('o');vocali.add('u');
        boolean turnoVocali, turnoConsonanti;
        if (vocali.contains(word.charAt(0))) {
            turnoVocali = true;
            turnoConsonanti = false;
        } else {
            turnoConsonanti = true;
            turnoVocali = false;
        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (turnoVocali) {
                if (vocali.contains(c)) {
                    turnoConsonanti = true;
                    turnoVocali = false;
                    continue;
                } else {
                    return false;
                }
            }
            if (turnoConsonanti) {
                if (!vocali.contains(c)) {
                    turnoVocali = true;
                    turnoConsonanti = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
