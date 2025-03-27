package CodeWars._6kyu;

import java.util.*;


public class CodeWars_PlayingWithDigits {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5552101f47fc5178b1000050
//        Some numbers have funny properties. For example:
//        89 --> 8¹ + 9² = 89 * 1
//        695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
//        46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51
//        Given two positive integers n and p, we want to find a positive integer k, if it exists,
//        such that the sum of the digits of n raised to consecutive powers starting from p is equal to k * n.

        int n = 695;
        int p = 2;
        System.out.println(digPow(n,p));


    }
    public static long digPow(int n, int p) {

        String[]potenzeStringa = String.valueOf(n).split("");
        ArrayList<Integer> potenze = new ArrayList<>();

        int conto = 0;
        for (int i = p; i < potenzeStringa.length + p; i++) {
            potenze.add((int) Math.pow(Integer.parseInt(potenzeStringa[conto++]), i));
        }
        int numeroFinale = 0;
        for (int num : potenze) {
            numeroFinale += num;
        }
//        debug
//        System.out.println(Arrays.toString(potenzeStringa));
//        System.out.println(potenze);
//        System.out.println(numeroFinale);
        for (int i = 1; i < 10000000; i++) {
            if (n * i == numeroFinale) {
                return i;
            }
        }
        return -1;
    }
}
