package CodeWars;

public class CodeWars_AddingBigNumbers {
    public static void main(String[] args) {
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
