package LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Leet_PlusOne {
    public static void main(String[] args) {

//        https://leetcode.com/problems/plus-one/description/

        System.out.println("Risultato: " + Arrays.toString(plusOne(new int[]{1, 1, 1, 1, 1, 1})) + " Previsto: " + Arrays.toString(new int[]{1, 1, 1, 1, 1, 2}));
        System.out.println("Risultato: " + Arrays.toString(plusOne(new int[]{1, 1, 9, 9, 9, 9})) + " Previsto: " + Arrays.toString(new int[]{1, 2, 0, 0, 0, 0}));
        System.out.println("Risultato: " + Arrays.toString(plusOne(new int[]{9, 9, 9, 9, 9, 9})) + " Previsto: " + Arrays.toString(new int[]{1, 0, 0, 0, 0, 0, 0}));
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if(i == 0 && digits[i] == 9){
                digits[i] = 0;
                // non esiste addAll dato che stiamo usando l'array primitivo, quindi tocca usare le stream
                return IntStream.concat(IntStream.of(1), Arrays.stream(digits)).toArray();
            }
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            } else {
                digits[i] = 0;
            }
        }
        return digits;
    }
}
