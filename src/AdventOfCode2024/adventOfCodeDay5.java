package AdventOfCode2024;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class adventOfCodeDay5 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno5InputParziale.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        HashMap<String, List<Integer>> regole = new HashMap<>();
        ArrayList<String> updateString = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            int lunghezzaIn = st.length();
            if (!st.isEmpty() && lunghezzaIn == 5) {
                String[] parti = st.split("\\|");
                String chiave = parti[0];
                int valore = Integer.parseInt(parti[1]);
                regole.computeIfAbsent(chiave, k -> new ArrayList<>()).add(valore);
            }
            if (!st.isEmpty() && lunghezzaIn > 5) {
                updateString.add(st);
            }
        }
//        computeIfAbsent() controlla se esiste già una lista per quella chiave:
//        se sì: usa la lista esistente.
//        se no: crea automaticamente una nuova lista (new ArrayList<>()).
//        poi ritorna la lista, così possiamo subito aggiungere il valore con .add().

//        // print per visualizzazione
//        System.out.println(regole);
//        System.out.println();
//        for (String s : updateString) {
//            System.out.println(s);
//        }
//        // fine print
        int parte1 = 0, parte2 = 0;
        ArrayList<String> updateFalliti = new ArrayList<>();

        for (int lineaUpdate = 0; lineaUpdate < updateString.size(); lineaUpdate++){
            int[] updates = splittaUpdate(updateString.get(lineaUpdate));
            boolean updateValido = true;
            for (int update = 0; update < updates.length; update++) {
                if (update + 1 != updates.length) {
//                    System.out.println("linea update: " + (lineaUpdate + 1) + " \t\tupdate: " + (update + 1));  // debug
                    if (regole.containsKey(String.valueOf(updates[update + 1])) &&
                            regole.get(String.valueOf(updates[update + 1])) != null &&
                            regole.get(String.valueOf(updates[update + 1])).contains(updates[update])) {
                        updateValido = false;
//                        System.out.println("update non valido: " + (lineaUpdate + 1));  // debug
                        String s = "";  // inizio raccolta parte 2
                        for (int numeri : updates) {
                            s = s + numeri + ",";
                        }
                        updateFalliti.add(s); // fine raccolta parte 2
                        break;
                    } else {
                        continue;
                    }
                }
            }
            // parte 1
            if (updateValido) {
//                System.out.println("update valido: " + (lineaUpdate + 1));   // debug
                parte1 += risultatoMezzo(updates);
            }
        }
        // parte 2
        for (String s : updateFalliti) {
            parte2 += calcoloParte2(s, regole);
        }
//        System.out.println("REGOLE:\n" +regole);  // debug
        System.out.println("Risultato parte 1: " + parte1);
        System.out.println("Risultato parte 2: " + parte2);
    }
    public static int calcoloParte2(String s, Map<String, List<Integer>> regoleOriginali){
        int[]updates = splittaUpdate(s);
        ArrayList<Integer>updateOrdinati = new ArrayList<>();
        System.out.println(s);  // debug

        Map<String, List<Integer>> regole = new HashMap<>(regoleOriginali);
        System.out.println("REGOLEEEEEEEEEEEEE\t\t"+regole);

        while(updateOrdinati.size() < updates.length) {
            for (int update : updates) {
                boolean puòEssereAggiunto = true;
                // se l'update è presente in almeno una regola, non può essere ancora inserito
                for (List<Integer> valori : regole.values()) {
                    if (valori.contains(update)) {
                        puòEssereAggiunto = false;
                        break; // appena troviamo un blocco, fermiamoci
                    }
                }
                if (puòEssereAggiunto && !updateOrdinati.contains(update)) {
                    updateOrdinati.add(update);
                    regole.remove(String.valueOf(update)); // Rimuoviamo la regola relativa all'update
                    break; // aggiungiamo l'elemento e fermiamo
                }
            }
        }
        System.out.println(updateOrdinati + " aaaaaaaaaaaaaaaaaaaaaa");
        int centro = updateOrdinati.size() / 2;
        return updateOrdinati.get(centro);
    }

//    public static int calcoloParte2(String s, Map<String, List<Integer>> regole) {
//        // converte la stringa dell'aggiornamento in un array di interi
//        int[] updates = splittaUpdate(s);
//
//        System.out.println("Update da ordinare:");
//        for (int i : updates) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        // filtra le regole per includere solo quelle che riguardano le pagine presenti nell'aggiornamento
//        Map<String, List<Integer>> regoleFiltrate = new HashMap<>();
//        for (Map.Entry<String, List<Integer>> entry : regole.entrySet()) {
//            String chiave = entry.getKey();
//            List<Integer> valori = entry.getValue();
//
//            // aggiungi le regole solo se entrambe le pagine coinvolte sono nell'aggiornamento
//            if (contains(updates, Integer.parseInt(chiave))) {
//                regoleFiltrate.put(chiave, new ArrayList<>(valori));
//            }
//        }
//        // ordina le pagine dell'aggiornamento seguendo le regole
//        List<Integer> ordinato = ordinaPagineConRegole(updates, regoleFiltrate);
//
//        System.out.println("\nUpdate ordinato:");
//        for (int g : ordinato) {
//            System.out.print(g + " ");
//        }
//        System.out.println();
//        // restituisci il numero medio per la parte 2 (la pagina centrale dell'update ordinato)
//        int middleIndex = ordinato.size() / 2;
//        return ordinato.get(middleIndex);
//    }
//
//    public static List<Integer> ordinaPagineConRegole(int[] updates, Map<String, List<Integer>> regoleFiltrate) {
//        // crea una lista di pagine da ordinare, ma solo quelle dell'aggiornamento
//        List<Integer> pagine = new ArrayList<>();
//        for (int update : updates) {
//            pagine.add(update);
//        }
//        // ordinamento topologico usando le regole
//        List<Integer> ordinato = new ArrayList<>();
//        Set<Integer> visitato = new HashSet<>();
//        Set<Integer> inProcess = new HashSet<>();
//        // esegui il topological sort solo per le pagine nell'aggiornamento
//        for (int pagina : pagine) {
//            if (!visitato.contains(pagina)) {
//                topologicalSort(pagina, regoleFiltrate, visitato, inProcess, ordinato, updates);
//            }
//        }
//        return ordinato;
//    }
//
//    // funzione di ordinamento topologico, ora limitata solo alle pagine dell'aggiornamento
//    public static void topologicalSort(int pagina, Map<String, List<Integer>> regole, Set<Integer> visitato, Set<Integer> inProcess, List<Integer> ordinato, int[] updates) {
//        if (inProcess.contains(pagina)) {
//            return; // non dovrebbe succedere se le regole sono consistenti
//        }
//        if (visitato.contains(pagina)) {
//            return; // pagina già visitata
//        }
//        inProcess.add(pagina);
//        // esamina le regole che riguardano questa pagina, ma solo per le pagine nell'aggiornamento
//        for (Map.Entry<String, List<Integer>> entry : regole.entrySet()) {
//            String chiave = entry.getKey();
//            List<Integer> valori = entry.getValue();
//            if (valori.contains(pagina)) {
//                int chiaveInt = Integer.parseInt(chiave);
//
//                // se la chiave è presente nell'aggiornamento, procedi con l'ordinamento
//                if (contains(updates, chiaveInt)) {
//                    topologicalSort(chiaveInt, regole, visitato, inProcess, ordinato, updates);
//                }
//            }
//        }
//        inProcess.remove(pagina);
//        visitato.add(pagina);
//        ordinato.add(pagina);
//    }
//
//    // funzione per verificare se un numero è nell'aggiornamento
//    public static boolean contains(int[] array, int value) {
//        for (int i : array) {
//            if (i == value) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static int[] splittaUpdate(String s) {
        String[] stringArray = s.split(",");  // lineaUpdate Es.  ["75", "45", "21", "39", "83"]
        int[] updates = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            updates[i] = Integer.parseInt(stringArray[i]);   // print per debug
        }
        return updates;
    }

    public static int risultatoMezzo(int[] update) {
        int numero = update[update.length / 2];
        return numero;
    }
}


