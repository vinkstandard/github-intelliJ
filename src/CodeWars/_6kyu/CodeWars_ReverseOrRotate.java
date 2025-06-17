package CodeWars._6kyu;

public class CodeWars_ReverseOrRotate {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991
//        The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz
//        (ignore the last chunk if its size is less than sz).
//
//        If the sum of a chunk's digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position.
//        Put together these modified chunks and return the result as a string.
//
//        If
//        sz is <= 0 or if str == "" return ""
//        sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
//         Examples:
//        ("123456987654", 6) --> "234561876549"
//        ("123456987653", 6) --> "234561356789"
//        ("66443875", 4) --> "44668753"
//        ("66443875", 8) --> "64438756"
//        ("664438769", 8) --> "67834466"
//        ("123456779", 8) --> "23456771"
//        ("", 8) --> ""
//        ("123456779", 0) --> ""
//        ("563000655734469485", 4) --> "0365065073456944"
//        Example of a string rotated to the left by one position:
//        s = "123456" gives "234561".

        System.out.println("Risultato: (" + revRot("123456987654", 6) + ") Expected: (234561876549)");
        System.out.println("Risultato: (" + revRot("123456779", 8) + ") Expected: (23456771)");
        System.out.println("Risultato: (" + revRot("563000655734469485", 4) + ") Expected: (0365065073456944)");

    }

    public static String revRot(String strng, int sz) {

        if (sz <= 0 || strng.isEmpty() || sz > strng.length()) return "";
        StringBuilder sb = new StringBuilder();
        int lunghezzaStringa = 0;
        while (lunghezzaStringa + sz < strng.length() + 1) {

            String chunk = strng.substring(lunghezzaStringa, sz + lunghezzaStringa);
            char[] numeriChunk = chunk.toCharArray();
            int totale = 0;
            for (char numero : numeriChunk) {
                totale += Character.getNumericValue(numero);
            }
            if (totale % 2 == 0) { // se la somma dei digit è pari, ruotiamo il chunk
                sb.append(new StringBuilder(chunk).reverse());
            } else { // altrimenti il primo carattere diventa l'ultimo, e l'ultimo il primo, "12345" = "52341"
                sb.append(chunk.substring(1)).append(chunk.charAt(0));
            }
            lunghezzaStringa += sz; // passiamo al chunk successivo, se c'è ovviamente
        }

        return sb.toString();
    }
}
