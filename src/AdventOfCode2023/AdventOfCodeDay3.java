package AdventOfCode2023;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AdventOfCodeDay3 {
    public static void main(String[] args) throws IOException {

        // lettura file
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2023\\day3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        char[][] input = new char[righe.size()][righe.getFirst().length()];
        for (int i = 0; i < righe.size(); i++) {
            input[i] = righe.get(i).toCharArray();
        }

        Arrays.asList(input).forEach(riga -> System.out.println(new String(riga))); // stampa debug
        int numeroRighe = input.length, numeroColonne = input[0].length;
        int[][] direzioniDaCercare = new int[][]{{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};
        int risultatoParte1 = risolviParteUno(input, numeroRighe, numeroColonne, direzioniDaCercare);
        int risultatoParte2 = risolviParteDue(input, numeroRighe, numeroColonne, direzioniDaCercare);
        System.out.println("Risultato parte 1: " + risultatoParte1 + "\nRisultato parte 2: " + risultatoParte2);

    }
    public static int risolviParteUno(char[][] input, int numeroRighe, int numeroColonne, int[][] direzioniDaCercare){
        int totale = 0;
        // scorro la matrice in cerca di numeri
        StringBuilder numero = new StringBuilder();
        for (int rigo = 0; rigo < numeroRighe; rigo++) {
            for (int colonna = 0; colonna < numeroColonne; colonna++) {
                char carattereAttuale = input[rigo][colonna];

                // costruisco il numero
                if (Character.isDigit(carattereAttuale)) {
                    numero.append(carattereAttuale);
                }
                if(!Character.isDigit(carattereAttuale) || (colonna + 1) == numeroColonne) {
                    // se il carattere attuale non è un numero, ma ne abbiamo già raccolto almeno 1
                    if (!numero.isEmpty()) {
                        int lunghezzaNumero = numero.length();
                        int colonnaIniziale = colonna - lunghezzaNumero; // lo starting point del numero nell'asse X
                        boolean trovato = false;

                        // partiamo a scannerizzare dalla prima cifra
                        for (int i = 0; i < lunghezzaNumero && !trovato; i++) {
                            int colonnaAttuale = colonnaIniziale + i;

                            // controlliamo in tutte le direzioni
                            for (int[] direzione : direzioniDaCercare) {
                                int asseY = rigo + direzione[0];
                                int asseX = colonnaAttuale + direzione[1];
                                if (asseY >= 0 && asseY < numeroRighe && asseX >= 0 && asseX < numeroColonne) {
                                    if (input[asseY][asseX] != '.' && !Character.isDigit(input[asseY][asseX])) { // se è un simbolo, ma non un punto
                                        totale += Integer.parseInt(numero.toString());
                                        trovato = true;
                                        break;
                                    }
                                }
                            }
                        }
                        numero = new StringBuilder(); // reset del numero dopo la ricerca
                    }
                }
            }
        }
        return totale;
    }
    public static int risolviParteDue(char[][] input, int numeroRighe, int numeroColonne, int[][] direzioniDaCercare){




    }
