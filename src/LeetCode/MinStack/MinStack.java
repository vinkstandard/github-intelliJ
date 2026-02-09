package LeetCode.MinStack;

import java.util.ArrayList;
import java.util.Collections;


class MinStack {

    private ArrayList<Integer> lista = new ArrayList<>();

    public MinStack() {
    }

    public void push(int val) {
        lista.add(val);
    }

    public void pop() {
        lista.removeLast();
    }

    public int top() {
        return lista.getLast();
    }

    public int getMin() {
        return Collections.min(lista);
    }
    public void stampaDebug(){
        System.out.println(lista);
    }
}
