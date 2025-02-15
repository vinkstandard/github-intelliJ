import java.io.*;
import java.io.IOException;
import java.util.*;
public class adventOfCodeDay4 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno4input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (!st.isEmpty()) {
                righe.add(st);
            }
        }
        char[][] matrice = new char[righe.size()][righe.getFirst().length()];
        for (int i = 0; i < righe.size(); i++) {
            for (int j = 0; j < righe.getFirst().length(); j++) {
                matrice[i][j] = righe.get(i).charAt(j);
            }
        }
        // prendiamo delle values
        int lunghezzaRigo = righe.getFirst().length();
        int lunghezzaColonna = righe.size();
        int totaleParte1 = 0, totaleParte2 = 0;
        // inizio programma
        for (int i = 0; i < lunghezzaColonna; i++) {
            for (int j = 0; j < lunghezzaRigo; j++) {
                if (matrice[i][j] == 'X') {
                    totaleParte1 += controlloOrizzontale(matrice, lunghezzaRigo, i, j);
                    totaleParte1 += controlloVerticale(matrice, lunghezzaColonna, i, j);
                    totaleParte1 += controlloDiagonale(matrice, lunghezzaRigo, lunghezzaColonna, i, j);
                }
                if (matrice[i][j] == 'A') {
                    totaleParte2 += controlloParte2(matrice, lunghezzaRigo, lunghezzaColonna, i, j);
                }
            }
        }
        System.out.println("Totale parte 1: " + totaleParte1);
        System.out.println("Totale parte 2: " + totaleParte2);
    }

    public static int controlloOrizzontale(char[][] matrice, int lunghezzaRigo, int i, int j) {
        int ritorno = 0;
        if (j <= lunghezzaRigo - 4) {
            if (matrice[i][j + 1] == 'M' && matrice[i][j + 2] == 'A' && matrice[i][j + 3] == 'S') {
                ritorno++;
            }
        }
        if (j >= 3) {
            if (matrice[i][j - 1] == 'M' && matrice[i][j - 2] == 'A' && matrice[i][j - 3] == 'S') {
                ritorno++;
            }
        }
        return ritorno;
    }

    public static int controlloVerticale(char[][] matrice, int lunghezzaColonna, int i, int j) {
        int ritorno = 0;

        if (i <= lunghezzaColonna - 4) {
            if (matrice[i + 1][j] == 'M' && matrice[i + 2][j] == 'A' && matrice[i + 3][j] == 'S') {
                ritorno++;
            }
        }
        if (i >= 3) {
            if (matrice[i - 1][j] == 'M' && matrice[i - 2][j] == 'A' && matrice[i - 3][j] == 'S') {
                ritorno++;
            }
        }
        return ritorno;
    }

    public static int controlloDiagonale(char[][] matrice, int lunghezzaRigo, int lunghezzaColonna, int i, int j) {
        int ritorno = 0;

        if (i <= lunghezzaColonna - 4 && j <= lunghezzaRigo - 4) {
            if (matrice[i + 1][j + 1] == 'M' && matrice[i + 2][j + 2] == 'A' && matrice[i + 3][j + 3] == 'S') {
                ritorno++;
            }
        }
        if (i >= 3 && j >= 3) {
            if (matrice[i - 1][j - 1] == 'M' && matrice[i - 2][j - 2] == 'A' && matrice[i - 3][j - 3] == 'S') {
                ritorno++;
            }
        }
        // le montagne della follia lovecraftiane 1
        if (j <= lunghezzaRigo - 4 && i >= 3) {
            if (matrice[i - 1][j + 1] == 'M' && matrice[i - 2][j + 2] == 'A' && matrice[i - 3][j + 3] == 'S') {
                ritorno++;
            }
        }
        if (i <= lunghezzaColonna - 4 && j >= 3) {
            if (matrice[i + 1][j - 1] == 'M' && matrice[i + 2][j - 2] == 'A' && matrice[i + 3][j - 3] == 'S') {
                ritorno++;
            }
        }
        return ritorno;  // risultato da ottenere: 2562
    }

    public static int controlloParte2(char[][] matrice, int lunghezzaRigo, int lunghezzaColonna, int i, int j) {
        // caso1  caso2  caso3  caso4
        // S.S     M.M    S.M    M.S
        // .A.     .A.    .A.    .A.
        // M.M     S.S    S.M    M.S
        int ritorno = 0;

        if (i > 0 && i < lunghezzaColonna - 1 && j > 0 && j < lunghezzaRigo - 1) {
            if (matrice[i - 1][j - 1] == 'S' && matrice[i + 1][j - 1] == 'M' && matrice[i - 1][j + 1] == 'S' && matrice[i + 1][j + 1] == 'M' ||
                    matrice[i - 1][j - 1] == 'M' && matrice[i + 1][j - 1] == 'S' && matrice[i - 1][j + 1] == 'M' && matrice[i + 1][j + 1] == 'S' ||
                    matrice[i - 1][j - 1] == 'S' && matrice[i + 1][j - 1] == 'S' && matrice[i - 1][j + 1] == 'M' && matrice[i + 1][j + 1] == 'M' ||
                    matrice[i - 1][j - 1] == 'M' && matrice[i + 1][j - 1] == 'M' && matrice[i - 1][j + 1] == 'S' && matrice[i + 1][j + 1] == 'S') {
                ritorno++;
            }
        }
        return ritorno;
    }
}


