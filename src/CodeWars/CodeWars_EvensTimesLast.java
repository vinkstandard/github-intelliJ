package CodeWars;

import java.util.Arrays;

public class CodeWars_EvensTimesLast {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/5a1a9e5032b8b98477000004/train/java
//        Given a sequence of integers, return the sum of all the integers that have an even index
//        (odd index in COBOL), multiplied by the integer at the last index.
//        Indices in sequence start from 0.
//        If the sequence is empty, you should return 0.

    int[] numbers = {2, 3, 4, 5};   // == 30
    System.out.println(evenLast(numbers));

    }
    public static int evenLast(int[] numbers){

        if(numbers.length == 0){
            return 0;
        }
        int somma = 0;
        for(int i = 0; i < numbers.length; i++){
            if(i % 2 == 0){
                somma+= numbers[i];
            }
        }
        return somma * numbers[numbers.length - 1];
    }
}
