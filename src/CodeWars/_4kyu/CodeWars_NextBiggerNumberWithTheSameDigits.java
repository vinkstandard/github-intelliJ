package CodeWars._4kyu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CodeWars_NextBiggerNumberWithTheSameDigits {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/55983863da40caa2c900004e/train/java

//        System.out.println(nextBiggerNumber(4977764433221000L));
//        System.out.println(nextBiggerNumber(271518988L));
        System.out.println(nextBiggerNumber(1466268174L));
    }

    public static long nextBiggerNumber(long n) {
        StringBuilder nuovoNum = new StringBuilder(String.valueOf(n));

        // cerco da dx un numero che ha, partendo dalla sua posizione, verso la sinistra, un numero piu piccolo di lui
        // quando lo trovo, scelgo tra tutti i numeri alla sua destra, il piu piccolo, e li swappo, poi riarrangio il tutto in ordine crescente

        int indiceSwap = Integer.MAX_VALUE;
        for (int i = nuovoNum.length() - 1; i >= 0; i--) {
            if (i - 1 < 0) return -1;
            if (Character.getNumericValue(nuovoNum.charAt(i)) > Character.getNumericValue(nuovoNum.charAt(i - 1))) {
                indiceSwap = i - 1;
                break;
            }
        }

        String[] splittato = nuovoNum.substring(indiceSwap + 1).split("");
        List<String> list = Arrays.asList(splittato);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i)) > Character.getNumericValue(nuovoNum.charAt(indiceSwap))) {
                String temp = list.get(i);
                list.set(i, String.valueOf(nuovoNum.charAt(indiceSwap)));
                nuovoNum.replace(indiceSwap, indiceSwap + 1, temp);
                break;
            }
        }
        String result = String.join("", list);
        nuovoNum.replace(indiceSwap + 1, nuovoNum.length(), "").append(result);
        return Long.parseLong(nuovoNum.toString());
    }
}
