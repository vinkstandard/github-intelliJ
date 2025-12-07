package AdventOfCode2025;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {
    public static void main(String[] args) throws IOException {

        // lettura file
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2025\\d6.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
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
        long totale = 0;
        char[] simboli = righe.getLast().trim().replaceAll("\\s+" , "").toCharArray();
        int indiceAttuale = 0, indiceSimbolo = 0;
        List<Long> listaNumeri = new ArrayList<>();

        while(trovaSimboloSuccessivo(righe.getLast(), indiceAttuale) != -1) {
            char simbolo = simboli[indiceSimbolo];

            StringBuilder sb = new StringBuilder();

            for (String rigo : righe) {
                if (indiceAttuale < rigo.length() && Character.isDigit(rigo.charAt(indiceAttuale))) {
                    sb.append(rigo.charAt(indiceAttuale));
                    if (sb.isEmpty()) {
                        System.out.println("SB è vuoto");
                    } else {
                        System.out.println("SB: " + sb);
                    }
                }

            }
            if(!sb.isEmpty()) {
                listaNumeri.add(Long.parseLong(sb.toString().replaceAll("[\\s+]", "")));
                System.out.println("aggiunto: (" + sb + ") alla lista.");
            }

            if(listaNumeri.size() == righe.size() - 1){
                long totaleTabella = (simbolo == '+') ? 0 : 1;
                for(long numero : listaNumeri.reversed()){
                    if(simbolo == '+') totaleTabella += numero;
                    if(simbolo == '*') totaleTabella *= numero;
                }
                System.out.println("listanumeri è piena: " + listaNumeri + " aggiungo " + totaleTabella + " al totale");
                totale += totaleTabella;
                indiceSimbolo++;
                listaNumeri.clear();

            }
            indiceAttuale++;
            System.out.println("TOTALE: " + totale);
            // if(indiceAttuale == 3) break;
        }

        // TODO: prova a fare così, utilizza l'ultima riga, cioè quella dei simboli, per determinare la lunghezza di una tabella, e creare la tabella stessa magari in un array 2d


        return 0;
    }
    public static int trovaSimboloSuccessivo(String rigo, int indiceAttuale){
        for(int i = indiceAttuale + 1; i < rigo.length(); i++){
            if(rigo.charAt(i) == '+' || rigo.charAt(i) == '*'){
                return i;
            }
        }
        System.out.println("ritorna 0");
        return -1;
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
