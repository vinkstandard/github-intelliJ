package AdventOfCode2024;

import java.io.*;
import java.util.*;

public class adventOfCodeDay7 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\2024\\avventoGiorno7input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            if (!st.isEmpty()) {
                righe.add(st);
            }
        }
        ArrayList<Long> numeriDaCercare = new ArrayList<>();
        ArrayList<String> calcoli = new ArrayList<>();

        ArrayList<Long> numeriDaCercareParte2 = new ArrayList<>();
        ArrayList<String> calcoliParte2 = new ArrayList<>();


        for (String s : righe) {
            int stop = s.indexOf(":");
            numeriDaCercare.add(Long.valueOf(s.substring(0, stop)));
            calcoli.add(s.substring(stop + 2));
        }
        // per visualizzazione
        for (int i = 0; i < numeriDaCercare.size(); i++) {
            System.out.println("Numero da cercare: " + numeriDaCercare.get(i) + "   Calcoli: " + calcoli.get(i)); // debug
        }

        long totale = 0;
        char[] simboli = {'x', '+'};
        int indiceNumeroDaCercare = 0;
        while (indiceNumeroDaCercare != numeriDaCercare.size()) {

            long numeroDaCercare = numeriDaCercare.get(indiceNumeroDaCercare);
            String[] calcoliNum = calcoli.get(indiceNumeroDaCercare).split(" ");
            int numeroCalcoli = calcoliNum.length;
            int operazioniPossibili = numeroCalcoli - 1;
            System.out.println("Operazioni possibili: " + operazioniPossibili); // debug
            long numeroCombinazioniMassime = (long) Math.pow(2, operazioniPossibili);
            System.out.println(numeroCombinazioniMassime); // debug

            ArrayList<String> combinazioni = new ArrayList<>();
            generaCombinazioni(simboli, "", operazioniPossibili, combinazioni);
            System.out.println(combinazioni); // debug
            boolean trovato = false;

            for (String s : combinazioni) {
                long num = 0;
                System.out.println("INIZIO COMBINAZIONE " + s);

                if (!trovato) {
                    if (s.length() == 1) {
                        for (String c : calcoliNum) {
                            if (s.equals("+")) {
                                System.out.println(num + " " + s + " " + c); // debug
                                num += Long.parseLong(c);
                            } else {
                                System.out.println(num + " " + s + " " + c);   // debug
                                if (num == 0) {
                                    num = 1;
                                }
                                num *= Long.parseLong(c);
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

                if (!trovato) {
                    if (s.length() > 1) {
                        String[] combinazioniSplittate = s.split("");
                        num = Long.parseLong(calcoliNum[0]);

                        for (int i = 0; i < combinazioniSplittate.length; i++) {
                            String operatore = combinazioniSplittate[i];
                            long valore = Long.parseLong(calcoliNum[i + 1]);

                            if (operatore.equals("+")) {
                                System.out.println(num + " + " + valore + " = " + (num + valore)); // Debug
                                num += valore;
                            } else {
                                System.out.println(num + " * " + valore + " = " + (num * valore)); // Debug
                                num *= valore;
                            }

                            if (num == numeroDaCercare) {
                                totale += numeroDaCercare;
                                System.out.println("TROVATO! BREAKING"); // debug
                                trovato = true;
                                break;
                            }
                        }
                        System.out.println("FINE COMB"); // debug
                    }
                }
            }
            if (!trovato) { // se non procca, allora ci prendiamo i numeri e i rispettivi calcoli per la parte 2
                numeriDaCercareParte2.add(numeroDaCercare);
                calcoliParte2.add(calcoli.get(indiceNumeroDaCercare));
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
