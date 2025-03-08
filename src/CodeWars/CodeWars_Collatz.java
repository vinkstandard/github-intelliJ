package CodeWars;

import java.util.ArrayList;

public class CodeWars_Collatz {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5286b2e162056fd0cb000c20
//        Input: 4       Output: "4->2->1"
//        Input: 3       Output: "3->10->5->16->8->4->2->1"
//                n/2, if n is even
//                3n+1, if n is odd
        int numero = 3;
        String c = collatz(numero);
        System.out.println(c);
    }
    public static String collatz(int n) {
        if(n == 1){
            return String.valueOf(n);
        }
        ArrayList<Integer> sequenza = new ArrayList<>();
        sequenza.add(n);
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                sequenza.add(n);
            } else {
                n = (n * 3) + 1;
                sequenza.add(n);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : sequenza){
            if(num != 1){
                sb.append(num).append("->");
            }
            else{
                sb.append(num);
            }
        }
        return sb.toString();
    }
}