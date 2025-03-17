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
            System.out.println("Numero da cercare: " + numeriDaCercare.get(i) + "   Calcoli: " + calcoli.get(i)); // debug
        }

        // forse la strat è creare una stringa randomica che contenga tutti gli operatori attaccati, e dovrà avere tanti operatori quanto è calcoliSplit.length -1 ???


        int totale = 0;

        char[] simboli = {'x', '+'};
        Random rand = new Random();

        char simboloCasuale = simboli[rand.nextInt(simboli.length)];
        int indiceNumeroDaCercare = 0;
        while(true){
            int numeroDaCercare = numeriDaCercare.get(indiceNumeroDaCercare);
            String[] calcoliNum = calcoli.get(indiceNumeroDaCercare).split(" ");
            int numeroCalcoli = calcoliNum.length;
            int operazioniPossibli = numeroCalcoli - 1;
            System.out.println("operazioni possibili: " + operazioniPossibli); // debug
            int numeroCombinazioniMassime = (int) Math.pow(2, operazioniPossibli);
            System.out.println(numeroCombinazioniMassime); // debug

            ArrayList<String> combinazioni = new ArrayList<>();
            generaCombinazioni(simboli, "", operazioniPossibli, combinazioni);
            System.out.println(combinazioni); // Debug

            for(String s : combinazioni){
                int num = 0;
                if(s.length() == 1){

                }
                else if(s.length() > 1){

                }
            }




            if(indiceNumeroDaCercare == 1){
                break;
            }
            indiceNumeroDaCercare++;

        }
    }
    public static void generaCombinazioni(char[] simboli, String corrente, int lunghezza, ArrayList<String> combinazioni) {
        if (corrente.length() == lunghezza) {
            combinazioni.add(corrente);
            return;
        }

        for (char simbolo : simboli) {
            generaCombinazioni(simboli, corrente + simbolo, lunghezza, combinazioni);
        }
    }
}
