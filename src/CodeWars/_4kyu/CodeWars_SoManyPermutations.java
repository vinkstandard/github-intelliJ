package CodeWars._4kyu;
import java.util.*;

public class CodeWars_SoManyPermutations {
    public static void main(String[] args) {
// https://www.codewars.com/kata/5254ca2719453dcc0b00027d/train/java
//        With input 'a': Your function should return: ['a']
//        With input 'ab': Your function should return ['ab', 'ba']
//       With input 'abc': Your function should return ['abc','acb','bac','bca','cab','cba']
//      With input 'aabb': Your function should return ['aabb', 'abab', 'abba', 'baab', 'baba', 'bbaa']
        String s = "abc";
        List<String> permutazioni = singlePermutations(s);
        System.out.println(permutazioni);
    }
    public static List<String> singlePermutations(String s) {

        List<String> perms = new ArrayList<>();
        if(s.length() == 1){
            perms.add(s);
            return perms;
        }
        List<String> risultato = new ArrayList<>();
        permuta("", s, risultato);
        return risultato;

    }
    private static void permuta(String prefisso, String resto, List<String> risultato) {
        if (resto.isEmpty()) {
            if(!risultato.contains(prefisso)) {
                risultato.add(prefisso);
            }
        } else {
            for (int i = 0; i < resto.length(); i++) {
                permuta(prefisso + resto.charAt(i), resto.substring(0, i) + resto.substring(i + 1), risultato);
            }
        }
    }
}
