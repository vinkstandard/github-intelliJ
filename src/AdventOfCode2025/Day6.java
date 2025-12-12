package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws IOException {

        // lettura file
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day6.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        System.out.println("Risultato parte 1: " + calcolaParte1(righe));
        System.out.println("Risultato parte 2: " + calcolaParte2(righe));

    }

    public static long calcolaParte1(ArrayList<String> righe) {
        long totale = 0;
        int indice = 0;
        List<String> copia = new ArrayList<>();
        for (String s : righe) {
            copia.add(s.trim().replaceAll("\\s+", " ")); // tocca fare una copia perché la parte 1 è semplificabile, la parte 2 invece vuole che tu lasci i whitespace
        }
        for (int i = 0; i < copia.getLast().split(" ").length; i++) { // usiamo la lunghezza dell'subarray contenente i simboli per capire quante operazioni ci sono da fare
            String simbolo = copia.getLast().split(" ")[indice];
            totale += getTotaleNumeriP1(copia, indice, simbolo);
            indice++;
        }
        return totale;
    }

    public static long calcolaParte2(ArrayList<String> righe) {
        long totale = 0;
        char[] simboli = righe.getLast().trim().replaceAll("\\s+", "").toCharArray();
        int indiceAttuale = 0, indiceSimbolo = 0;

        while (getProssimoStop(indiceAttuale, righe.getLast()) != -1) {
            char simbolo = simboli[indiceSimbolo];
            int indiceFine = getProssimoStop(indiceAttuale, righe.getLast());
            boolean finale = getProssimoStop(indiceAttuale, righe.getLast()) == -100;
            List<String> numeri = new ArrayList<>();

            for (String rigo : righe) {
                String numeroSub = "";
                if (indiceAttuale < rigo.length()) {
                    if (!finale) {
                        numeroSub = rigo.substring(indiceAttuale, indiceFine);

                    } else {
                        // condizione finale
                        numeroSub = rigo.substring(indiceAttuale);
                    }
                } else {
                    System.out.println("errore parsing");
                }
                if (!numeroSub.isEmpty() && !numeroSub.contains("+") && !numeroSub.contains("*")) numeri.add(numeroSub);
            }

            totale += getTotaleTabella(numeri, simbolo);
            indiceSimbolo++;

            if (!finale) {
                indiceAttuale = indiceFine;
            } else {
                break;
            }
        }

        return totale;
    }

    public static long getTotaleTabella(List<String> numeri, char simbolo) {

        int indiceAttuale = numeri.getFirst().length() - 1; // partiamo dalla fine perché dobbiamo leggere da destra a sin
        int lunghezzaNumeroMax = 0;
        for (String n : numeri) {
            if (lunghezzaNumeroMax < n.replaceAll("\\s+", "").length())
                lunghezzaNumeroMax = n.replaceAll("\\s+", "").length();
        }
        List<Long> numeriVerticali = new ArrayList<>();

        while (numeriVerticali.size() != lunghezzaNumeroMax) {
            StringBuilder sb = new StringBuilder();
            for (String numero : numeri) {
                char carattereAttuale = numero.charAt(indiceAttuale);
                if (Character.isDigit(carattereAttuale)) {
                    sb.append(carattereAttuale);
                }
            }
            if (!sb.isEmpty()) numeriVerticali.add(Long.parseLong(sb.toString()));
            indiceAttuale--;
        }

        long totale = (simbolo == '+') ? 0 : 1;
        for (Long num : numeriVerticali) {
            if (simbolo == '+') totale += num;
            if (simbolo == '*') totale *= num;
        }
        System.out.println("Tabella: " + numeri + "\tLunghezza num massima: " + lunghezzaNumeroMax + "\tNumeri verticali: " + numeriVerticali + " TOTALE TABELLA: " + totale);

        return totale;
    }

    public static int getProssimoStop(int indiceAttuale, String rigo) { // solo l'ultimo rigo, quello dei simboli
        if (indiceAttuale == rigo.length() - 1) return -1;

        for (int i = indiceAttuale + 1; i < rigo.length(); i++) {
            if (rigo.charAt(i) == '+' || rigo.charAt(i) == '*') return i;
        }
        System.out.println("ritorna -100");
        return -100;
    }


    public static long getTotaleNumeriP1(List<String> copia, int indice, String simbolo) {
        long totale = 0;
        for (int i = 0; i < copia.size() - 1; i++) {
            if (simbolo.equals("+")) {
                totale += Long.parseLong(copia.get(i).split(" ")[indice]);
            } else {
                if (totale == 0) {
                    totale = 1;
                }
                totale *= Long.parseLong(copia.get(i).split(" ")[indice]);
            }
        }
        return totale;
    }
}
