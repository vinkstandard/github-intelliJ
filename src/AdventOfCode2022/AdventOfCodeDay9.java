package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay9 {
    static char[][] matrice = new char[11][11];

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day9.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        for (char[] riga : matrice) {
            Arrays.fill(riga, '.');
        }

        System.out.println("Risultato Test: " + calcolaTestParte1(righe));
    }

    //    If the head is ever two steps directly up, down, left, or right from the tail, the tail must also move one step in that direction so it remains close enough:
//    Otherwise, if the head and tail aren't touching and aren't in the same row or column, the tail always moves one step diagonally to keep up:
//    You just need to work out where the tail goes as the head follows a series of motions. Assume the head and the tail both start at the same position, overlapping.
    public static int calcolaTestParte1(List<String> righe) {

        // il test non specifica quanto serve grande la griglia, quindi iniziamo a far funzionare il testcase, se funziona questo, alziamo il limite a 100x100, se non va alziamo ancora di più, gaming


        matrice[matrice.length / 2][matrice.length / 2] = 'H';

        boolean primoMov = true;
        int[] posizioneCoda = new int[2];
        for (String comando : righe) {
            String direzione = comando.split(" ")[0], nPassi = comando.split(" ")[1];
            System.out.println("(" + direzione + ")  (" + nPassi + ")");
            for (int i = 0; i < Integer.parseInt(nPassi); i++) {
                debug();
                muoviTesta(direzione);
                int[] posizioneTesta = trovaTesta();

                if (primoMov) { // valido solo all'inizio
                    matrice[matrice.length / 2][matrice.length / 2] = 'T';
                    posizioneCoda = trovaCoda();
                    primoMov = false;
                    continue;
                }
                if(posizioneCoda != null && !isVicinoTesta(posizioneCoda)) {
                    if (trovaCoda() == null) {
                        // questo check serve a far riapparire la coda nella sua ultima posizione nota
                        matrice[posizioneCoda[0]][posizioneCoda[1]] = 'T';
                    }
                    muoviCoda(posizioneTesta, posizioneCoda);
                }

            }


        }




        return 0;
    }

    public static void muoviTesta(String direzione) {
        int y = trovaTesta()[0], x = trovaTesta()[1];
        System.out.println("TESTA in movimento a [" + direzione + "] di 1");
        switch (direzione) {
            case "R":
                matrice[y][x + 1] = 'H';
                matrice[y][x] = '.';
                break;
            case "L":
                matrice[y][x - 1] = 'H';
                matrice[y][x] = '.';
                break;
            case "U":
                matrice[y - 1][x] = 'H';
                matrice[y][x] = '.';
                break;
            case "D":
                matrice[y + 1][x] = 'H';
                matrice[y][x] = '.';
                break;
        }

    }
    public static void muoviCoda(int[] posizioneTesta, int[] posizioneCoda){
        System.out.println("la coda si trova in posizione " + posizioneCoda[0] + "-" + posizioneCoda[1]);
    }
    public static boolean isVicinoTesta(int[] posizioneCoda){ // top nome
        int[][] direzioniDaCercare = new int[][]{{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
        for(int[] dir : direzioniDaCercare){
            int y = dir[0] + posizioneCoda[0], x = dir[1] + posizioneCoda[1];
            if(y >= 0 && y < matrice.length && x >= 0 && x < matrice[0].length){
                if(matrice[y][x] == 'H') return true;
            }
        }
        return false;
    }

    public static int[] trovaTesta() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == 'H') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] trovaCoda() {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == 'T') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void debug() {

        final String BLU = "\u001B[0;94m";
        final String RESET = "\u001B[0m";
        System.out.println("-------------------------------");
        for (char[] chars : matrice) {
            System.out.print("\t");
            for (char c : chars) {
                String colore;
                colore = (c == 'T' || c == 'H') ? BLU : "";
                System.out.print(colore + c + RESET + " ");
            }
            System.out.println();
        }
    }
}
