package CodeWars;

import java.util.*;

public class CodeWars_ConsecutiveStrings {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/56a5d994ac971f1ac500003e
//        You are given an array(list) strarr of strings and an integer k.
//        Your task is to return the first longest string consisting of k consecutive strings taken in the array.
//        Examples:
//        strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2
//
//        Concatenate the consecutive strings of strarr by 2, we get:
//
//        treefoling   (length 10)  concatenation of strarr[0] and strarr[1]
//        folingtrashy ("      12)  concatenation of strarr[1] and strarr[2]
//        trashyblue   ("      10)  concatenation of strarr[2] and strarr[3]
//        blueabcdef   ("      10)  concatenation of strarr[3] and strarr[4]
//        abcdefuvwxyz ("      12)  concatenation of strarr[4] and strarr[5]
//
//                                        Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
//        The first that came is "folingtrashy" so
//        longest_consec(strarr, 2) should return "folingtrashy".
//
//        In the same way:
//        longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
        String[] arr = {"tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"};
        int k = 2;
        System.out.println(longestConsec(arr,k));
    }
    public static String longestConsec(String[] strarr, int k) {

        ArrayList<String> stringheConcatenate = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strarr.length - 1; i++) {
            ArrayList<String> stringheTemp = new ArrayList<>();
            stringheTemp.add(strarr[i]);
            for (int j = i + 1; j < strarr.length; j++) {
                if (stringheTemp.size() == k) {
                    break;
                }
                stringheTemp.add(strarr[j]);
            }
            for (String s : stringheTemp) {
                sb.append(s);
            }
            stringheConcatenate.add(sb.toString());
            sb = new StringBuilder();
        }
        System.out.println(stringheConcatenate);

        return null;



    }
}
