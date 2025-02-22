package AdventOfCode2024;

import java.io.*;
import java.util.*;

public class adventOfCodeDay6 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno6input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (!st.isEmpty()) {
                righe.add(st);
            }
        }
        int lunghezzaRigo = righe.size(), lunghezzaStringa = righe.getFirst().length();
        char[][] mappa = new char[lunghezzaRigo][lunghezzaStringa];
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                mappa[i][j] = righe.get(i).charAt(j);
            }
        }
        // prima stampa
        stampaMappa(mappa, lunghezzaRigo, lunghezzaStringa);
        // inizio movimenti
        char c = '^';
        while (inGioco(mappa, lunghezzaRigo, lunghezzaStringa)) {
            if (c == '^') {
                movimentoSu(mappa, lunghezzaRigo, lunghezzaStringa);
            }
            if (c == 'v') {
                movimentoGiu(mappa, lunghezzaRigo, lunghezzaStringa);
            }
            if (c == '>') {
                movimentoDestra(mappa, lunghezzaRigo, lunghezzaStringa);
            }
            if (c == '<') {
                movimentoSinistra(mappa, lunghezzaRigo, lunghezzaStringa);
            }
            c = rotazione(mappa, lunghezzaRigo, lunghezzaStringa);
            stampaMappa(mappa, lunghezzaRigo, lunghezzaStringa); // stampa aggiunta per visualizzazione debug
        }

        int totaleParte1 = calcoloParte1(mappa, lunghezzaRigo, lunghezzaStringa);
        System.out.println("Totale parte 1: " + totaleParte1);
//        int totaleParte2 = calcoloParte2();
//        System.out.println("Totale parte 2: " + totaleParte2);

    }

    public static void stampaMappa(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                System.out.print(mappa[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] posizioneAttuale(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int vert = 0, oriz = 0;
        ricerca:
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                switch (mappa[i][j]) {
                    case '<':
                    case '>':
                    case '^':
                    case 'v':
                        vert = i;
                        oriz = j;
                        break ricerca;
                }
            }
        }
        int[] posizioni = new int[2];
        posizioni[0] = vert;   // la i
        posizioni[1] = oriz;   // la j
        return posizioni;
    }

    public static boolean inGioco(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        boolean trovato = false;
        ricerca:
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                if (mappa[i][j] == '<' || mappa[i][j] == '>' || mappa[i][j] == '^' || mappa[i][j] == 'v') {
                    trovato = true;
                    break ricerca;
                }
            }
        }
        return trovato;
    }

    public static char rotazione(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        char status = ' ';
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                if (mappa[i][j] == '<') {
                    status = '^';
                    break;
                } else if (mappa[i][j] == '>') {
                    status = 'v';
                    break;
                } else if (mappa[i][j] == '^') {
                    status = '>';
                    break;
                } else if (mappa[i][j] == 'v') {
                    status = '<';
                    break;
                }
            }
        }
        return status;
    }

    // movimenti
    public static void movimentoSu(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int[] posizioneAttuale = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);

        for (int i = posizioneAttuale[0]; i >= 0; i--) {
            if (i == 0) {
                mappa[i][posizioneAttuale[1]] = 'X'; // se abbiamo vinto (ergo ci troviamo all'indice 0 della i
                break;
            }
            if (mappa[i - 1][posizioneAttuale[1]] == '#') { // se troviamo un muro
                break;
            } else {
                mappa[i - 1][posizioneAttuale[1]] = '^';  // camminiamo
                mappa[i][posizioneAttuale[1]] = 'X';    // e lasciamo le x dietro
            }
        }
    }

    public static void movimentoGiu(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int[] posizioneAttuale = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);

        for (int i = posizioneAttuale[0]; i < lunghezzaRigo; i++) {
            if (i == lunghezzaRigo - 1) {
                mappa[i][posizioneAttuale[1]] = 'X'; // se abbiamo vinto(ergo ci troviamo all'indice lunghezzaRigo-1 della i)
                break;
            }
            if (mappa[i + 1][posizioneAttuale[1]] == '#') { // se troviamo un muro
                break;
            } else {
                mappa[i + 1][posizioneAttuale[1]] = 'v';  // camminiamo
                mappa[i][posizioneAttuale[1]] = 'X';    // e lasciamo le x dietro
            }
        }
    }

    public static void movimentoDestra(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int[] posizioneAttuale = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);

        for (int j = posizioneAttuale[1]; j < lunghezzaStringa; j++) {
            if (j == lunghezzaStringa - 1) {
                mappa[posizioneAttuale[0]][j] = 'X'; // se abbiamo vinto(ergo ci troviamo all'indice lunghezzaStringa-1 della j
                break;
            }
            if (mappa[posizioneAttuale[0]][j + 1] == '#') { // se troviamo un muro
                break;
            } else {
                mappa[posizioneAttuale[0]][j + 1] = '>';     // camminiamo
                mappa[posizioneAttuale[0]][j] = 'X';         // e lasciamo le x dietro
            }
        }
    }

    public static void movimentoSinistra(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int[] posizioneAttuale = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);

        for (int j = posizioneAttuale[1]; j >= 0; j--) {
            if (j == 0) {
                mappa[posizioneAttuale[0]][j] = 'X';   // se abbiamo vinto(ergo ci troviamo all'indice 0 di j
                break;
            }
            if (mappa[posizioneAttuale[0]][j - 1] == '#') { // se troviamo un muro
                break;
            } else {
                mappa[posizioneAttuale[0]][j - 1] = '<';    // camminiamo
                mappa[posizioneAttuale[0]][j] = 'X';       // e lasciamo le x dietro
            }
        }
    }

    public static int calcoloParte1(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int totale = 0;
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                if (mappa[i][j] == 'X') {
                    totale++;
                }
            }
        }
        return totale;
    }
}