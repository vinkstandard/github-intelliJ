package LeetCode.MinStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        List<Integer> lista = new ArrayList<>(stack);
        return Collections.min(lista);
    }
    public void stampaStack(){
        System.out.println(stack);
    }
}
