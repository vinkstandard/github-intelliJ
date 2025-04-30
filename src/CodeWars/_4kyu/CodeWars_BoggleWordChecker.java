package CodeWars._4kyu;

import java.util.*;
public class CodeWars_BoggleWordChecker {

    //    https://www.codewars.com/kata/57680d0128ed87c94f000bfd/train/java
//    Write a function that determines whether a string is a valid guess in a Boggle board, as per the rules of Boggle.
//    A Boggle board is a 2D array of individual characters, e.g.:
//
//          [ ['I','L','A','W'],
//            ['B','N','G','E'],
//            ['I','U','A','O'],
//            ['A','S','R','L'] ]
//
//    Valid guesses are strings which can be formed by connecting adjacent cells (horizontally, vertically, or diagonally)
//    without re-using any previously used cells.
//
//    For example, in the above board "BINGO", "LINGO", and "ILNBIA" would all be valid guesses, while "BUNGIE", "BINS", and "SINUS" would not.
//
//    Your function should take two arguments (a 2D array and a string)
//    and return true or false depending on whether the string is found in the array as per Boggle rules.
//
//    Test cases will provide various array and string sizes (squared arrays up to 150x150 and strings up to 150 uppercase letters).
//    You do not have to check whether the string is a real word or not, only if it's a valid guess.
    private final char[][] board;
    private final String word;

    public CodeWars_BoggleWordChecker(final char[][] board, final String word) {
        this.board = board;
        this.word = word;
    }

    public boolean check() {

        int[] posizioneAttuale = new int[2]; // le coordinate x e y
        char[] lettereParola = word.toCharArray();
        for (char lettera : lettereParola) {

            // TODO: Per ogni lettera devo controllare quante volte appare, nel caso della prima lettera, se appare 10 volte devo quindi controllare
            //  se la parola può partire da quelle 10 diverse posizioni.
            //  Invece se non si parla della prima lettera, devo comunque checkare sempre attorno, se trovo la lettera che mi serve tipo 2 volte
            //  (in direzioni diverse ma adiacenti), il programma dovrà comunque percorrere quelle due vie per vedere se si può comporre la parola.
            //  Da capire.


        }


        return false;
    }

    public static void main(String[] args) {
        final char[][] board = {
                {'E', 'A', 'R', 'A'},
                {'N', 'L', 'E', 'C'},
                {'I', 'A', 'I', 'S'},
                {'B', 'Y', 'O', 'R'}
        };

        String[] toCheck = {"C", "EAR", "EARS", "BAILER", "RSCAREIOYBAILNEA", "CEREAL", "ROBES"};
        boolean[] expecteds = {true, true, false, true, true, false, false};
        stampaBoard(board);
        for (int i = 0; i < toCheck.length; i++) {
            CodeWars_BoggleWordChecker b = new CodeWars_BoggleWordChecker(deepCopy(board), toCheck[i]);
            boolean risultato = b.check();
            System.out.println("Test " + (i + 1) + ": '" + toCheck[i] + "'  RISULTATO: " + risultato + " (PREVISTO: " + expecteds[i] + ")");
        }
    }

    private static char[][] deepCopy(char[][] arr) {  // copio e incollo l'array per ogni testcase
        return Arrays.stream(arr)
                .map(row -> Arrays.copyOf(row, row.length))
                .toArray(char[][]::new);
    }

    public static void stampaBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

    //  TODO: da implementare
//    public static int trovaLettere(char[][]board, char lettera){
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[i].length; j++){
//
//            }
//        }
//    }
