import java.io.*;
import java.io.IOException;
import java.util.*;
public class adventOfCodeDay1 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno1input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        int totaleParte1 = 0, totaleParte2 = 0;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        ArrayList<Integer> sinistra = new ArrayList<>();
        ArrayList<Integer> destra = new ArrayList<>();
        for (int i = 0; i < righe.size(); i++) {
            String s = righe.get(i).replaceFirst(" ", ",").replaceAll(" " , "");
            String[] numeri = s.split(",");
            sinistra.add(Integer.parseInt(numeri[0]));
            destra.add(Integer.parseInt(numeri[1]));
        }
        totaleParte1 += controlloParte1(sinistra, destra);
        totaleParte2 += controlloParte2(sinistra, destra);
        System.out.println("Totale parte 1: " + totaleParte1);
        System.out.println("Totale parte 2: " + totaleParte2);
    }

    public static int controlloParte1(ArrayList<Integer> sinistra, ArrayList<Integer> destra) {
        int totale = 0;
        Collections.sort(destra);
        Collections.sort(sinistra);
        for (int i = 0; i < sinistra.size(); i++) {
            if (destra.get(i) > sinistra.get(i)) {
                totale += (destra.get(i) - sinistra.get(i));
            } else if (destra.get(i) < sinistra.get(i)) {
                totale += (sinistra.get(i) - destra.get(i));
            } else {
                totale += (destra.get(i) - sinistra.get(i));
            }
        }
        return totale;
    }

    public static int controlloParte2(ArrayList<Integer> sinistra, ArrayList<Integer> destra) {
        int totale = 0;
        for (Integer i : sinistra) {
            int contoParole = 0;
            for (Integer j : destra) {
                if (Objects.equals(i, j)) {
                    contoParole++;
                }
            }
            totale += (i * contoParole);
        }
        return totale;
    }
}
