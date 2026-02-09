package LeetCode.MinStack;

public class Tester {
    public static void main(String[] args) {


        MinStack minStack = new MinStack();
        minStack.push(22);
        minStack.push(44);
        minStack.stampaStack();

        System.out.println("top: [" + minStack.top() + "]");

        System.out.println("min: [" + minStack.getMin() + "]");


        System.out.println("poppato: [" + minStack.top() + "]");
        minStack.pop();

        minStack.stampaStack();



        /*
         * Your MinStack object will be instantiated and called as such:
         * MinStack obj = new MinStack();
         * obj.push(val);
         * obj.pop();
         * int param_3 = obj.top();
         * int param_4 = obj.getMin();
         */
    }
}
