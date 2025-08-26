package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leet_ZigzagConversion {
    public static void main(String[] args) {
//    https://leetcode.com/problems/zigzag-conversion/description/
//    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
//    (you may want to display this pattern in a fixed font for better legibility)
//
//    P   A   H   N
//    A P L S I I G
//    Y   I   R
//    And then read line by line: "PAHNAPLSIIGYIR"

//    Example 1:
//    Input: s = "PAYPALISHIRING", numRows = 3
//    Output: "PAHNAPLSIIGYIR"

//    Example 2:
//    Input: s = "PAYPALISHIRING", numRows = 4
//    Output: "PINALSIGYAHRPI"
//    Explanation:
//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I

//    Example 3:
//    Input: s = "A", numRows = 1
//    Output: "A"
//
//    Constraints:
//    1 <= s.length <= 1000
//    s consists of English letters (lower-case and upper-case), ',' and '.'.
//    1 <= numRows <= 1000

        System.out.println("CASO 1:\n" + convert("PAYPALISHIRING", 3) + "\nPAHNAPLSIIGYIR  <-- EXPECTED\n");
        System.out.println("CASO 2:\n" + convert("PAYPALISHIRING", 4) + "\nPINALSIGYAHRPI  <-- EXPECTED\n");
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;
        List<StringBuilder> righe = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            righe.add(new StringBuilder()); // tanti sb quante sono le righe
        }
        int rigaAttuale = 0;
        boolean scendendo = false;
        for (char c : s.toCharArray()) {
            righe.get(rigaAttuale).append(c);
            if (rigaAttuale == 0 || rigaAttuale == numRows - 1) {  // check per cambio di direzione quando raggiungo la cima o il fondo
                scendendo = !scendendo; // se siamo in cima, o in fondo, invertiamo la flag
            }
            if (scendendo) {
                rigaAttuale++;
            } else {
                rigaAttuale--;
            }
        }
        StringBuilder risultato = new StringBuilder();
        for (StringBuilder riga : righe) {
            risultato.append(riga);
        }
        return risultato.toString();
    }
}
