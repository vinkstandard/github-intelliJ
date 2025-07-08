package LeetCode;


import java.util.HashMap;

public class Leet_CheckIfEveryRawAndColumnContainsAllNumbers {
    public static void main(String[] args) {

//        An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).
//        Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

//        Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
//        Output: true
//        Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
//        Hence, we return true.
//
//        Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
//        Output: false
//        Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
//        Hence, we return false.

        System.out.println(checkValid(new int[][]{{1, 2, 3}, {3, 1, 2}, {2, 3, 1}}));
        System.out.println(checkValid(new int[][]{{1, 1, 1}, {1, 2, 3}, {1, 2, 3}}));
    }

    public static boolean checkValid(int[][] matrix) {

        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> riga = new HashMap<>();
            HashMap<Integer, Integer> colonna = new HashMap<>();

            for (int j = 0; j < n; j++) {
                int valRiga = matrix[i][j];
                int valColonna = matrix[j][i];

                // controllo se uno dei valori è fuori dal range
                if (valRiga < 1 || valRiga > n || valColonna < 1 || valColonna > n) return false;

                // controllo se ci sono duplicati alla riga
                if (riga.containsKey(valRiga)) return false;
                //altrimenti aggiungo alla mappa
                riga.put(valRiga, 1);

                // faccio lo stesso con la colonna
                if (colonna.containsKey(valColonna)) return false;
                colonna.put(valColonna, 1);
            }
        }

        return true;
    }
}
