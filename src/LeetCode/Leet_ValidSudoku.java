package LeetCode;

import java.util.*;

public class Leet_ValidSudoku {
    public static void main(String[] args) {
//        https://leetcode.com/problems/valid-sudoku/
        char[][] vero = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(vero) + " Expected --> True");

        char[][] falso = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(isValidSudoku(falso) + " Expected --> False");
    }

    public static boolean isValidSudoku(char[][] board) {

        HashMap<Integer, List<Character>> mappaBox = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            Set<Character> setY = new HashSet<>();
            Set<Character> setX = new HashSet<>();

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int numeroBox = (i / 3) * 3 + (j / 3); // formula per ricavare il numero della box in cui ci troviamo

                    // controllo box
                    if (!mappaBox.containsKey(numeroBox)) {
                        ArrayList<Character> lista = new ArrayList<>();
                        lista.add(board[i][j]);
                        mappaBox.put(numeroBox, lista);
                    } else {
                        if (mappaBox.get(numeroBox).contains(board[i][j])) return false;
                        mappaBox.get(numeroBox).add(board[i][j]);
                    }
                    // controllo orizzontale
                    if (setX.contains(board[i][j])) return false;
                    setX.add(board[i][j]);
                }
                // controllo verticale
                if (setY.contains(board[j][i])) return false;
                if (board[j][i] != '.') setY.add(board[j][i]);
            }
        }
        return true;
    }

}
