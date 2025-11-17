package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay1 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day1completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        System.out.println("Risultato parte 1: " + risolviParte1(righe));
        System.out.println("Risultato parte 2: " + risolviParte2(righe));
    }
    public static List<Integer> generaListaCalorie(ArrayList<String> righe){
        List<Integer> risultati = new ArrayList<>();
        int valoreAttuale = 0;
        for(int rigo = 0; rigo < righe.size(); rigo++){
            if(!righe.get(rigo).isEmpty()) valoreAttuale += Integer.parseInt(righe.get(rigo));
            if(rigo + 1 < righe.size() && righe.get(rigo + 1).isEmpty()){
                risultati.add(valoreAttuale);
                valoreAttuale = 0;

            }
        }
        return risultati;
    }
    public static int risolviParte1(ArrayList<String> righe){
        return Collections.max(generaListaCalorie(righe));
    }
    public static int risolviParte2(ArrayList<String> righe){
        List<Integer> listaCalorie = generaListaCalorie(righe);
        Collections.sort(listaCalorie);
        return listaCalorie.get(listaCalorie.size() -1) + listaCalorie.get(listaCalorie.size() -2) + listaCalorie.get(listaCalorie.size() -3);
    }
}
