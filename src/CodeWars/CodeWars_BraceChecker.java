package CodeWars;
import java.util.*;
public class CodeWars_BraceChecker {
    public boolean isValid(String braces) {
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


