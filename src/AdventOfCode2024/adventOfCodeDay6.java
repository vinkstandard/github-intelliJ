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

        int totaleParte1 = calcoloParte1(mappa, lunghezzaRigo, lunghezzaStringa);
        System.out.println("Totale parte 1: " + totaleParte1);
        int totaleParte2 = calcoloParte2(lunghezzaRigo, lunghezzaStringa, mappa, righe);
        System.out.println("Totale parte 2: " + totaleParte2);

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

    public static void rotazione(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                if (mappa[i][j] == '<') {
                    mappa[i][j] = '^';
                    break;
                } else if (mappa[i][j] == '>') {
                    mappa[i][j] = 'v';
                    break;
                } else if (mappa[i][j] == '^') {
                    mappa[i][j] = '>';
                    break;
                } else if (mappa[i][j] == 'v') {
                    mappa[i][j] = '<';
                    break;
                }
            }
        }
    }

    public static int calcoloParte1(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
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
            rotazione(mappa, lunghezzaRigo, lunghezzaStringa);
            int[] pos = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);
            c = mappa[pos[0]][pos[1]];
//            stampaMappa(mappa, lunghezzaRigo, lunghezzaStringa); // stampa aggiunta per visualizzazione debug
        }
        int totaleX = 0;
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                if (mappa[i][j] == 'X') {
                    totaleX++;
                }
            }
        }
        return totaleX;
    }

    public static int calcoloParte2(int lunghezzaRigo, int lunghezzaStringa, char[][] mappaVecchia, ArrayList<String> righe) {

        // commento per il francis
        // utilizzando la tecnica di piazzare gli ostacli sono nelle posizioni dove la guarda passa al 100% ho comunque ottenuto 5000~ posizioni possibili
        // quindi diciamo che un metodo bruteforce che itera su tutte le posizioni(anche quelle dove non passa) non è quello adatto

        System.out.println("\n------------INIZIO PARTE 2------------"); // per debug
        ArrayList<String> posizioniOstacoli = trovaPosizioneOstacolo(mappaVecchia, lunghezzaRigo, lunghezzaStringa);
        int contoOstacolo = 0; // variabile per debuggare
        int numeroLoop = 0;


        // primo ciclo
        while (contoOstacolo < posizioniOstacoli.size() && posizioniOstacoli.get(contoOstacolo) != null) {
            char[][] mappa = mappaPulita(righe); // la mappa viene resettata ogni volta con la chiamata del metodo

            String[] ostacolo = posizioniOstacoli.get(contoOstacolo).split(","); // prendiamo la pos dell'ostacolo e splittiamo
            int i = Integer.parseInt(ostacolo[0]);
            int j = Integer.parseInt(ostacolo[1]);

            if (mappa[i][j] == '.') {                                   // per evitare di piazzare un ostacolo nella posizione della guardia
                mappa[i][j] = 'O';                                      // piazziamo l'ostacolo
                contoOstacolo++;
                System.out.println("OSTACOLO " + contoOstacolo + " PIAZZATO"); // debug
//                stampaMappa(mappa,lunghezzaRigo,lunghezzaStringa);
            } else {
                contoOstacolo++;                                         // allora ci troviamo nella posizione della guardia
                continue;                                                // quindi skippiamo l'iterazione
            }
            char c = '^';
            List<char[][]> list = new ArrayList<>();

            // secondo ciclo dentro il primo
            while (inGioco(mappa, lunghezzaRigo, lunghezzaStringa)) {
                list.add(normalizzaMappa(mappa));                       // ad ogni movimento, aggiungiamo tutta la mappa alla lista
                if (list.size() == 5) {                                 // se la lista contiene 5 elementi
                    if (Arrays.deepEquals(list.get(0), list.get(4))) {  // e il primo elemento è uguale all'ultimo, ci troviamo in un loop
                        System.out.println("loop rilevato");
                        numeroLoop++;
                        list.clear();                                   // puliamo la lista
                        break;                                          // usciamo e siamo pronti per il prossimo ostacolo
                    }
                    list.clear();                                       // altrimenti puliamo la lista dato che non siamo in un loop
                }

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
                rotazione(mappa, lunghezzaRigo, lunghezzaStringa);
                int[] pos = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);
                c = mappa[pos[0]][pos[1]];
            }
        }

        return numeroLoop;
    }

    private static char[][] normalizzaMappa(char[][] mappa) {
        char[][] copia = new char[mappa.length][mappa[0].length];
        for (int i = 0; i < mappa.length; i++) {
            for (int j = 0; j < mappa[i].length; j++) {
                if (mappa[i][j] == '^' || mappa[i][j] == 'v' || mappa[i][j] == '<' || mappa[i][j] == '>') {
                    copia[i][j] = 'X'; // rimuoviamo la guarda in modo da comparare le mappe come si deve ignorando la rotazione della guardia
                } else {
                    copia[i][j] = mappa[i][j];
                }
            }
        }
        return copia;
    }

    public static char[][] mappaPulita(ArrayList<String> righe) {
        int lunghezzaRigo = righe.size(), lunghezzaStringa = righe.getFirst().length();
        char[][] mappaClean = new char[lunghezzaRigo][lunghezzaStringa];
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                mappaClean[i][j] = righe.get(i).charAt(j);
            }
        }
        // restituisce la mappa basic senza movimenti,
        return mappaClean; // chiamata pulita perché non avrà le x e la guardia parte nella posizione di default
    }

    public static ArrayList<String> trovaPosizioneOstacolo(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        ArrayList<String> posizioniVisitatePerOstacolo = new ArrayList<>();
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                if (mappa[i][j] == 'X') {
                    posizioniVisitatePerOstacolo.add(i + "," + j);
                }
            }
        }

        return posizioniVisitatePerOstacolo;
    }

    // movimenti
    public static void movimentoSu(char[][] mappa, int lunghezzaRigo, int lunghezzaStringa) {
        int[] posizioneAttuale = posizioneAttuale(mappa, lunghezzaRigo, lunghezzaStringa);

        for (int i = posizioneAttuale[0]; i >= 0; i--) {
            if (i == 0) {
                mappa[i][posizioneAttuale[1]] = 'X'; // se abbiamo vinto (ergo ci troviamo all'indice 0 della i
                break;
            }
            if (mappa[i - 1][posizioneAttuale[1]] == '#' || mappa[i - 1][posizioneAttuale[1]] == 'O') { // se troviamo un muro
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
            if (mappa[i + 1][posizioneAttuale[1]] == '#' || mappa[i + 1][posizioneAttuale[1]] == 'O') { // se troviamo un muro
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
            if (mappa[posizioneAttuale[0]][j + 1] == '#' || mappa[posizioneAttuale[0]][j + 1] == 'O') { // se troviamo un muro
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
            if (mappa[posizioneAttuale[0]][j - 1] == '#' || mappa[posizioneAttuale[0]][j - 1] == 'O') { // se troviamo un muro
                break;
            } else {
                mappa[posizioneAttuale[0]][j - 1] = '<';    // camminiamo
                mappa[posizioneAttuale[0]][j] = 'X';       // e lasciamo le x dietro
            }
        }
    }
}