package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay2 {
    public static void main(String[] args) throws IOException{

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day2completo.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        System.out.println("Risultato parte 1: " + risolviParte1(righe));
        System.out.println("Risultato parte 2: " + risolviParte2(righe));
    }
    public static int risolviParte1(ArrayList<String> righe){
        int risultato = 0;
        for(String rigo : righe) {
            char mossa1 = rigo.charAt(0), mossa2 = rigo.charAt(2);

            switch(mossa2){
                case 'X':
                    risultato += 1;
                    if(mossa1 == 'A') risultato += 3; // pareggio
                    if(mossa1 == 'C') risultato += 6; // vittoria
                    break;
                case 'Y':
                    risultato += 2;
                    if(mossa1 == 'A') risultato += 6;
                    if(mossa1 == 'B') risultato += 3;
                    break;
                case 'Z':
                    risultato += 3;
                    if(mossa1 == 'C') risultato += 3;
                    if(mossa1 == 'B') risultato += 6;
                    break;
            }
        }
        return risultato;
    }
    public static int risolviParte2(ArrayList<String> righe){
        int risultato = 0;
        for(String rigo : righe) {
            char mossa1 = rigo.charAt(0), mossa2 = rigo.charAt(2);

            switch(mossa2){
                case 'X':
                    if(mossa1 == 'A') risultato += 3;
                    if(mossa1 == 'B') risultato += 1;
                    if(mossa1 == 'C') risultato += 2;
                    break;
                case 'Y':
                    if(mossa1 == 'A') risultato += 4;
                    if(mossa1 == 'B') risultato += 5;
                    if(mossa1 == 'C') risultato += 6;
                    break;
                case 'Z':
                    if(mossa1 == 'A') risultato += 8;
                    if(mossa1 == 'B') risultato += 9;
                    if(mossa1 == 'C') risultato += 7;
                    break;
            }
        }
        return risultato;
    }
}
