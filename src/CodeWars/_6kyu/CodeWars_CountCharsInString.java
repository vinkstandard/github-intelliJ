package CodeWars._6kyu;

import java.util.HashMap;
import java.util.Map;

public class CodeWars_CountCharsInString {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/52efefcbcdf57161d4000091/train/java
//        The main idea is to count all the occurring characters in a string.
//        If you have a string like aba, then the result should be {'a': 2, 'b': 1}.
//
//        What if the string is empty? Then the result should be empty object literal, {}.
        String str = "aba";
        System.out.println(count(str));
    }
    public static Map<Character, Integer> count(String str) {
        if(str.isEmpty()){
            return new HashMap<>();
        }
        HashMap<Character, Integer> mappa = new HashMap<>();
        char[] chars = str.toCharArray();
        for(char c : chars) {
            if(mappa.containsKey(c)){
                mappa.put(c, mappa.get(c) + 1);
            }
            mappa.putIfAbsent(c, 1);
        }
        return mappa;
    }
}
