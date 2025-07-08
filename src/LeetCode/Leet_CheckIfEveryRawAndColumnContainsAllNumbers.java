package LeetCode;


import java.util.HashMap;

public class Leet_CheckIfEveryRawAndColumnContainsAllNumbers {
    public static void main(String[] args) {


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
