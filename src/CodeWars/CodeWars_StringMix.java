package CodeWars;

import java.util.HashMap;

public class CodeWars_StringMix {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5629db57620258aa9d000014
//        The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum,
//        if this maximum is strictly greater than 1;
//        these letters will be prefixed by the number of the string where they appear with their maximum value and :.
//        If the maximum is in s1 as well as in s2 the prefix is =:.

//        s1 = "my&friend&Paul has heavy hats! &"
//        s2 = "my friend John has many many friends &"
//        mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
//
//        s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
//        s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
//        mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
//
//        s1="Are the kids at home? aaaaa fffff"
//        s2="Yes they are here! aaaaa fffff"
//        mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"

        String s1 = "my&friend&Paul has heavy hats! &";
        String s2 = "my friend John has many many friends &";
        System.out.println(mix(s1,s2));
    }
    public static String mix(String s1, String s2) {
        HashMap<Character,Integer> conto1 = new HashMap<>();
        HashMap<Character,Integer> conto2 = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++){
            conto1.put(c,0);
            conto2.put(c,0);
        }
        System.out.println(conto1);
        System.out.println(conto2);
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        for(char c : s1Array){
            if(conto1.containsKey(c)){
                conto1.put(c,conto1.get(c) + 1);
            }
        }
        for(char c : s2Array){
            if(conto2.containsKey(c)){
                conto2.put(c,conto2.get(c) + 1);
            }
        }
        System.out.println("\n"+conto1);
        System.out.println(conto2);

        // valori inseriti nelle rispettive mappe
        StringBuilder sb = new StringBuilder();








        return null;
    }

}
