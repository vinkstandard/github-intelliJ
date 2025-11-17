package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay6 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day6completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        // l'input del giorno 6 è una sola riga, ma per ragioni di testing meglio lasciare l'arraylist

        for (String rigo : righe) {
            System.out.println("Risultato parte 1: " + risolviParte1(rigo));
            System.out.println("Risultato parte 2: " + risolviParte2(rigo));

        }
    }

    public static int risolviParte1(String rigo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rigo.length(); i++) {
            if (i + 4 > rigo.length()) break;
            sb.append(rigo, i, i + 4);
            if (isUnico(sb.toString())){
                return i + 4;
            }
            sb = new StringBuilder();
        }

        return 0;
    }

    public static int risolviParte2(String rigo) {
        // la parte 2 ha un'unica differenza, invece di cercare una substring di lunghezza 4, usiamo una sub di lunghezza 14
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rigo.length(); i++) {
            if (i + 14 > rigo.length()) break;
            sb.append(rigo, i, i + 14);
            if (isUnico(sb.toString())){
                return i + 14;
            }
            sb = new StringBuilder();
        }
        return 0;
    }

    public static boolean isUnico(String rigo) {
        Set<Character> set = new HashSet<>();
        for (char c : rigo.toCharArray()) {
            set.add(c);
        }
        return set.size() == rigo.length();
    }
}
