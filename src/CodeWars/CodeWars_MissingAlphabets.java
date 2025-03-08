package CodeWars;

import java.util.*;

public class CodeWars_MissingAlphabets {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/58a664bb586e986c940001d5
//        For s='abcdefghijklmnopqrstuvwxy'  The result should be 'z'
//        For s='aabbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxyy'  The result should be 'zz'
//        For s='abbccddeeffgghhiijjkkllmmnnooppqqrrssttuuvvwwxxy'  The result should be 'ayzz'
//        For s='codewars'  The result should be 'bfghijklmnpqtuvxyz'
        String s = "codewars";
        System.out.println(find(s));

    }
    static String find(final String text) {
        HashMap<Character,Integer> mappa = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++){
            mappa.put(c,0);
        }
        for(int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if(mappa.containsKey(c)){
                mappa.put(c,mappa.get(c) + 1);
            }
        }
        int maxValue = 0;
        for(int n : mappa.values()){
            if(n > maxValue){
                maxValue = n;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++){
            int differenza = maxValue - mappa.get(c);
            if(differenza != 0){
                for(int i = 0; i < differenza; i++){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
