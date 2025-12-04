package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day4 {
    static int[][] direzioniDaCercare = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\d4.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        char[][] matrice = new char[righe.size()][righe.getFirst().length()];
        for (int i = 0; i < righe.size(); i++) {
            matrice[i] = righe.get(i).toCharArray();
        }

        System.out.println("Risultato Parte 1: " + calcolaParte1(matrice));
       // System.out.println("Risultato Parte 2: " + calcolaParte2(matrice));
        System.out.println("Rimozioni: " + calcolaParte2Grafica(matrice));
    }

    public static int calcolaParte1(char[][] matrice) {
        int totale = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == '@' && isRimovibile(i, j, matrice)) totale++;
            }
        }
        return totale;
    }

    public static int calcolaParte2(char[][] matrice) {
        int totale = 0;
        boolean flag = true;
        while (flag) {
            List<String> coordinateRimovibili = new ArrayList<>();
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (matrice[i][j] == '@' && isRimovibile(i, j, matrice)) {
                        coordinateRimovibili.add(i + "," + j);
                    }
                }
            }
            if (coordinateRimovibili.isEmpty()) {
                flag = false;
            } else {
                totale += coordinateRimovibili.size();
                rimuovi(coordinateRimovibili, matrice);
            }
        }
        return totale;
    }

    public static boolean isRimovibile(int i, int j, char[][] matrice) {
        int numeroAdiacenti = 0;
        for (int[] direzione : direzioniDaCercare) {

            int x = direzione[0] + i;
            int y = direzione[1] + j;

            if (x >= 0 && x < matrice.length && y >= 0 && y < matrice[0].length) {
                if (matrice[x][y] == '@') {
                    numeroAdiacenti++;
                    if (numeroAdiacenti == 4) break;
                }

            }
        }
        return numeroAdiacenti <= 3;
    }

    public static void rimuovi(List<String> coordinateRimovibili, char[][] matrice) {
        for (String cords : coordinateRimovibili) {
            String[] split = cords.split(",");
            int x = Integer.parseInt(split[0]), y = Integer.parseInt(split[1]);
            matrice[x][y] = '.';
        }
    }


    // grafica

    public static int calcolaParte2Grafica(char[][] matrice) {
        int totale = 0, passo = 0;
        boolean flag = true;
        while (flag) {
            List<String> coordinateRimovibili = new ArrayList<>();
            debug(matrice, passo, coordinateRimovibili);
            passo++;
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (matrice[i][j] == '@' && isRimovibile(i, j, matrice)) {
                        coordinateRimovibili.add(i + "," + j);
                    }
                }
            }
            if (coordinateRimovibili.isEmpty()) {
                flag = false;
            } else {
                debug(matrice, passo, coordinateRimovibili);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                totale += coordinateRimovibili.size();
                rimuovi(coordinateRimovibili, matrice);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return totale;

    }

    public static void debug(char[][] matrice, int passo, List<String> coordinateRimovibili) {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
        System.out.println("Iterazione: " + passo);
        final String ROSSO = "\u001B[31m";
        final String VERDE = "\u001B[32m";
        final String RESET = "\u001B[0m";
        final String BLU = "\u001B[34m";
        int righe = matrice.length;
        int colonne = matrice[0].length;

        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                char elemento = matrice[i][j];
                String coloreElemento = "";
                if (elemento == '@') {
                    if (coordinateRimovibili.contains(i + "," + j)) {
                        coloreElemento = ROSSO;
                    } else {
                        coloreElemento = VERDE;
                    }

                } else if (elemento == '.') {
                    coloreElemento = BLU;
                } else {
                    coloreElemento = RESET;
                }

                System.out.print(coloreElemento + elemento + RESET + " ");
            }
            System.out.println();
        }
        if (!coordinateRimovibili.isEmpty()) {
            System.out.println("Rimozioni in questo ciclo: " + coordinateRimovibili.size());
        } else {
            System.out.println();
        }
    }

}



