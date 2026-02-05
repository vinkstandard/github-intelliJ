package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Leet_ValidAnagram {
    public static void main(String[] args) {

//        https://leetcode.com/problems/valid-anagram/
        System.out.println(isAnagram("anagram", "nagaram") + " Expected --> true");
        System.out.println(isAnagram("rat", "car") + " Expected --> false");
        System.out.println(isAnagram("arc", "car") + " Expected --> true");
        System.out.println(isAnagram("act", "cat") + " Expected --> true");
    }
    public static boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        popolaMappa(map1, s);
        popolaMappa(map2, t);

        return map1.equals(map2);
    }
    public static void popolaMappa(HashMap<Character, Integer> map, String s){
        for(char c : s.toCharArray()){
            map.computeIfAbsent(c, k -> 0);
            map.computeIfPresent(c, (k, v) -> v + 1);
        }
    }
}
