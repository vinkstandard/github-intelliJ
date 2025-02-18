package AdventOfCode2024;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class adventOfCodeDay2 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno2input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int totaleParte1 = 0, totaleParte2 = 0;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        for (String s : righe) {
            totaleParte1 += calcoloParte1(s);
            totaleParte2 += calcoloParte2(s);
        }
        System.out.println("Totale parte 1 : " + totaleParte1);
        System.out.println("Totale parte 2 : " + totaleParte2);
    }

    public static int calcoloParte1(String s) {
        int[] numeri = parseNumeri(s);
        return isSafe(numeri) ? 1 : 0;
    }

    public static int calcoloParte2(String s) {
        int[] numeri = parseNumeri(s);
        for (int i = 0; i < numeri.length; i++) {
            int[] nuoviNumeri = new int[numeri.length - 1];
            int index = 0;
            for (int j = 0; j < numeri.length; j++) {
                if (j == i) continue;
                nuoviNumeri[index++] = numeri[j];
            }
            if (isSafe(nuoviNumeri)) {
                return 1;
            }
        }
        return 0;
    }

    public static boolean isSafe(int[] numeri) {
        boolean crescente = true, decrescente = true;

        for (int i = 0; i < numeri.length - 1; i++) {
            int differenza = numeri[i + 1] - numeri[i];
            if (Math.abs(differenza) > 3 || differenza == 0) {
                return false;
            }
            if (differenza > 0) {
                decrescente = false;
            } else if (differenza < 0) {
                crescente = false;
            }
        }
        return crescente || decrescente;
    }

    public static int[] parseNumeri(String s) {
        String[] n = s.split(" ");
        int[] numeri = new int[n.length];
        for (int i = 0; i < numeri.length; i++) {
            numeri[i] = Integer.parseInt(n[i]);
        }
        return numeri;
    }
}
