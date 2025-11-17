package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay4 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day4completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        System.out.println("Risultato parte 1: " + risolviParte1(righe));
        System.out.println("Risultato parte 2: " + risolviParte2(righe));
    }

    public static int risolviParte1(ArrayList<String> righe) {

        int totale = 0;
        for (String rigo : righe) {
            String[] rangeTotali = rigo.split(",");
            int[] range1 = new int[]{Integer.parseInt(rangeTotali[0].split("-")[0]), Integer.parseInt(rangeTotali[0].split("-")[1])};
            int[] range2 = new int[]{Integer.parseInt(rangeTotali[1].split("-")[0]), Integer.parseInt(rangeTotali[1].split("-")[1])};


            // System.out.println("Range 1: " + Arrays.toString(range1) + "\tRange 2: " + Arrays.toString(range2));
            if (range1[0] <= range2[0] && range1[1] >= range2[1] || range2[0] <= range1[0] && range2[1] >= range1[1]) {
                totale++;
            }
        }
        return totale;
    }

    public static int risolviParte2(ArrayList<String> righe) {

        int totale = 0;
        for (String rigo : righe) {
            String[] rangeTotali = rigo.split(",");
            int min1 = Integer.parseInt(rangeTotali[0].split("-")[0]), max1 = Integer.parseInt(rangeTotali[0].split("-")[1]);
            int min2 = Integer.parseInt(rangeTotali[1].split("-")[0]), max2 = Integer.parseInt(rangeTotali[1].split("-")[1]);
            if (min1 <= max2 && min2 <= max1) totale++;
        }
        return totale;
    }
}
