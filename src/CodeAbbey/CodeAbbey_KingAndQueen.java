package CodeAbbey;

import java.util.*;
public class CodeAbbey_KingAndQueen {

    public static void main(String[] args) {

//        https://www.codeabbey.com/index/task_view/king-and-queen
//        Programming of game playing algorithms, like Chess, have two principal tasks:
//
//        assessing position, at least by checking which pieces could be taken;
//        constructing a kind of minimax algorithm to select a move leading to position with best value.
//        Let us start by solving a simple problem:
//
//        There is a chessboard with 8 x 8 squares. There are the White King and Black Queen on it. Check whether the Queen could take the King.
//
//        Remember - Queen could move to any distance vertically, horizontally or along any of two diagonals.
//
//        8  - Q - - - - - -     - - - - - - - -
//        7  - - - - Q - - -     - - - - - - Q -
//        6  - - - - - - - -     - - - - - - - -
//        5  - - - - - - - -     - - - Q - - - -
//        4  - K - - - - Q -     - - Q - - - - -
//        3  - - - - - - - -     - - - - - - - -
//        2  - - - Q - - - -     - - - - - K - -
//        1  - - - - - - - -     - Q - - - - - -
//           a b c d e f g h     a b c d e f g h
//        See these two examples, with schematically drawn boards. On both the King is shown with letter K while marks Q shows variants of placing the Queen.
//
//        on the left scheme the King could be "eaten" by any of the four Queens;
//        on the right scheme the King is in safe position - none of the four Queens can move to take him.
//        Notice how the squares of the board are addressed. Columns (called files) are marked with latin letters from a to h, while rows
//        (called ranks) are marked with digits from 1 to 8. So the King on the left diagram sits on the b4 square - and on the right diagram on the f2. We shall use this notation.
//
//        Input data contain the number of test-cases in the first line.
//        Next lines describe placement of the King and Queen for each testcase, by specifying their squares (King's first).
//        Answer should give only letter Y or N for each of test-cases, meaning that King could be taken or not respectively. Separate letters with spaces.
//
//        Example:
//
//        input data:
//        8
//        b4 b8
//        b4 e7
//        b4 d2
//        b4 g4
//        f2 b1
//        f2 c4
//        f2 d5
//        f2 g7
//
//        answer:
//        Y Y Y Y N N N N
//        In this example the positions are taken from both of diagrams above - cases 1..4 from the left diagram and others from the right.

        String[] mosse = {
                "f8 a1", "b4 h2", "g7 f7", "c8 f6", "d6 b8", "g8 b1",
                "g7 a3", "a2 d3", "b1 d5", "d5 e2", "f2 e7", "c5 a7",
                "c3 g8", "d2 a5", "h7 h3", "b4 b3", "g4 c1", "d8 h8",
                "h6 a1", "e7 e3", "d7 a2", "g7 f6", "b4 d7", "h1 g5",
                "a6 b4"
        };
        List<Character> risposte = new ArrayList<>();
        for (String mossa : mosse) {
            risposte.add(risolvi(mossa));
        }
        for (char risposta : risposte) {
            System.out.print(risposta + " ");
        }

    }

    public static char risolvi(String posizioni) {

        char[][] scacchiera = new char[8][8];
        for (char[] chars : scacchiera) {
            Arrays.fill(chars, '.');
        }
        ArrayList<String> posizioniConvertite = new ArrayList<>();
        for (String posizione : posizioni.split(" ")) {
            StringBuilder sb = new StringBuilder();
            char lettera = posizione.charAt(0);
            int numero = Integer.parseInt(String.valueOf(posizione.charAt(1)));
            switch (lettera) {
                case 'a' -> sb.append("0");
                case 'b' -> sb.append("1");
                case 'c' -> sb.append("2");
                case 'd' -> sb.append("3");
                case 'e' -> sb.append("4");
                case 'f' -> sb.append("5");
                case 'g' -> sb.append("6");
                case 'h' -> sb.append("7");
            }
            sb.append(8 - numero); // basta fare 8 - numero per ottenere il numero della coordinata i dell'array
            posizioniConvertite.add(sb.toString());
        }
        int[] coordinateRe = {Integer.parseInt(String.valueOf(posizioniConvertite.getFirst().charAt(1))), Integer.parseInt(String.valueOf(posizioniConvertite.getFirst().charAt(0)))};
        int[] coordinateRegina = {Integer.parseInt(String.valueOf(posizioniConvertite.getLast().charAt(1))), Integer.parseInt(String.valueOf(posizioniConvertite.getLast().charAt(0)))};
        scacchiera[coordinateRe[0]][coordinateRe[1]] = 'K';
        scacchiera[coordinateRegina[0]][coordinateRegina[1]] = 'Q';
        return (checkVittoria(scacchiera, coordinateRegina)) ? 'Y' : 'N';

    }

    public static boolean checkVittoria(char[][] scacchiera, int[] coordinateRegina) {
        int r = coordinateRegina[0];
        int c = coordinateRegina[1];
        int[][] direzioni = {
                {-1, 0}, {1, 0}, // su, giù
                {0, -1}, {0, 1}, // sinistra, destra
                {-1, -1}, {-1, 1}, // diagonale su-sx, su-dx
                {1, -1}, {1, 1} // diagonale giù-sx, giù-dx
        };

        for (int[] dir : direzioni) {
            int x = r + dir[0];
            int y = c + dir[1];

            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (scacchiera[x][y] == 'K') {
                    return true;
                }
                x += dir[0];
                y += dir[1];
            }
        }
        return false;
    }

    public static void stampaScacchieraDebug(char[][] scacchiera) {
        int numero = 8;
        for (int i = 0; i < scacchiera.length; i++) {
            System.out.print(numero-- + " ");
            for (int j = 0; j < scacchiera[i].length; j++) {
                System.out.print(scacchiera[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
}
