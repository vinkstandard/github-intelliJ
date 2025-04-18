package CodeWars._5kyu;

public class CodeWars_TicTacToeChecker {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/525caa5c1bf619d28c000335/train/java
//        If we were to set up a Tic-Tac-Toe game, we would want to know whether the board's current state is solved, wouldn't we?
//        Our goal is to create a function that will check that for us!
//
//        Assume that the board comes in the form of a 3x3 array,
//        where the value is 0 if a spot is empty
//        1 if it is an "X",
//        or 2 if it is an "O", like so:
//
//        [[0, 0, 1],
//         [0, 1, 2],
//         [2, 1, 0]]
//        We want our function to return:
//
//        -1 if the board is not yet finished AND no one has won yet (there are empty spots),
//        1 if "X" won,
//        2 if "O" won,
//        0 if it's a cat's game (i.e. a draw).


//       int[][] board = {{1, 1, 1}, {0, 2, 2}, {0, 0, 0}}; // vince la x = return 1, vittoria orizzontale
        int[][] board = {{1, 1, 2} // x vittoria verticale
                        ,{2, 1, 2},
                         {0, 1, 0}};
//       int[][] board = {{1, 1, 2},{0, 2, 0}, {2, 1, 1}}; // vince 0 = return 2
//       int[][] board = {{1, 2, 1}, {1, 1, 2}, {2, 1, 2}}; // parità = return 0
//        int[][] board ={{0, 0, 1}, {0, 1, 2}, {2, 1, 0}}; // non finito = return -1

        System.out.println("RISULTATO: " + isSolved(board));
    }
    public static int isSolved(int[][] board) {

        // check per vittoria orizzontale
        int vincitoreOrizzontale = controlloOrizzontale(board);
        if (vincitoreOrizzontale != 10) {
            if (vincitoreOrizzontale == 1) return 1;
            if (vincitoreOrizzontale == 2) return 2;
        }
        // check per vittoria verticale
        int vincitoreVerticale = controlloVerticale(board);
        if (vincitoreVerticale != 10) {
            if (vincitoreVerticale == 1) return 1;
            if (vincitoreVerticale == 2) return 2;
        }
        // check diagonale (sinistra a destra)
        int num = board[0][0];
        if (num != 0) {
            if (board[1][1] == num && board[2][2] == num) {
                return num;
            }
        }
        // check diagonale (destra a sinistra)
        num = board[0][2];
        if (num != 0) {
            if (board[1][1] == num && board[2][0] == num) {
                return num;
            }
        }
        if (controlloZeri(board)) { // se è ancora giocabile
            return -1;
        }
        return 0; // parità
    }

    public static boolean controlloZeri(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int controlloOrizzontale(int[][] board) {
        boolean vittoriaOrizzontale = false;
        for (int i = 0; i < board.length; i++) {
            int startNum = board[i][0];
            if (startNum == 0) continue;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != startNum) {
                    vittoriaOrizzontale = false;
                    break;
                } else {
                    vittoriaOrizzontale = true;
                }
            }
            if (vittoriaOrizzontale) return startNum;
        }
        return 10;
    }

    public static int controlloVerticale(int[][] board) {
        for (int orizzontale = 0; orizzontale < 3; orizzontale++) {
            boolean vittoriaVerticale = true;
            int startNum = board[0][orizzontale];
            if (startNum == 0) continue;
            for (int verticale = 0; verticale < 3; verticale++) {
                if (board[verticale][orizzontale] != startNum) {
                    vittoriaVerticale = false;
                    break;
                }
            }
            if (vittoriaVerticale) return startNum;
        }
        return 10;
    }
}
