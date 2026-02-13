package LeetCode;

public class Leet_ValidPalindrome {
    public static void main(String[] args) {
//        https://leetcode.com/problems/valid-palindrome/

        System.out.println(isPalindrome("A man, a plan, a canal: Panama") + " Expected --> " + true);
        System.out.println(isPalindrome("race a car") + " Expected --> " + false);
        System.out.println(isPalindrome(" ") + " Expected --> " + true);
        System.out.println(isPalindrome("0P") + " Expected --> " + false);
        System.out.println(isPalindrome("A man, a plan, a canal -- Panama") + " Expected --> " + true);
    }
    public static boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s.replaceAll("[^A-Za-z0-9]", "").toLowerCase());
        return new StringBuilder(sb).reverse().compareTo(sb) == 0;
    }

}
