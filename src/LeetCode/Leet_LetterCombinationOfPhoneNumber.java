package LeetCode;
import java.util.*;

public class Leet_LetterCombinationOfPhoneNumber {
    static Map<Integer, List<Character>> mappa = Map.of(
            2, List.of('a', 'b', 'c'),
            3, List.of('d', 'e', 'f'),
            4, List.of('g', 'h', 'i'),
            5, List.of('j', 'k', 'l'),
            6, List.of('m', 'n', 'o'),
            7, List.of('p', 'q', 'r', 's'),
            8, List.of('t', 'u', 'v'),
            9, List.of('w', 'x', 'y', 'z')
    );

    public static void main(String[] args) {

//        https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
//        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//        Return the answer in any order.
//
//        A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//        Example 1:
//
//        Input: digits = "23"
//        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//        Example 2:
//
//        Input: digits = "2"
//        Output: ["a","b","c"]
//
//        Constraints:
//        1 <= digits.length <= 4
//        digits[i] is a digit in the range ['2', '9'].

        System.out.println(letterCombinations("23"));
    }
    public static List<String> letterCombinations(String digits) {

        return null;
    }
}
