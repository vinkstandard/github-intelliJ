package CodeWars._4kyu;
import java.util.*;
public class CodeWars_RomanNumeralsHelper {
    public static void main(String[] args) {

//        // https://www.codewars.com/kata/51b66044bce5799a7f000003/java
//        Write two functions that convert a roman numeral to and from an integer value. Multiple roman numeral values will be tested for each function.
//
//        Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. In Roman numerals:
//
//        1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC
//        2008 is written as 2000=MM, 8=VIII; or MMVIII
//        1666 uses each Roman symbol in descending order: MDCLXVI.
//        Input range : 1 <= n < 4000
//
//        In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").
//        Examples

//        to roman:
//        2000 -> "MM"
//        1666 -> "MDCLXVI"
//        86 -> "LXXXVI"
//        1 -> "I"
//
//        from roman:
//        "MM"      -> 2000
//        "MDCLXVI" -> 1666
//        "LXXXVI"  ->   86
//        "I"       ->    1
//        Help
//      +--------+-------+
//      | Symbol | Value |
//      +--------+-------+
//      |    M   |  1000 |
//      |   CM   |   900 |
//      |    D   |   500 |
//      |   CD   |   400 |
//      |    C   |   100 |
//      |   XC   |    90 |
//      |    L   |    50 |
//      |   XL   |    40 |
//      |    X   |    10 |
//      |   IX   |     9 |
//      |    V   |     5 |
//      |   IV   |     4 |
//      |    I   |     1 |
//      +--------+-------+

        int num = 1666; // == "MDCLXVI"
        String roman = "MDCLXVI"; // == 1666;
        System.out.println(toRoman(num));
        System.out.println(fromRoman(roman));
    }
    public static String toRoman(int n) {
        int[] valori = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simboli = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder risultato = new StringBuilder();
        for (int i = 0; i < valori.length; i++) {
            while (n >= valori[i]) {
                risultato.append(simboli[i]);
                n -= valori[i];
            }
        }
        return risultato.toString();
    }

    public static int fromRoman(String romanNumeral) {
        // mappa con simboli, in teoria funziona in range da 1 a 3999
        Map<Character, Integer> valori = new HashMap<>();
        valori.put('I', 1);
        valori.put('V', 5);
        valori.put('X', 10);
        valori.put('L', 50);
        valori.put('C', 100);
        valori.put('D', 500);
        valori.put('M', 1000);

        int risultato = 0;
        int valorePrecedente = 0;
//        "MDCLXVI"
        // da destra a sinistra
        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            int valoreCorrente = valori.get(romanNumeral.charAt(i));

            // se valoreCorrente è minore di quello precedente, lo sottraiamo
            if (valoreCorrente < valorePrecedente) {
                risultato -= valoreCorrente;
            } else {
                risultato += valoreCorrente;
            }
            valorePrecedente = valoreCorrente;
        }
        return risultato;
    }
}
