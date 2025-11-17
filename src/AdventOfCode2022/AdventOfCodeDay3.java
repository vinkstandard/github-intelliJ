package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay3 {
    static Map<Character, Integer> valoriLettere = new HashMap<>();

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day3completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        int valore = 1;
        for (char c = 'a'; c <= 'z'; c++) { valoriLettere.put(c, valore++); }
        for (char c = 'A'; c <= 'Z'; c++) { valoriLettere.put(c, valore++); }

        System.out.println("Risultato parte 1: " + risolviParte1(righe));
        System.out.println("Risultato parte 2: " + risolviParte2(righe));

    }

    public static int risolviParte1(ArrayList<String> righe) {
        int risultato = 0;
        for (String rigo : righe) {
            String parte1 = rigo.substring(0, rigo.length() / 2), parte2 = rigo.substring(rigo.length() / 2);
            for (char c : parte1.toCharArray()) {
                if(parte2.indexOf(c) != -1){
                    risultato += valoriLettere.get(c);
                   // System.out.println("Aggiungo valore: " + valoriLettere.get(c));
                    break;
                }
            }
        }
        return risultato;
    }

    public static int risolviParte2(ArrayList<String> righe) {
        int risultato = 0;
        List<String> listaParole = new ArrayList<>();
        for (String rigo : righe) {
            listaParole.add(rigo);
            if (listaParole.size() == 3) {
                String s1 = listaParole.get(0), s2 = listaParole.get(1), s3 = listaParole.get(2);
                for (char c : s1.toCharArray()) {
                    if (s2.indexOf(c) != -1 && s3.indexOf(c) != -1) {
                       // System.out.println("aggiunto +" + valoriLettere.get(c) + " per la lettera \"" + c + "\"");
                        risultato += valoriLettere.get(c);
                        break;
                    }
                }
                listaParole.clear();
            }
        }
        return risultato;
    }
}
