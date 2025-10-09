package AdventOfCode2023;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay4 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2023\\day4completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
            // System.out.println(st); // print di debug
        }

        int risultatoParte1 = risolviParte1(righe);
        System.out.println("Risultato parte 1: " + risultatoParte1 + "\n");
        int risultatoParte2 = risolviParte2(righe);
        System.out.println("Risultato parte 2: " + risultatoParte2);
    }

    public static int risolviParte1(ArrayList<String> righe) {
        int totale = 0;
        // inizio a pulire le righe
        for (String rigo : righe) {
            int valoreRigo = 0;
            String rigoPulito = rigo.substring(rigo.indexOf(":") + 2).replaceAll("\\s+", " ").trim(); // pulisco la riga
            // estraggo i numeri
            String[] parti = rigoPulito.split("\\|");
            List<Integer> numeriVincenti = estraiNumeri(parti[0].trim());
            List<Integer> numeriInPossesso = estraiNumeri(parti[1].trim());
            for (int numero : numeriInPossesso) {
                if (numeriVincenti.contains(numero) && valoreRigo != 0) valoreRigo *= 2;
                if (numeriVincenti.contains(numero) && valoreRigo == 0) valoreRigo = 1;
            }
            totale += valoreRigo;
        }
        return totale;
    }

    public static List<Integer> estraiNumeri(String parte) {
        List<Integer> ritorno = new ArrayList<>();
        String[] nums = parte.split(" ");
        for (String num : nums) {
            ritorno.add(Integer.parseInt(num));
        }
        return ritorno;
    }

//  parte 2

    public static int risolviParte2(ArrayList<String> righe) {
        int totale = 0;
        Map<Integer, Integer> mappaValori = calcolaValore(righe);
        HashMap<Integer, Integer> numeroCopie = new HashMap<>();
        for (int i = 0; i < righe.size(); i++) { // inizializzo la mappa che conta le copie a 1 dato che abbiamo almeno il numero delle schede iniziali
            numeroCopie.put(i, 1);
        }

        // aggiorno la mappa delle copie
        for (Map.Entry<Integer, Integer> entry : numeroCopie.entrySet()) {
            int schedaAttuale = entry.getKey();
            int valoreSchedaAttuale = mappaValori.get(schedaAttuale);
            int numeroCopieSchedaAttuale = entry.getValue();

            // aggiungiamo altre copie in massa
            if (numeroCopieSchedaAttuale > 1) {
                for (int ripetizioni = 0; ripetizioni < numeroCopieSchedaAttuale; ripetizioni++) {
                    for (int aggiunta = schedaAttuale + 1; aggiunta <= ((schedaAttuale + 1) + (valoreSchedaAttuale - 1)); aggiunta++) {
                        // System.out.println("aggiunto + 1 alla scheda n." + aggiunta);
                        numeroCopie.computeIfPresent(aggiunta, (k, v) -> v + 1);
                    }
                }
            } else { // altrimenti se il numero di copie è solo 1 lo facciamo una volta sola
                for (int aggiunta = schedaAttuale + 1; aggiunta <= ((schedaAttuale + 1) + (valoreSchedaAttuale - 1)); aggiunta++) {
                    // System.out.println("aggiunto + 1 alla scheda n." + aggiunta);
                    numeroCopie.computeIfPresent(aggiunta, (k, v) -> v + 1);
                }
            }
            // aggiungiamo il numero delle schede al totale
            totale += numeroCopieSchedaAttuale;
        }
        stampaSchede(numeroCopie, mappaValori); // debug
        return totale;
    }

    public static Map<Integer, Integer> calcolaValore(ArrayList<String> righe) {
        Map<Integer, Integer> mappaValori = new HashMap<>();
        for (int i = 0; i < righe.size(); i++) {
            String rigo = righe.get(i);
            String rigoPulito = rigo.substring(rigo.indexOf(":") + 2).replaceAll("\\s+", " ").trim();
            String[] parti = rigoPulito.split("\\|");
            List<Integer> numeriVincenti = estraiNumeri(parti[0].trim());
            List<Integer> numeriInPossesso = estraiNumeri(parti[1].trim());
            int match = 0;
            for (int numero : numeriVincenti) {
                if (numeriInPossesso.contains(numero)) match++;
            }
            mappaValori.put(i, match);
        }
        return mappaValori;
    }

    public static void stampaSchede(Map<Integer, Integer> numeroCopie, Map<Integer, Integer> mappaValori) {
        System.out.println("----------Stampa Schede----------");
        for (Map.Entry<Integer, Integer> entry : numeroCopie.entrySet()) {
            int schedaAttuale = entry.getKey();
            int valoreSchedaAttuale = mappaValori.get(entry.getKey());
            int numeroCopieSchedaAttuale = entry.getValue();
            System.out.println("Scheda n." + schedaAttuale + " con valore " + valoreSchedaAttuale + ", numero copie: " + numeroCopieSchedaAttuale);
        }
        System.out.println("---------------------------------");

    }
}
