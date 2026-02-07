package LeetCode;

import java.util.Stack;

public class Leet_ValidParentheses {
    public static void main(String[] args) {

        System.out.println(isValid("()") + " Expected --> " + true);
        System.out.println(isValid("()[]{}") + " Expected --> " + true);
        System.out.println(isValid("([)]") + " Expected --> " + false);
        System.out.println(isValid("(]") + " Expected --> " + false);
    }
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char sopra = stack.pop();
                if ((c == ')' && sopra != '(') ||
                        (c == ']' && sopra != '[') ||
                        (c == '}' && sopra != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
