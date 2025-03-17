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
        while(indiceNumeroDaCercare != numeriDaCercare.size()){

            int numeroDaCercare = numeriDaCercare.get(indiceNumeroDaCercare);
            String[] calcoliNum = calcoli.get(indiceNumeroDaCercare).split(" ");  // nel caso 1 dell'avvento, conterrà ["10", "19"]
            int numeroCalcoli = calcoliNum.length;
            int operazioniPossibli = numeroCalcoli - 1;
            System.out.println("operazioni possibili: " + operazioniPossibli); // debug
            int numeroCombinazioniMassime = (int) Math.pow(2, operazioniPossibli);
            System.out.println(numeroCombinazioniMassime); // debug

            ArrayList<String> combinazioni = new ArrayList<>();                        // sempre nel primo caso, conterrà quindi["+", "x"]
            generaCombinazioni(simboli, "", operazioniPossibli, combinazioni);
            System.out.println(combinazioni); // Debug
            boolean trovato = false;

            // faremo un giro in più perché lavoriamo su num che inizialmente è 0, quindi prima dobbiamo assegnare a num il primo valore
            for(String s : combinazioni){
                int num = 0;
                System.out.println("INIZIO COMBINAZIONE " + s);

                // se sono solo due numeri, non serve splittare gli operatori
                if(!trovato) {
                    if (s.length() == 1) {
                        for (String c : calcoliNum) {
                            if (s.equals("+")) {
                                System.out.println(num + " " + s + " " + c); // debug
                                num += Integer.parseInt(c);
                            } else {
                                System.out.println(num + " " + s + " " + c);   // debug
                                if (num == 0) {
                                    num = 1;
                                }
                                num *= Integer.parseInt(c);
                            }
                            System.out.println("VALORE DI NUM: " + num);   // debug
                        }
                        if (num == numeroDaCercare) {
                            totale += numeroDaCercare;
                            System.out.println("TROVATO! BREAKING");
                            trovato = true;
                            break;
                        }
                    }
                }

                // piu di due numeri
                if(!trovato) {
                    if (s.length() > 1) {
                        String[] combinazioniSplittate = s.split(""); // splittiarmo la stringa dato che conterrà di sicuro più di un operatore
                        num = Integer.parseInt(calcoliNum[0]);  // prendimao il primo numero

                        for (int i = 0; i < combinazioniSplittate.length; i++) {
                            String operatore = combinazioniSplittate[i]; // prendiamo l'operatore
                            int valore = Integer.parseInt(calcoliNum[i + 1]); // il numero dopo

                            if (operatore.equals("+")) {
                                System.out.println(num + " + " + valore + " = " + (num + valore)); // Debug
                                num += valore;
                            } else { // caso moltiplicazione
                                System.out.println(num + " * " + valore + " = " + (num * valore)); // Debug
                                num *= valore;
                            }

                            // se troviamo il numero, stop
                            if (num == numeroDaCercare) {
                                totale += numeroDaCercare;
                                System.out.println("TROVATO! BREAKING"); // debug
                                trovato = true;
                                break;
                            }
                        }
                        System.out.println("FINE COMB"); // Debug
                    }
                }


            }


            indiceNumeroDaCercare++;

        }
        System.out.println("TOTALE: " + totale);
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
