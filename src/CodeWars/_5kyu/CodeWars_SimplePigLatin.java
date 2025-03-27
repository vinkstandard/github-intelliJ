package CodeWars._5kyu;
import java.util.*;

public class CodeWars_SimplePigLatin {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/520b9d2ad5c005041100000f
//        Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
//        Examples
//        pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
//        pigIt('Hello world !');     // elloHay orldway !

    }
    public static String pigIt(String str) {

        String[] parole = str.split(" ");
        StringBuilder sbb = new StringBuilder();
        for(int i = 0; i < parole.length; i++){
            if(!Character.isAlphabetic(parole[i].charAt(0))){
                sbb.append(parole[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int carattere = 0; carattere < parole[i].length(); carattere++){
                sb.append(parole[i].charAt(carattere));
                if(sb.length() == parole[i].length()){
                    char c = sb.charAt(0);
                    sb.deleteCharAt(0);
                    sb.append(c);
                    sb.append("ay");
                    sbb.append(sb).append(" ");
                }
            }
        }
        String ret = sbb.toString();
        return ret.trim();
    }
}