package CodeWars._6kyu;

import java.util.*;

public class CodeWars_AtomicChess {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/63deb6b0acb668000f87f01b/train/java

//        (2) Moves are denoted using the initial square and destination square, with -
//        indicating a regular move and x a capture. E.g. the Nxp capture described above is f3xe5.
//        If instead the white knight returned to its home square, that would be f3-g1.

        System.out.println("---------------------------------");
        final char[][] surroundedPieces = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'n', '.', '.', '.'},
                {'.', '.', 'N', 'r', 'q', 'k', '.', '.'},
                {'.', '.', '.', 'Q', 'n', 'b', '.', '.'},
                {'.', '.', '.', 'Q', 'b', 'N', '.', '.'},
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'K'}
        };

        final char[][] surroundedPiecesResult = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'n', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'R', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'K'}
        };

        stampa2d(surroundedPieces);
        System.out.println("---------------------------------\nOutput:");
        stampa2d(makeAtomicMove(surroundedPieces, "c5xe4"));
        System.out.println("\nPrevisto: \n");
        stampa2d(surroundedPiecesResult);
    }

    public static char[][] makeAtomicMove(final char[][] position, final String move) {

        char[][] modificato = new char[position.length][];
        for (int i = 0; i < position.length; i++) {
            modificato[i] = Arrays.copyOf(position[i], position[i].length);
        }

        String tipoMossa = "" + move.charAt(2);
        String posizioniPulite = creaListaFormattata(move, tipoMossa);
        int inizioI = Character.getNumericValue(posizioniPulite.charAt(1)), inizioJ = Character.getNumericValue(posizioniPulite.charAt(0));
        int fineI = Character.getNumericValue(posizioniPulite.charAt(3)), fineJ = Character.getNumericValue(posizioniPulite.charAt(2));

        if (tipoMossa.equals("-")) {
            char mov = modificato[inizioI][inizioJ];
            modificato[inizioI][inizioJ] = '.';
            modificato[fineI][fineJ] = mov;
        } else {
            modificato[inizioI][inizioJ] = '.';
            modificato[fineI][fineJ] = '.';
            int[][] posizioni = {{0, 1}, {0, -1}, {-1, -1}, {1, -1}, {1, 1}, {-1, 1}, {-1, 0}, {1, 0}};
            for (int[] pos : posizioni) {
                int i = pos[0] + fineI, j = pos[1] + fineJ;
                if (i < modificato.length && i >= 0 && j < modificato[0].length && j >= 0) {
                    if (modificato[i][j] != 'p' && modificato[i][j] != 'P' && modificato[i][j] != '.') {
                        modificato[i][j] = '.';
                    }
                }
            }
        }


        return modificato;
    }

    public static String creaListaFormattata(final String move, String tipoMossa) {
        StringBuilder posizioniFixate = new StringBuilder();
        for (int i = 0; i < move.length(); i++) {
            int valore = switch (move.charAt(i)) {
                case 'a', '8' -> 0;
                case 'b', '7' -> 1;
                case 'c', '6' -> 2;
                case 'd', '5' -> 3;
                case 'e', '4' -> 4;
                case 'f', '3' -> 5;
                case 'g', '2' -> 6;
                case 'h', '1' -> 7;
                default -> -1;
            };
            if (valore != -1) posizioniFixate.append(valore);
        }
        return posizioniFixate.toString();
    }

    public static void stampa2d(char[][] arr) {
        for (char[] chars : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
    }

}
