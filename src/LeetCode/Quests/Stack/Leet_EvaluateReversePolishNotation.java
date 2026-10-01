package LeetCode.Quests.Stack;

import java.util.Stack;

public class Leet_EvaluateReversePolishNotation {
    public static void main(String[] args) {

        // https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=problem-list-v2&envId=dsa-linear-shoal-stack
        // https://en.wikipedia.org/wiki/Reverse_Polish_notation

        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}) + " | Expected: " + 9);
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}) + " | Expected: " + 6);
    }
    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(Character.isDigit(token.charAt(token.length() - 1))){
                stack.push(Integer.parseInt(token));
            } else {
                int num = 0;
                int n2 = stack.pop(), n1 = stack.pop();
                switch(token){
                    case "+" -> num = (n1 + n2);
                    case "-" -> num = (n1 - n2);
                    case "/" -> num = (n1 / n2);
                    case "*" -> num = (n1 * n2);
                }
                stack.push(num);
            }
        }
        return stack.pop();
    }
}