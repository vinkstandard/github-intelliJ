package LeetCode;

public class Leet_LongestCommonPrefix {
    public static void main(String[] args) {

//        https://leetcode.com/problems/longest-common-prefix/description/
//        Write a function to find the longest common prefix string amongst an array of strings.
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//        Input: strs = ["flower","flow","flight"]
//        Output: "fl"
//
//        Example 2:
//        Input: strs = ["dog","racecar","car"]
//        Output: ""
//        Explanation: There is no common prefix among the input strings.
//
//        Constraints:
//        1 <= strs.length <= 200
//        0 <= strs[i].length <= 200
//        strs[i] consists of only lowercase English letters if it is non-empty.

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"a", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"}));
        System.out.println(longestCommonPrefix(new String[]{"abca", "abc"}));
    }

    public static String longestCommonPrefix(String[] strs) {

    }
}
