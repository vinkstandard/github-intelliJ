package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day1 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> input = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            input.add(st);
        }
        System.out.println("Risultato parte 1: " + calcolaParte1(input));
        System.out.println("Risultato parte 2: " + calcolaParte2(input));

    }

    public static int calcolaParte1(ArrayList<String> input) {
        int numero = 50, totale = 0;
        for (String comando : input) {
            boolean destra = comando.charAt(0) == 'R';
            int n = Integer.parseInt(comando.replaceAll("[A-Z]", "")) % 100;

            if (!destra) {
                numero -= n;
                if (numero < 0) {
                    numero += 100;
                }
            } else {
                numero = (numero + n) % 100;
            }

            if (numero == 0) totale++;
        }
        return totale;
    }

    public static int calcolaParte2(ArrayList<String> input) {
        int numero = 50, totale = 0;
        for (String comando : input) {
            boolean destra = comando.charAt(0) == 'R';
            int n = Integer.parseInt(comando.replaceAll("[A-Z]", ""));

            for (int i = 0; i < n; i++) {
                if (!destra) {
                    numero -= 1;
                    if (numero < 0) {
                        numero = 99;
                    }
                } else {
                    numero += 1;
                    if (numero > 99) {
                        numero = 0;
                    }
                }
                if (numero == 0) totale++;
            }
        }

        return totale;
    }

}
