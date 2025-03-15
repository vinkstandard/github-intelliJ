package AdventOfCode2024;

import java.io.*;
import java.util.*;

public class adventOfCodeDay7 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno7InputParziale.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (!st.isEmpty()) {
                righe.add(st);
            }
        }
        ArrayList<Integer> numeriDaCercare = new ArrayList<>();
        ArrayList<String> calcoli = new ArrayList<>();

        for(String s : righe){
            int stop = s.indexOf(":");
            numeriDaCercare.add(Integer.valueOf(s.substring(0 , stop))); // piccolo reminder: in (int startIndex, int endIndex) endIndex non è inclusivo
            calcoli.add(s.substring(stop+2));
        }
        // per visualizzazione
        for(int i = 0; i < numeriDaCercare.size(); i++){
            System.out.println("Numero da cercare: " + numeriDaCercare.get(i) + "   Calcoli: " + calcoli.get(i));
        }

        // forse la strat è creare una stringa randomica che contenga tutti gli operatori attaccati, e dovrà avere tanti operatori quanto è calcoliSplit.length -1 ???


        char[] simboli = {'x', '+'};
        Random rand = new Random();
        char simboloCasuale = simboli[rand.nextInt(simboli.length)];
        Set<String> operatori = new HashSet<>();
        while(true){


        }
    }
}
