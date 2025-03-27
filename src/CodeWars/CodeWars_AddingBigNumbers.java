package CodeWars;

public class CodeWars_AddingBigNumbers {
    public static void main(String[] args) {


//        https://www.codewars.com/kata/525f4206b73515bffb000b21
//        We need to sum big numbers and we require your help.
//        Write a function that returns the sum of two numbers. The input numbers are strings and the function must return a string.
//        Example
//        add("123", "321"); -> "444"
//        add("11", "99");   -> "110"
//        Notes
//        The input numbers are big.
//        The input is a string of only digits
//        The numbers are positives
//
//        La difficoltà sta nel fatto che l'uso del BigInteger è vietato
        String a = "90938498237058927340892374089";
        String b = "123456789";
        String risultato = add(a,b);
        System.out.println(risultato);
    }

    public static String add(String a, String b) {

        StringBuilder risultato = new StringBuilder();
        int riporto = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        // sommare da destra a sinistra
        while (i >= 0 || j >= 0 || riporto > 0) {
            int digitA = (i >= 0) ? a.charAt(i) - '0' : 0;
            int digitB = (j >= 0) ? b.charAt(j) - '0' : 0;

            int somma = digitA + digitB + riporto;
            risultato.append(somma % 10); // aggiunge il numero senza il riporto
            riporto = somma / 10; // aggiorna il riporto

            i--;
            j--;
        }
        // se ci sono 0 all'inizio, li rimuovo
        while (risultato.length() > 1 && risultato.charAt(risultato.length() - 1) == '0') {
            risultato.deleteCharAt(risultato.length() - 1);
        }
        return risultato.reverse().toString(); // inverto il risultato, dato che è al contrario
    }

}
