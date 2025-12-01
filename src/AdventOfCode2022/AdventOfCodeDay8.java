package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay8 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day8completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        // creazione e popolamento matrice
        int[][] matrice = new int[righe.size()][righe.getFirst().length()];
        for (int i = 0; i < righe.size(); i++) {
            String[] split = righe.get(i).split("");
            for (int j = 0; j < split.length; j++) {
                matrice[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[][] direzioniDaCercare = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        debug(matrice);
        System.out.println("Risultato parte 1: " + calcolaParte1(matrice, direzioniDaCercare));

    }

    public static int calcolaParte1(int[][] matrice, int[][] direzioniDaCercare) {
        int totale = (matrice.length * 2) + ((matrice[0].length - 2) * 2); // inizializziamo il totale aggiungendo i bordi
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (i == 0 || j == 0 || i == matrice.length - 1 || j == matrice[0].length - 1) continue; // se siamo ai bordi saltiamo

                cercando:
                for (int[] posizione : direzioniDaCercare) {
                    boolean buono = true;
                    int x = posizione[0] + i, y = posizione[1] + j;
                    int numeroAttuale = matrice[i][j];

                    while (y >= 0 && y < matrice.length && x >= 0 && x < matrice[0].length) {
                        if (matrice[x][y] >= numeroAttuale) {
                            buono = false;
                            break;
                        }
                        x = posizione[0] + x;
                        y = posizione[1] + y;
                    }
                    if (buono) {
                        totale += 1;
                        break cercando;
                    }
                }
            }
        }
        return totale;
    }

    public static void debug(int[][] matrice) {
        System.out.println("-----------------");
        for (int i = 0; i < matrice.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(matrice[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
