package CodeWars;

import java.util.*;

public class CodeWars_ASCIIBinoculars {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/5d6a25a4ac739b000dff13d3/java
                     // 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 7, 8, 8, 7, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 1
                     // 1, 1, 2, 2, 3, 3, 3, 3, 3, 2, 2, 2, 3, 4, 3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 5, 5, 5, 3, 1, 1, 1, 2, 2, 2
                     // gubru case 5, 4, 4, 2, 2, 7, 8, 9, 10, 5, 6, 2, 3, 12, 23, 11, 10, 7, 4, 9, 9, 10, 7, 5, 4, 4, 8, 4, 2, 5, 7, 3, 2, 1
        int[]altezza = {1, 1, 2, 2, 3, 3, 3, 3, 3, 2, 2, 2, 3, 4, 3, 2, 1, 1, 1, 1, 1, 1, 2, 3, 5, 5, 5, 3, 1, 1, 1, 2, 2, 2};
        System.out.println(abgen1(altezza));
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
        String s = abgen2(disegno);
        return "ABGEN 1:\n" +sb.toString().trim().replaceAll("c", " ") + "\nABGEN 2:\n" + s;
    }

    public static String abgen2(char[][] disegno) {
        ArrayList<String> asterischi = getAsterischi(disegno);
        for(String s : asterischi){
            String[]posizioneAsterisco = s.split(",");
            int i = Integer.parseInt(posizioneAsterisco[0]), j = Integer.parseInt(posizioneAsterisco[1]);
            if(j == 0){

                continue;
            }
            if(j >= disegno[i].length - 1) {

                continue;
            }
            // altrimenti normale
            // da fare

        }

        return "?";
    }
    public static ArrayList<String> getAsterischi(char[][]disegno){
        ArrayList<String> asterischi = new ArrayList<>();
        for(int i = 0; i < disegno.length; i++){
            for(int j = 0; j < disegno[i].length; j++) {
                if(disegno[i][j] == '*'){
                    asterischi.add(i + "," + j);
                }
            }
        }
        return asterischi;
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
