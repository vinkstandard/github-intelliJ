package CodeWars;

import java.util.Arrays;

public class CodeWars_RailFenceCipherEncodingAndDecoding {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/58c5577d61aefcf3ff000081/train/java
//        Create two functions to encode and then decode a string using the Rail Fence Cipher.
//        This cipher is used to encode a string by placing each character successively in a diagonal along a set of "rails".
//        First start off moving diagonally and down. When you reach the bottom, reverse direction and move diagonally and up until you reach the top rail.
//        Continue until you reach the end of the string. Each "rail" is then read left to right to derive the encoded string.

//        "WEAREDISCOVEREDFLEEATONCE" = "WECRLTEERDSOEEFEAOCAIVDEN"
//        W       E       C       R       L       T       E
//          E   R   D   S   O   E   E   F   E   A   O   C
//            A       I       V       D       E       N
        String s = "WEAREDISCOVEREDFLEEATONCE";
        int rail = 3;
        System.out.println(encode(s, rail));
    }
    static String encode(String s, int n) {

        char[][] grafo = new char[n][s.length() * 2];
        int lunghezzaRigo = n;
        int lunghezzaStringa = s.length() * 2;
        for(int i = 0; i < lunghezzaRigo; i++){
            for(int j = 0; j < lunghezzaStringa; j++){
                grafo[i][j] = '.';
            }
        }
        stampaGrafo(grafo);
        int j = 0;
        while(j != lunghezzaStringa){

        }




        return null;
    }

    static String decode(String s, int n) {
        // Your code here
        return null;
    }
    public static void stampaGrafo(char[][] grafo){
        for(int i = 0; i < grafo.length; i++){
            for(int j = 0; j < grafo[0].length; j++){
                System.out.print(grafo[i][j] + " ");
            }
            System.out.println();
        }
    }
}
