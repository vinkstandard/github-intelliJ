package CodeWars;

import java.util.*;

public class CodeWars_ASCIIBinoculars {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5d6a25a4ac739b000dff13d3/discuss/java
                     // 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 7, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1
                     // 1, 1, 2, 2, 3, 3, 3, 3, 3, 2, 2, 2, 3, 4, 3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 5, 5, 5, 3, 1, 1, 1, 2, 2, 2
        int[]altezza = {1, 1, 2, 2, 3, 3, 3, 3, 3, 2, 2, 2, 3, 4, 3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 5, 5, 5, 3, 1, 1, 1, 2, 2, 2};
        System.out.println(abgen1(altezza) + " " +abgen2(altezza));
    }
    public static String abgen1(int heights[]) {

        ArrayList<Integer> valori = new ArrayList<>(Arrays.stream(heights).boxed().toList());
        int altezzaMassima = Collections.max(valori), lunghezza = valori.size();
        char[][] disegno = new char[altezzaMassima][lunghezza];

       for(int j = 0; j < lunghezza; j++){
           int posizione = altezzaMassima - 1 - (valori.get(j) - 1);
           disegno[posizione][j] = '*';
       }
       stampaDisegno(disegno,altezzaMassima,lunghezza); // debug

       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < altezzaMassima; i++){
           for(int j = 0; j < lunghezza; j++){
               if(disegno[i][j] == '\0'){ // \0 è il carattere vuoto, dato che char non ha null, si utilizza quello
                   sb.append("c"); // gli assegnamo un valore a caso per poi fare replaceall alla fine
               }else {
                   sb.append(disegno[i][j]); // altrimenti appendiamo l'asterisco
               }
           }
           sb.append("\n"); // appendiamo la newline
       }
        String val = "";
        for(int n : valori){
            val += String.valueOf(n);
        }
        sb.append(val);
       System.out.println("STRING BUILDER ABGEN1: ");
       System.out.println(sb.toString().trim().replaceAll("c", " "));


        return "?";
    }

    public static String abgen2(int heights[]) {
        // Your code here
        return "?";
    }
    public static void stampaDisegno(char[][]disegno, int altezzaMassima, int lunghezza){
        for(int i = 0; i < altezzaMassima; i++){
            for(int j = 0; j < lunghezza; j++){
                if(disegno[i][j] == '\0'){
                    System.out.print(". ");
                }else {
                    System.out.print(disegno[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
