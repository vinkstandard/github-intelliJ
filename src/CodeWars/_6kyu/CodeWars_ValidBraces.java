package CodeWars._6kyu;
import java.util.*;
public class CodeWars_ValidBraces {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5277c8a221e209d3f6000b56
//        Write a function that takes a string of braces, and determines if the order of the braces is valid.
//        It should return true if the string is valid, and false if it's invalid.
//        This Kata is similar to the Valid Parentheses Kata, but introduces new characters:
//        brackets [], and curly braces {}. Thanks to @arnedag for the idea!
//        All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.
//
//        What is considered Valid?
//        A string of braces is considered valid if all braces are matched with the correct brace.
//
//        Examples
//        "(){}[]"   =>  True
//        "([{}])"   =>  True
//        "(}"       =>  False
//        "[(])"     =>  False
//        "[({})](]" =>  False
        String braces = "(){}[]";
        System.out.println(isValid(braces));
    }
    public static  boolean isValid(String braces) {
        String regex = "[^()\\[\\]{}]";
        braces = braces.replaceAll(regex, "");
        return verificaParentesi(braces);
    }

    public static boolean verificaParentesi(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


