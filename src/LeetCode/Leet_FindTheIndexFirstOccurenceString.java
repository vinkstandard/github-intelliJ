package LeetCode;

public class Leet_FindTheIndexFirstOccurenceString {
    public static void main(String[] args) {
//    https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
//    Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//    Example 1:
//    Input: haystack = "sadbutsad", needle = "sad"
//    Output: 0
//    Explanation: "sad" occurs at index 0 and 6.
//    The first occurrence is at index 0, so we return 0.
//
//    Example 2:
//    Input: haystack = "leetcode", needle = "leeto"
//    Output: -1
//    Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//    Constraints:
//    1 <= haystack.length, needle.length <= 104
//    haystack and needle consist of only lowercase English characters

        System.out.println(strStr("sadbbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
    }

    public static int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;
        int lunghezzaNeedle = needle.length();
        for (int i = 0; i < haystack.length(); i++) {
            if (lunghezzaNeedle + i <= haystack.length()) {
                String stringa = haystack.substring(i, lunghezzaNeedle + i);
                if (stringa.equals(needle)) {
                    if (i == 0) return 0;
                    return i - 1;
                }
            }
        }
        return -1;
    }
}
