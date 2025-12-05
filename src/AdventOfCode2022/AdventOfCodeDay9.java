package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay9 {
    static char[][] matrice = new char[2001][2001];
    static List<String> risultatoParte1 = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day9completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        for (char[] riga : matrice) {
            Arrays.fill(riga, '.');
        }

        calcolaTestParte1(righe);
        System.out.println("Risultato parte 1: " + risultatoParte1.size());
    }

    //    If the head is ever two steps directly up, down, left, or right from the tail, the tail must also move one step in that direction so it remains close enough:
//    Otherwise, if the head and tail aren't touching and aren't in the same row or column, the tail always moves one step diagonally to keep up:
//    You just need to work out where the tail goes as the head follows a series of motions. Assume the head and the tail both start at the same position, overlapping.
    public static void calcolaTestParte1(List<String> righe) {

        // il test non specifica quanto serve grande la griglia, quindi iniziamo a far funzionare il testcase, se funziona questo, alziamo il limite a 100x100, se non va alziamo ancora di più, gaming


        matrice[matrice.length / 2][matrice[0].length / 2] = 'H';
        System.out.println("---------------STATO INIZIALE---------------");
        debug();

        boolean primoMov = true;
        int[] posizioneCoda = new int[2];
        int[] posizioneTesta = new int[2];
        int conto = 1;
        for (String comando : righe) {
            String direzione = comando.split(" ")[0], nPassi = comando.split(" ")[1];
            System.out.println("(" + direzione + ")  (" + nPassi + ") Comando numero: " + conto++);

            for (int i = 0; i < Integer.parseInt(nPassi); i++) {
                muoviTesta(direzione);
                System.out.println("TESTA in movimento a [" + direzione + "] di 1");
                // debug();
                posizioneTesta = trovaTesta();
                if (Arrays.equals(posizioneCoda, posizioneTesta)) {
                    System.out.println("OVERLAP");
                    continue;
                }
                // coda
                if (primoMov) { // valido solo all'inizio
                    matrice[matrice.length / 2][matrice[0].length / 2] = 'T';
                    posizioneCoda = trovaCoda();
                    primoMov = false;
                    System.out.println("Inizio coda piazzato");
                    String posizioneDaSalvare = matrice.length / 2 + "-" + matrice[0].length / 2;
                    risultatoParte1.add(posizioneDaSalvare);
                    continue;
                }
                System.out.println("PosCoda: " + Arrays.toString(posizioneCoda) + "\tIsMobile: " + isCodaMobile(posizioneCoda));
                if (posizioneCoda != null && isCodaMobile(posizioneCoda)) {
                    if (trovaCoda() == null) {
                        // questo check serve a far riapparire la coda nella sua ultima posizione nota, succede solo quando la testa overlappa
                        matrice[posizioneCoda[0]][posizioneCoda[1]] = 'T';
                    }
                    muoviCoda(posizioneTesta, posizioneCoda);
                    posizioneCoda = trovaCoda();
                }

            }

        }
        // alla fine di tutto, se si è finito con un overlap come nell'esempio, controlliamo se possiamo posizionare la coda
        if (!Arrays.equals(posizioneCoda, posizioneTesta)) {
            matrice[posizioneCoda[0]][posizioneCoda[1]] = 'T';
            debug();
        }

    }

    public static void muoviTesta(String direzione) {
        int y = trovaTesta()[0], x = trovaTesta()[1];
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

    public static void muoviCoda(int[] posizioneTesta, int[] posizioneCoda) {
        int[][] diagonali = new int[][]{{-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int[][] orizzontaliVerticali = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        int codaY = posizioneCoda[0], codaX = posizioneCoda[1];
        int testaY = posizioneTesta[0], testaX = posizioneTesta[1];

        for (int[] dir : orizzontaliVerticali) {
            int y = dir[0] + posizioneCoda[0], x = dir[1] + posizioneCoda[1];
            if (y >= 0 && y < matrice.length && x >= 0 && x < matrice[0].length) {
                if (isVicinoTestaOV(new int[]{y, x})) {
                    matrice[y][x] = 'T'; // sposto la coda
                    matrice[posizioneCoda[0]][posizioneCoda[1]] = '.'; // rimuovo la coda dalla vecchia posizione
                    System.out.println("coda movimento O/V spostata in " + y + " - " + x);

                    String posizioneDaSalvare = y + "-" + x;
                    if (!risultatoParte1.contains(posizioneDaSalvare)) risultatoParte1.add(posizioneDaSalvare);
                    // debug();
                    return;
                }
            }
        }

        for (int[] dir : diagonali) {
            int y = dir[0] + posizioneCoda[0], x = dir[1] + posizioneCoda[1];
            if (y >= 0 && y < matrice.length && x >= 0 && x < matrice[0].length) {
                if (isVicinoTestaOV(new int[]{y, x})) {
                    matrice[y][x] = 'T'; // sposto la coda
                    matrice[posizioneCoda[0]][posizioneCoda[1]] = '.'; // rimuovo la coda dalla vecchia posizione
                    System.out.println("coda movimento D spostata in " + y + " - " + x);

                    String posizioneDaSalvare = y + "-" + x;
                    if (!risultatoParte1.contains(posizioneDaSalvare)) risultatoParte1.add(posizioneDaSalvare);
                    // debug();
                    return;
                }
            }
        }
        System.out.println("la coda non si è mossa");


    }

    public static boolean isVicinoTestaOV(int[] posizioneCoda) { // orizzontali verticali
        int[][] direzioniDaCercare = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : direzioniDaCercare) {
            int y = dir[0] + posizioneCoda[0], x = dir[1] + posizioneCoda[1];
            if (y >= 0 && y < matrice.length && x >= 0 && x < matrice[0].length) {
                if (matrice[y][x] == 'H') return true;
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

    public static boolean isCodaMobile(int[] posizioneCoda) {
        int[][] direzioniDaCercare = new int[][]{{-1, 1}, {-1, -1}, {1, -1}, {1, 1}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : direzioniDaCercare) {
            int y = dir[0] + posizioneCoda[0], x = dir[1] + posizioneCoda[1];
            if (y >= 0 && y < matrice.length && x >= 0 && x < matrice[0].length) {
                if (matrice[y][x] == 'H') return false;
            }
        }
        return true;
    }

    public static void debug() {

        final String BLU = "\u001B[0;94m";
        final String RESET = "\u001B[0m";
        // System.out.println("-------------------------------");
        for (char[] chars : matrice) {
            System.out.print("\t");
            for (char c : chars) {
                String colore;
                colore = (c == 'T' || c == 'H') ? BLU : "";
                System.out.print(colore + c + RESET + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------");
    }
}
