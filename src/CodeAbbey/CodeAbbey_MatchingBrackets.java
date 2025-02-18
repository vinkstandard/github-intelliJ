package CodeAbbey;
import java.util.Stack;
import java.util.Scanner;
public class CodeAbbey_MatchingBrackets {
    public static void main(String[] args) {
//        We are given strings containing brackets of 4 types - round (), square [], curly {} and angle <> ones. The goal is to check, whether brackets are in correct sequence.
//        I.e. any opening bracket should have closing bracket of the same type somewhere further by the string, and bracket pairs should not overlap, though they could be nested:
//
//        (a+[b*c] - {d/3})  - here square and curly brackets are nested in the round ones
//        (a+[b*c) - 17]     - here square brackets overlap with round ones which does not make sense
//        Input data will contain number of testcases in the first line.
//        Then specified number of lines will follow each containing a test-case in form of a character sequence.
//        Answer should contain 1 (if bracket order is correct) or 0 (if incorrect) for each of test-cases, separated by spaces.
//
//        Example:
//        input data:
//        4
//        (a+[b*c]-{d/3})
//        (a + [b * c) - 17]
//        (((a * x) + [b] * y) + c
//        auf(zlo)men [cho<psy>] four{s}
//
//        answer:
//        1 0 0 1
//        Note that all non-bracket characters could be safely ignored!

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String regex = "[^()\\[\\]{}]";
        int[] risultati = new int[n];
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            s = s.replaceAll(regex, "");
            risultati[i] = controllaParentesi(s) ? 1 : 0;
        }
        for (int r : risultati) {
            System.out.print(r + " ");
        }
    }

    public static boolean controllaParentesi(String s) {
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
