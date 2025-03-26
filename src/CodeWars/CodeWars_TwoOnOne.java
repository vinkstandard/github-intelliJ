package CodeWars;
import java.util.*;
public class CodeWars_TwoOnOne {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5656b6906de340bd1b0000ac
//        Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted string (alphabetical ascending),
//        the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.
//        Examples:
//        a = "xyaabbbccccdefww"
//        b = "xxxxyyyyabklmopq"
//        longest(a, b) -> "abcdefklmopqwxy"
//
//        a = "abcdefghijklmnopqrstuvwxyz"
//        longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
        String a = "xyaabbbccccdefww";
        String b = "xxxxyyyyabklmopq";
        System.out.println(longest(a,b));
    }
    public static String longest (String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        StringBuilder sb = new StringBuilder();
        for(char c : chars1){
            boolean contains = sb.indexOf(String.valueOf(c)) != -1;
            if(!contains){
                sb.append(c);
            }
            for(char b : chars2){
                contains = sb.indexOf(String.valueOf(b)) != -1;
                if(!contains){
                    sb.append(b);
                }
            }
        }
        char[] good = sb.toString().toCharArray();
        Arrays.sort(good);
        return new String(good);
    }
}