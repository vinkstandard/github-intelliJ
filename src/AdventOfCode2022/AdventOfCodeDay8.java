package AdventOfCode2022;

import java.io.*;
import java.util.*;



public class AdventOfCodeDay8 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vink\\Desktop\\AdventOfCode\\2022\\day8.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        List<String> righe = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            righe.add(st);
        }
        int[][] matrice = new int[righe.size()][righe.getFirst().length()];
        for(int i = 0; i < righe.size(); i++){
            String[] split = righe.get(i).split("");
            for(int j = 0; j < split.length; j++){
                matrice[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println("Risultato parte 1: " + calcolaParte1(matrice));

    }
    public static int calcolaParte1(int[][] matrice){

        return 0;
    }
}
