package CodeAbbey;

import java.util.*;
public class CodeAbbey_Gameof2048 {
    public static void main(String[] args) {
//       Have you ever played 2048 Game? If no, then probably it is worth trying :)
//       Many programmers spend many hours on this (both instead of work and instead of sleep). However, though it is addictive enough it is still simple to code.
//       And now we are going to try - and try to invent solution which does not look too clumsy.
//       You will be given a 4-by-4 field randomly covered with values 2 and 4 along with the sequence of player moves, specified with letters U for "up", D for "down", L for "left" and R for "right".
//       At each move all numbers at the field start sliding in a given direction and if two "tiles" with the same values are "pressed" against each other by this move, they combine producing a single tile with the sum value.
//       Of course this frees one square of the board.
//       In case when more than 2 tiles with same numbers are so "pressing" in one line, firstly two "front" are combined, i.e. if moving "down" and we have 3 similar tiles in column, two lowest are joined.
//
//       For example:
//        initial         D            R            D
//        2 2 4 2      - - - -      - - - -      - - - -
//        4 2 2 4      2 2 4 2      - 4 4 2      - - 4 2
//        2 2 2 2      4 4 2 4      - 8 2 4      - 4 2 4
//        2 4 2 2      4 4 4 4      - - 8 8      - 8 8 8
//
//        Here three steps after initial position are shown - "down", "right" and "down". As you can see the last move joins nothing, only aligns tiles against the edge of the field.
//        Input data will contain initial setup - 4 lines of 4 values each.
//        The 5-th line will contain the sequence of moves.
//        Answer should contain the counts of tiles of each kind after these moves, in order - i.e. first the amount of 2-s, then amount of 4-s etc.
//
//        Example:
//        input data:
//        2 2 4 2
//        4 2 2 4
//        2 2 2 2
//        2 4 2 2
//        D R D L U
//        answer:
//        0 2 2 1

        int[][] campo = {
                {2, 2, 2, 2},
                {2, 2, 2, 4},
                {4, 2, 4, 2},
                {4, 2, 2, 2}};
        stampaCampo(campo);
        String movimento = "D L L U D D L U L U D";
        String[] movimenti = movimento.split(" ");
        for (String s : movimenti) {
            if (s.equals("D")) {
                campo = movimentoGiu(campo);
            }
            if (s.equals("U")) {
                campo = movimentoSu(campo);
            }
            if (s.equals("L")) {
                campo = movimentoSinistra(campo);
            }
            if (s.equals("R")) {
                campo = movimentoDestra(campo);
            }
        }
        int due = 0, quattro = 0, otto = 0, sedici = 0, trentadue = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (campo[i][j]) {
                    case 2:
                        due++;
                        break;
                    case 4:
                        quattro++;
                        break;
                    case 8:
                        otto++;
                        break;
                    case 16:
                        sedici++;
                        break;
                    case 32:
                        trentadue++;
                        break;
                }
            }
        }
        System.out.print("\n" + due + " " + quattro + " " + otto + " " + sedici + " " + trentadue);
    }

    public static void stampaCampo(int[][] campo) {
        System.out.println();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(campo[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] movimentoGiu(int[][] campo) {
        for (int col = 0; col < 4; col++) {
            int[] temp = new int[4];
            int indice = 0;

            // prendo i numeri diversi da 0
            for (int riga = 3; riga >= 0; riga--) {
                if (campo[riga][col] != 0) {
                    temp[indice++] = campo[riga][col];
                }
            }

            // sommo i numeri uguali
            for (int riga = 0; riga < indice - 1; riga++) {
                if (temp[riga] == temp[riga + 1]) {
                    temp[riga] *= 2;
                    temp[riga + 1] = 0;
                }
            }

            int[] nuovaColonna = new int[4];
            int nuovoIndice = 0;
            for (int riga = 0; riga < 4; riga++) {
                if (temp[riga] != 0) {
                    nuovaColonna[nuovoIndice++] = temp[riga];
                }
            }
            for (int riga = 0; riga < 4; riga++) {
                campo[3 - riga][col] = nuovaColonna[riga];
            }
        }
        stampaCampo(campo);
        return campo;
    }

    public static int[][] movimentoSu(int[][] campo) {
        for (int col = 0; col < 4; col++) {
            int[] temp = new int[4];
            int indice = 0;
            for (int riga = 0; riga < 4; riga++) {
                if (campo[riga][col] != 0) {
                    temp[indice++] = campo[riga][col];
                }
            }

            for (int riga = 0; riga < indice - 1; riga++) {
                if (temp[riga] == temp[riga + 1]) {
                    temp[riga] *= 2;
                    temp[riga + 1] = 0;
                }
            }

            int[] nuovaColonna = new int[4];
            int nuovoIndice = 0;
            for (int riga = 0; riga < 4; riga++) {
                if (temp[riga] != 0) {
                    nuovaColonna[nuovoIndice++] = temp[riga];
                }
            }

            for (int riga = 0; riga < 4; riga++) {
                campo[riga][col] = nuovaColonna[riga];
            }
        }
        stampaCampo(campo);
        return campo;
    }

    public static int[][] movimentoDestra(int[][] campo) {
        for (int riga = 0; riga < 4; riga++) {
            int[] temp = new int[4];
            int indice = 0;

            for (int col = 3; col >= 0; col--) {
                if (campo[riga][col] != 0) {
                    temp[indice++] = campo[riga][col];
                }
            }

            for (int col = 0; col < indice - 1; col++) {
                if (temp[col] == temp[col + 1]) {
                    temp[col] *= 2;
                    temp[col + 1] = 0;
                }
            }

            int[] nuovaRiga = new int[4];
            int nuovoIndice = 0;
            for (int col = 0; col < 4; col++) {
                if (temp[col] != 0) {
                    nuovaRiga[nuovoIndice++] = temp[col];
                }
            }

            for (int col = 0; col < 4; col++) {
                campo[riga][3 - col] = nuovaRiga[col];
            }
        }
        stampaCampo(campo);
        return campo;
    }

    public static int[][] movimentoSinistra(int[][] campo) {
        for (int riga = 0; riga < 4; riga++) {
            int[] temp = new int[4];
            int indice = 0;

            for (int col = 0; col < 4; col++) {
                if (campo[riga][col] != 0) {
                    temp[indice++] = campo[riga][col];
                }
            }

            for (int col = 0; col < indice - 1; col++) {
                if (temp[col] == temp[col + 1]) {
                    temp[col] *= 2;
                    temp[col + 1] = 0;
                }
            }

            int[] nuovaRiga = new int[4];
            int nuovoIndice = 0;
            for (int col = 0; col < 4; col++) {
                if (temp[col] != 0) {
                    nuovaRiga[nuovoIndice++] = temp[col];
                }
            }
            System.arraycopy(nuovaRiga, 0, campo[riga], 0, 4);
        }
        stampaCampo(campo);
        return campo;
    }
}
