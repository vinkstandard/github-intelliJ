package AdventOfCode2025;

import java.io.*;
import java.util.*;

public class Day6 {
    public static void main(String[] args) throws IOException {

        // lettura file
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\day6.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st.trim().replaceAll("\\s+" , " "));
        }
        System.out.println("Risultato parte 1: " + calcolaParte1(righe));
        System.out.println("Risultato parte 2: " + calcolaParte2(righe));


    }
    public static long calcolaParte1(ArrayList<String> righe) {
        long totale = 0;
        int indice = 0;
        List<String> copia = new ArrayList<>();
        for(String s : righe){
            copia.add(s.trim().replaceAll("\\s+" , " ")); // tocca fare una copia perché la parte 1 è semplificabile, la parte 2 invece vuole che tu lasci i whitespace
        }
        for (int i = 0; i < copia.getLast().split(" ").length; i++) { // usiamo la lunghezza dell'subarray contenente i simboli per capire quante operazioni ci sono da fare
            String simbolo = copia.getLast().split(" ")[indice];
            totale += getTotaleNumeriP1(copia, indice, simbolo);
            indice++;
        }
        return totale;
    }

    public static long calcolaParte2(ArrayList<String> righe) {
        // si deve iniziare da destra
        char[] operatori = righe.getLast().trim().replaceAll("\\s+" , " ").replaceAll(" ", "").toCharArray();
        int numeroOperazioni = operatori.length;
        for(int i = numeroOperazioni - 1; i >= 0; i--){ // andiamo avanti quante sono le operazioni da fare (1000)
            char operatoreAttuale = operatori[i];
            System.out.println(operatoreAttuale);
        }
        return 0;
    }

    public static long getTotaleNumeriP1(List<String> copia, int indice, String simbolo){
        long totale = 0;
        for(int i = 0; i < copia.size() - 1; i++){
            if(simbolo.equals("+")) {
                totale += Long.parseLong(copia.get(i).split(" ")[indice]);
            } else {
                if(totale == 0){
                    totale = 1;
                }
                totale *= Long.parseLong(copia.get(i).split(" ")[indice]);
            }
        }
        return totale;
    }
}
