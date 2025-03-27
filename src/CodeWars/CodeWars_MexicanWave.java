package CodeWars;
import java.util.*;
public class CodeWars_MexicanWave {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/train/java
//        Task
//        In this simple Kata your task is to create a function that turns a string into a Mexican Wave.
//                You will be passed a string and you must return that string in an array where an uppercase letter is a person standing up.
//                Rules
//        1.  The input string will always be lower case but maybe empty.
//
//        2.  If the character in the string is whitespace then pass over it as if it was an empty seat
//                Example
//        wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}
         String str = "hello";
         System.out.println(Arrays.toString(wave(str)));

    }
    public static String[] wave(String str) {

        String[]wave1 = new String[str.length()];
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            StringBuilder sb = new StringBuilder(str);
            if(Character.isAlphabetic(c)){
                sb.setCharAt(i,Character.toUpperCase(c));
                wave1[i] = sb.toString();
            }
            else{
                continue;
            }
        }
        ArrayList<String> wwave = new ArrayList<>(Arrays.asList(wave1));
        while(wwave.contains(null)){
            for(String s : wwave){
                if(s == null){
                    wwave.remove(s);
                    break;
                }
            }
        }
        return wwave.toArray(new String[0]);
    }
}
