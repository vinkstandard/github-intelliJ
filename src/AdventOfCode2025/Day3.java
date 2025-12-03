package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day3 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day3.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        System.out.println("Totale parte 1: " + calcolaParte1(righe));
        System.out.println("Totale parte 2: " + calcolaParte2(righe));
    }

    public static int calcolaParte1(List<String> righe) {
        int totale = 0;
        for (String rigo : righe) {
            List<Integer> numeri = new ArrayList<>();

            for (int i = 0; i < rigo.length(); i++) {
                for (int j = i + 1; j < rigo.length(); j++) {
                    String numero = rigo.charAt(i) + "" + rigo.charAt(j);
                    numeri.add(Integer.parseInt(numero));
                }
            }

            totale += Collections.max(numeri);
        }
        return totale;
    }

    public static long calcolaParte2(List<String> righe) {
        long totale = 0;
        for (String rigo : righe) {

            int indiceInizio = 0, numeroInizio = 0;
            for (int i = 0; i < rigo.length(); i++) {
                if (rigo.length() - i < 12) break;
                if (Character.getNumericValue(rigo.charAt(i)) > numeroInizio) {
                    numeroInizio = Character.getNumericValue(rigo.charAt(i));
                    indiceInizio = i;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(numeroInizio);

            while (sb.length() != 12) {
                int numero = 0;
                for (int i = indiceInizio + 1; i < rigo.length(); i++) {
                    if (i > rigo.length() - (12 - sb.length())) break; // check per assicurarci di lasciare abbastanza caratteri (a destra)

                    if (Character.getNumericValue(rigo.charAt(i)) > numero) {
                        numero = Character.getNumericValue(rigo.charAt(i));
                        indiceInizio = i;
                    }

                }
                sb.append(numero);
            }
            totale += Long.parseLong(sb.toString());
        }
        return totale;
    }
}
