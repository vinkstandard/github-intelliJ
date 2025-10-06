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
        System.out.println("Risultato parte 1: " + risultatoParte1);
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
            System.out.println(numeriVincenti);
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
}
