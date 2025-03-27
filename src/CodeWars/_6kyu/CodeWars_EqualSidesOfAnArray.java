package CodeWars._6kyu;

public class CodeWars_EqualSidesOfAnArray {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5679aa472b8f57fb8c000047/train/java
//        Let's say you are given the array {1,2,3,4,3,2,1}:
//        Your function will return the index 3, because at the 3rd position of the array, the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.
//
//        Let's look at another one.
//        You are given the array {1,100,50,-51,1,1}:
//        Your function will return the index 1, because at the 1st position of the array, the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.
//
//        Last one:
//        You are given the array {20,10,-80,10,10,15,35}
//        At index 0 the left side is {}
//        The right side is {10,-80,10,10,15,35}
//        They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
//        Index 0 is the place where the left side and right side are equal.
//
//        Note: Please remember that in most languages the index of an array starts at 0.
//
//        Input
//        An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.
//
//        Output
//        The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an index that fits these rules, then you will return -1.

        int[] arr = {1,2,3,4,3,2,1};
        System.out.println(findEvenIndex(arr));
    }

    public static int findEvenIndex(int[] arr) {
        for (int indiceAttuale = 0; indiceAttuale < arr.length; indiceAttuale++) {
            if (movimentoSinistra(arr, indiceAttuale) == movimentoDestra(arr, indiceAttuale)) {
                return indiceAttuale;
            }
        }
        // se non trova niente, restituisco -1;
        return -1;
    }

    public static int movimentoSinistra(int[] arr, int indiceAttuale) {
        int somma = 0;
        if (indiceAttuale == 0) {
            return 0;
        } else {
            for (int i = indiceAttuale - 1; i >= 0; i--) {
                somma += arr[i];
            }
        }
        return somma;
    }

    public static int movimentoDestra(int[] arr, int indiceAttuale) {
        int somma = 0;
        if (indiceAttuale == arr.length) {
            return 0;
        } else {
            for (int i = indiceAttuale + 1; i < arr.length; i++) {
                somma += arr[i];
            }
        }
        return somma;
    }
}