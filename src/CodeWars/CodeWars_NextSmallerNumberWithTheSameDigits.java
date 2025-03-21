package CodeWars;

import java.util.*;

public class CodeWars_NextSmallerNumberWithTheSameDigits {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5659c6d896bc135c4c00021e/train/java
//        Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.
//        For example:
//        nextSmaller(21) == 12
//        nextSmaller(531) == 513
//        nextSmaller(2071) == 2017
//        Return -1 (for Haskell: return Nothing, for Rust: return None), when there is no smaller number that contains the same digits.
//        Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.
//        nextSmaller(9) == -1
//        nextSmaller(111) == -1
//        nextSmaller(135) == -1
//        nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
//        some tests will include very large numbers.
//        test data only employs positive integers.
//        The function you write for this challenge is the inverse of this kata: "Next bigger number with the same digits."

        long n = 223;
        System.out.println(nextSmaller(n));


    }
    public static long nextSmaller(long n) {

        String num = String.valueOf(n);
        int numeroMassimoCombinazioni = num.length();
        for(int i = num.length()-1; i > 0; i--){
            numeroMassimoCombinazioni *= i;
        }
        System.out.println(numeroMassimoCombinazioni);
        ArrayList<Long> combinazioni = new ArrayList<>();

        while(combinazioni.size() != numeroMassimoCombinazioni){

        }




        return -1;
    }

}
