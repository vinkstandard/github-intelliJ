package AdventOfCode2022;

import java.io.*;
import java.util.*;

public class AdventOfCodeDay9 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day9.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();
        while ((st = br.readLine()) != null) {
            righe.add(st);
        }

        System.out.println("Risultato Test: " + calcolaTestParte1(righe));
    }
    public static int calcolaTestParte1(List<String> righe){

        // il test non specifica quanto serve grande la griglia, quindi iniziamo a far funzionare il testcase, se funziona questo, alziamo il limite a 100x100, se non va alziamo ancora di più, gaming
        char[][] matrice = new char[6][5];
        for(int i = 0; i < matrice.length; i++){
            matrice[i] = "......".toCharArray();
        }

        debug(matrice);



        return 0;
    }
    public static void debug(char[][] matrice){

        final String BLU = "\u001B[0;94m";
        final String RESET = "\u001B[0m";
        System.out.println("--------------------");
        for (char[] chars : matrice) {
            System.out.print("\t");
            for (char c : chars) {
                String colore;
                colore = (c == 'T' || c == 'H') ? BLU : "";
                System.out.print(colore + c + RESET + " ");
            }
            System.out.println();
        }
    }
}
