package CodeWars;

import java.util.Arrays;

public class CodeWars_RailFenceCipherEncodingAndDecoding {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/58c5577d61aefcf3ff000081/train/java
//        Create two functions to encode and then decode a string using the Rail Fence Cipher.
//        This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails".
//        First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail.
//        Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.

//        "WEAREDISCOVEREDFLEEATONCE" = "WECRLTEERDSOEEFEAOCAIVDEN" rail = 3;
//        W       E       C       R       L       T       E
//          E   R   D   S   O   E   E   F   E   A   O   C
//            A       I       V       D       E       N
//        "Hello, World!" == "H !e,Wdloollr   rail = 4;

        int rail = 3;
        System.out.println("ENCODING: ");
        System.out.println(encode("WEAREDISCOVEREDFLEEATONCE", rail) + "\n");
        System.out.println("DECODING: ");
        System.out.println(decode("WECRLTEERDSOEEFEAOCAIVDEN",rail));
    }
    static String encode(String s, int n) {

        char[][] grafo = new char[n][s.length() * 2];
        int lunghezzaRigo = n;
        int lunghezzaStringa = s.length() * 2;
        for(int i = 0; i < lunghezzaRigo; i++){
            for(int j = 0; j < lunghezzaStringa; j++){
                grafo[i][j] = '╣'; // ╣
            }
        }
        boolean giu = true, su = false;
        int spostamentoLaterale = 0, spostamentoVerticale = 0;
        char[] caratteri = s.toCharArray();
        for(char carattere : caratteri){
            if(spostamentoLaterale == 0 && spostamentoVerticale == 0){ // primo carattere
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale++;
                spostamentoLaterale++;
                continue;
            }
            if(spostamentoVerticale == n - 1){
                giu = false;
                su = true;
            }
            else if(spostamentoVerticale == 0){
                giu = true;
                su = false;
            }

            if(giu){
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale++;
            }
            else if(su){
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale--;
            }
            spostamentoLaterale++;
        }
        stampaGrafo(grafo); // debug
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lunghezzaRigo; i++){
            for(int j = 0; j < lunghezzaStringa; j++){
                char c = grafo[i][j];
                if(c != '╣'){
                    sb.append(c);
                }
            }
        }

        System.out.println("STRINGA ORIGINALE: " + s);
        System.out.println("STRINGA CIFRATA: " + sb);
        return sb.toString();

    }

    static String decode(String s, int n) {
        char[][] grafo = new char[n][s.length() * 2];
        int lunghezzaRigo = n;
        int lunghezzaStringa = s.length() * 2;
        for(int i = 0; i < lunghezzaRigo; i++){
            for(int j = 0; j < lunghezzaStringa; j++){
                grafo[i][j] = '╣'; // ╣
            }
        }
        boolean giu = true, su = false;
        int spostamentoLaterale = 0, spostamentoVerticale = 0;
        char[] caratteri = s.toCharArray();
        for(char carattere : caratteri){
            if(spostamentoLaterale == 0 && spostamentoVerticale == 0){ // primo carattere
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale++;
                spostamentoLaterale++;
                continue;
            }
            if(spostamentoVerticale == n - 1){
                giu = false;
                su = true;
            }
            else if(spostamentoVerticale == 0){
                giu = true;
                su = false;
            }

            if(giu){
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale++;
            }
            else if(su){
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale--;
            }
            spostamentoLaterale++;
        }
        stampaGrafo(grafo); // debug
        return null;
    }














    public static void stampaGrafo(char[][] grafo){
        for(int i = 0; i < grafo.length; i++){
            for(int j = 0; j < grafo[0].length; j++) {
                if (grafo[i][j] == '╣') {
                    System.out.print(". ");
                }else{
                    System.out.print(grafo[i][j] + " ");
            }
            }
            System.out.println();
        }
    }
}
