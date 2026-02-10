package LeetCode;

import java.util.Stack;

public class Leet_EvaluateReversePolishNotation {
    public static void main(String[] args) {

//        https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}) + " Expected --> 9");
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}) + " Expected --> 6");
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}) + " Expected --> 22");
    }
    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String n : tokens){
            if(n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/")){
                System.out.println("Operatore: [" + n + "] stackAttuale: " + stack);

                int x = stack.pop(), y = stack.pop();
                switch (n){
                    case "+" -> stack.push(y + x);
                    case "*" -> stack.push(y * x);
                    case "/" -> stack.push(y / x);
                    case "-" -> stack.push(y - x);
                }
            } else {
                stack.push(Integer.parseInt(n));
            }
        }
        return stack.pop();
    }
}
