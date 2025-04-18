package CodeWars._3kyu;

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


        String cifra =   "MIRCO E UNO SCHIAVO DEGLI EBREI";
        String decifra = "MESOIII   CV L EROUOHADGERCNIEB";
        int rail = 4;

        System.out.println("CIFRATURA\n" + encode(cifra, rail) + "\n");;
        System.out.println("DECIFRATURA\n" + decode(decifra,rail));
    }

    static String encode(String s, int n) {

        char[][] grafo = new char[n][s.length() * 2];
        int lunghezzaRigo = n;
        int lunghezzaStringa = s.length() * 2;
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                grafo[i][j] = '╣'; // ╣
            }
        }
        boolean giu = true, su = false;
        int spostamentoLaterale = 0, spostamentoVerticale = 0;
        char[] caratteri = s.toCharArray();
        for (char carattere : caratteri) {
            if (spostamentoLaterale == 0 && spostamentoVerticale == 0) { // primo carattere
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale++;
                spostamentoLaterale++;
                continue;
            }
            if (spostamentoVerticale == n - 1) {
                giu = false;
                su = true;
            } else if (spostamentoVerticale == 0) {
                giu = true;
                su = false;
            }

            if (giu) {
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale++;
            } else if (su) {
                grafo[spostamentoVerticale][spostamentoLaterale] = carattere;
                spostamentoVerticale--;
            }
            spostamentoLaterale++;
        }
        // debug
        stampaGrafo(grafo);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lunghezzaRigo; i++) {
            for (int j = 0; j < lunghezzaStringa; j++) {
                char c = grafo[i][j];
                if (c != '╣') {
                    sb.append(c);
                }
            }
        }
        // debug
        System.out.println("STRINGA ORIGINALE: " + s);
        System.out.println("STRINGA CIFRATA: " + sb);
        return sb.toString();

    }


    static String decode(String s, int n) {

        char[][] grafo = new char[n][s.length()];
        boolean giu = true, su = false;
        int spostamentoVerticale = 0;
        for (int carattere = 0; carattere < s.length(); carattere++) {

            if (spostamentoVerticale == n - 1) {
                giu = false;
                su = true;
            }
            if (spostamentoVerticale == 0) {
                giu = true;
                su = false;
            }
            if (spostamentoVerticale == 0 && carattere == 0) { // primo carattere
                grafo[spostamentoVerticale][carattere] = '*';
                spostamentoVerticale++;
                continue;
            }
            if (giu) {
                grafo[spostamentoVerticale][carattere] = '*';
                spostamentoVerticale++;
            }
            if (su) {
                grafo[spostamentoVerticale][carattere] = '*';
                spostamentoVerticale--;
            }
        }
//        stampaGrafo(grafo);
        // aggiunta dei caratteri al grafo
        int indice = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (grafo[i][j] == '*' && indice < s.length()) {
                    grafo[i][j] = s.charAt(indice++);
                }
            }
        }
        // debug
//        stampaGrafo(grafo);
        StringBuilder sb = new StringBuilder();
        spostamentoVerticale = 0;

        for (int carattere = 0; carattere < s.length(); carattere++) {
            if (spostamentoVerticale == n - 1) {
                giu = false;
                su = true;
            }
            if (spostamentoVerticale == 0) {
                giu = true;
                su = false;
            }
            if (spostamentoVerticale == 0 && carattere == 0) { // primo carattere
                sb.append(grafo[spostamentoVerticale][carattere]);
                spostamentoVerticale++;
                continue;
            }
            if (giu) {
                sb.append(grafo[spostamentoVerticale][carattere]);
                spostamentoVerticale++;
            }
            if (su) {
                sb.append(grafo[spostamentoVerticale][carattere]);
                spostamentoVerticale--;
            }
        }
        System.out.println("STRINGA NORMALE: " + s);
        System.out.println("STRINGA DECIFRATA: " + sb);
        return sb.toString();
    }

    public static void stampaGrafo(char[][] grafo) { // metodo per visualizzazione debug
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[0].length; j++) {
                if (grafo[i][j] == '╣') {
                    System.out.print(". ");
                } else {
                    System.out.print(grafo[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
