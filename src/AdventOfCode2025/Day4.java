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

        debug(matrice);

        System.out.println("Risultato Parte 1: " + calcolaParte1(matrice));
        System.out.println("Risultato Parte 2: " + calcolaParte2(matrice));
    }

    public static int calcolaParte1(char[][] matrice) {
        int totale = 0;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if(matrice[i][j] == '@' && isRimovibile(i, j, matrice)) totale++;
            }
        }
        return totale;
    }
    public static int calcolaParte2(char[][] matrice) {
        int totale = 0;
        boolean flag = true;
        while(flag) {
            List<String> coordinateRimuovibili = new ArrayList<>();
            for (int i = 0; i < matrice.length; i++) {
                for (int j = 0; j < matrice[0].length; j++) {
                    if (matrice[i][j] == '@' && isRimovibile(i, j, matrice)) {
                        coordinateRimuovibili.add(i + "," + j);
                    }
                }
            }
            if(coordinateRimuovibili.isEmpty()) flag = false;
        }
        return totale;

    }
    public static boolean isRimovibile(int i, int j, char[][] matrice){
        int numeroAdiacenti = 0;
        for (int[] direzione : direzioniDaCercare) {

            int x = direzione[0] + i;
            int y = direzione[1] + j;

            if (x >= 0 && x < matrice.length && y >= 0 && y < matrice[0].length) {
                if (matrice[x][y] == '@') {
                    numeroAdiacenti++;
                    if (numeroAdiacenti == 4 ) break;
                }

            }
        }
        return numeroAdiacenti <= 3;
    }
    public static void debug(char[][] matrice){
        System.out.println("-------------------");
        for (char[] chars : matrice) {
            for (int j = 0; j < matrice[0].length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");

    }
}



