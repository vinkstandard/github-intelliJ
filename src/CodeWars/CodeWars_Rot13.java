package CodeWars;
import java.util.*;

public class CodeWars_Rot13 {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/530e15517bc88ac656000716
//        ROT13 is a simple letter substitution cipher that replaces a letter with the letter 13 letters after it in the alphabet. ROT13 is an example of the Caesar cipher.
//
//        Create a function that takes a string and returns the string ciphered with Rot13.
//        If there are numbers or special characters included in the string,
//        they should be returned as they are. Only letters from the latin/english alphabet should be shifted,
//        like in the original Rot13 "implementation".
//
//        "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"

        String s = "W3 ar3 in ye@r 2023$$$!äöü";
        System.out.println(rot13(s));
    }
    public static String rot13(String str) {

        ArrayList<Character> alfabeto = new ArrayList<>();
        ArrayList<Character> rot13 = new ArrayList<>();
        for(char c = 'A'; c <= 'Z'; c++){
            alfabeto.add(c);                             // alfabeto normale
        }
        for(int i = 13; i < alfabeto.size(); i++){       // inizio l'alfabeto rot
            rot13.add(alfabeto.get(i));
        }
        for(char c = 'A'; c < 'N'; c++){                 // aggiungo le ultime lettere
            rot13.add(c);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (rot13.contains(Character.toUpperCase(c))) {
                if(Character.isUpperCase(c)){
                    sb.append(rot13.get(alfabeto.indexOf(Character.toUpperCase(c))));
                }else{
                    sb.append(Character.toLowerCase(rot13.get(alfabeto.indexOf(Character.toUpperCase(c)))));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}


