package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leet_LongestSubstringWORepeatingChars {
    public static void main(String[] args) {

//        Given a string s, find the length of the longest substring without duplicate characters.
//
//        Example 1:
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: s = "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: s = "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//        Constraints:
//
//        0 <= s.length <= 5 * 104
//        s consists of English letters, digits, symbols and spaces.

        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
    public static int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()) return 0;
        List<String> listaParole = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++){
                if(!sb.toString().contains(Character.toString(s.charAt(j)))){
                    sb.append(s.charAt(j));
                }else{
                    break;
                }
            }
            listaParole.add(sb.toString());
        }
        listaParole.sort(Comparator.comparingInt(String::length));
        return listaParole.getLast().length();
//        return listaParole.get(listaParole.size() - 1).length();  (su leet hanno una versione di java dove non esiste getLast())
    }

}
