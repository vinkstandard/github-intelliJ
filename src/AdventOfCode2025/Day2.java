package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day2.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        String[] ranges = st.split(",");

        System.out.println("Risultato Parte 1: " + calcolaParte1(ranges));
        System.out.println("Risultato Parte 2: " + calcolaParte2(ranges));

    }

    public static long calcolaParte1(String[] ranges) {
        long totale = 0;
        for (String range : ranges) {
            String[] split = range.split("-");
            long min = Long.parseLong(split[0]), max = Long.parseLong(split[1]);

            // controlliamo il max solo all'inizio dato che non cambia
            String maxString = String.valueOf(max);
            if (maxString.matches("^(.+?)\\1+$")) {
                if (maxString.substring(0, maxString.length() / 2).equals((maxString.substring(maxString.length() / 2)))) {
                    totale += max;
                }
            }

            while (min != max) {
                String minString = String.valueOf(min);
                if (minString.length() % 2 == 0) {
                    if (minString.substring(0, minString.length() / 2).equals((minString.substring(minString.length() / 2)))) {
                        totale += min;
                    }
                }
                min++;
            }

        }
        return totale;
    }

    public static long calcolaParte2(String[] ranges) {
        long totale = 0;
        for (String range : ranges) {
            String[] split = range.split("-");
            long min = Long.parseLong(split[0]), max = Long.parseLong(split[1]);

            // controlliamo il max solo all'inizio dato che non cambia
            String maxString = String.valueOf(max);

            // la regex controlla se la stringa è formata esclusivamente da ripetizioni
            if (maxString.matches("^(.+?)\\1+$")) {
                System.out.println("[1] trovato un id invalido: " + max);
                totale += max;
            }

            while (min != max) {
                String minString = String.valueOf(min);
                if (minString.matches("^(.+?)\\1+$")) {
                    System.out.println("[2] trovato un id invalido: " + min);
                    totale += min;
                }
                min++;
            }
        }
        return totale;
    }

}


//                // controllo numeri uguali
//                String regEx = ("[^" + Pattern.quote(Character.toString(minString.charAt(0))) + "]");
//                String check = minString.replaceAll(regEx, "");
//                if(!usciti.contains(check) && check.length() == minString.length()){
//                    System.out.println("[2] trovato un id invalido: " + check);
//                }