package CodeWars._4kyu;

import java.util.ArrayList;
import java.util.List;

public class CodeWars_RangeExtraction {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/51ba717bb08c1cd60f00002f/java
//        A format for expressing an ordered list of integers is to use a comma separated list of either
//
//        1. individual integers
//        2. or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
//        The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers.
//        For example "12,13,15-17"

//        Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format
//        Example:
//        {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}
//        ==   -10--8, -6, -3-1, 3-5, 7-11, 14, 15, 17-20"
        int[] numeri = {-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20};
        System.out.println(rangeExtraction(numeri) + " RISULTATO\n-10--8, -6, -3-1, 3-5, 7-11, 14, 15, 17-20 ATTESO");
    }

    public static String rangeExtraction(int[] arr) {

        List<Integer> buffer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int numero : arr) {
            if (buffer.isEmpty()) {
                buffer.add(numero);
                continue;
            }
            int ultimoNumero = buffer.get(buffer.size() - 1);
            if (numero - ultimoNumero == 1) {
                buffer.add(numero);
                continue;
            }
            if (buffer.size() > 2) {
                sb.append(buffer.get(0)).append("-").append(ultimoNumero).append(",");
            } else if (buffer.size() == 2) {
                sb.append(buffer.get(0)).append(",").append(ultimoNumero).append(",");
            } else {
                sb.append(ultimoNumero).append(",");
            }
            buffer.clear();
            buffer.add(numero);
        }
        if (buffer.size() > 2) {
            sb.append(buffer.get(0)).append("-").append(buffer.get(buffer.size() - 1));
        } else if (buffer.size() == 2) {
            sb.append(buffer.get(0)).append(",").append(buffer.get(buffer.size() - 1));
        } else {
            sb.append(buffer.get(buffer.size() - 1));
        }
        return sb.toString();
    }
}
