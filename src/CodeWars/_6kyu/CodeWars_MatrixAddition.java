package CodeWars._6kyu;

import java.util.Arrays;

public class CodeWars_MatrixAddition {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/526233aefd4764272800036f/train/java
//
//        Write a function that accepts two square matrices (N x N two dimensional arrays), and return the sum of the two.
//        Both matrices being passed into the function will be of size N x N (square), containing only integers.
//
//        How to sum two matrices:
//        Take each cell [n][m] from the first matrix, and add it with the same [n][m] cell from the second matrix.
//        This will be cell [n][m] of the solution matrix. (Except for C where solution matrix will be a 1d pseudo-multidimensional array).
//
//        Visualization:
//
//        |1 2 3|     |2 2 1|     |1+2 2+2 3+1|     |3 4 4|
//        |3 2 1|  +  |3 2 3|  =  |3+3 2+2 1+3|  =  |6 4 4|
//        |1 1 1|     |1 1 3|     |1+1 1+1 1+3|     |2 2 4|

        int[][] a = {
                {1, 2, 3},
                {3, 2, 1},
                {1, 1, 1}
        };
        int[][] b = {
                {2, 2, 1},
                {3, 2, 3},
                {1, 1, 3}
        };
        int[][] risultatoPrevisto = {
                {3, 4, 4},
                {6, 4, 4},
                {2, 2, 4}
        };
        System.out.println(Arrays.deepToString(matrixAddition(a, b)) + " Previsto:\n" + Arrays.deepToString(risultatoPrevisto));
    }

    public static int[][] matrixAddition(int[][] a, int[][] b) {

        int[][] nuovaMatrice = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                nuovaMatrice[i][j] = a[i][j] + b[i][j];
            }
        }
        return nuovaMatrice;
    }
}
