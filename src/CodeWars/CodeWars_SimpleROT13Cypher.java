package CodeWars;
import java.util.*;
public class CodeWars_SimpleROT13Cypher {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5894986e2ddc8f6805000036
//        You are asked to write a simple cypher that rotates every character (in range [a-zA-Z],
//        special chars will be ignored by the cipher) by 13 chars. As an addition to the original ROT13 cipher,
//        this cypher will also cypher numerical digits ([0-9]) with 5 chars.
//        Example:
//
//        "The quick brown fox jumps over the 2 lazy dogs"
//        will be cyphered to:
//        "Gur dhvpx oebja sbk whzcf bire gur 7 ynml qbtf"
//        Your task is to write a ROT13.5 (ROT135) method that accepts a string and encrypts it.
//        Decrypting is performed by using the same method, but by passing the encrypted string again.
//        Note: when an empty string is passed, the result is also empty.
//        When passing your succesful algorithm, some random tests will also be applied. Have fun!

        String s = "Gur dhvpx oebja sbk whzcf bire gur 7 ynml qbtf";
        System.out.println(ROT135(s));
    }
    public static String ROT135(String input) {

        ArrayList<Character> alfabeto = new ArrayList<>();
        ArrayList<Character> rot13 = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alfabeto.add(c);                             // alfabeto normale
        }
        for (int i = 13; i < alfabeto.size(); i++) {       // inizio l'alfabeto rot
            rot13.add(alfabeto.get(i));
        }
        for (char c = 'A'; c < 'N'; c++) {                 // aggiungo le ultime lettere
            rot13.add(c);
        }
        StringBuilder sb = new StringBuilder();

        System.out.println(input);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                int num = Integer.parseInt(String.valueOf(c));
                if (num - 5 > -1) {
                    sb.append(num - 5);
                    continue;
                }
                if (num + 5 <= 9) {
                    sb.append(num + 5);
                    continue;
                }
            }
            if (rot13.contains(Character.toUpperCase(c))) {
                if (Character.isUpperCase(c)) {
                    sb.append(rot13.get(alfabeto.indexOf(Character.toUpperCase(c))));
                } else {
                    sb.append(Character.toLowerCase(rot13.get(alfabeto.indexOf(Character.toUpperCase(c)))));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
