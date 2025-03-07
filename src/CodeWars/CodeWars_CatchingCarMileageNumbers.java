package CodeWars;
import java.util.*;

public class CodeWars_CatchingCarMileageNumbers {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java
        int[] awesomePhrases = {1337, 256};
        int numero = 1590;
        System.out.println("NUMERO:" + numero);
        int risultato = isInteresting(numero, awesomePhrases);
        System.out.println(risultato);
    }

    public static int isInteresting(int number, int[] awesomePhrases) {


        ArrayList<String> frasi = new ArrayList<>();
        for (int n : awesomePhrases) {
            frasi.add(String.valueOf(n));
        }

        boolean numeroInteressante = false;

        // se è miniore di 3 cifre e non lo può diventare con un +2
        if (number <= 97) {
            return 0;
        }
        int tentativo = 0;
        while (tentativo < 3) {

            if (number == 98 || number == 99) {
                number++;
                tentativo++;
            }

            String numero = String.valueOf(number);
            // check frasi
            if (!frasi.isEmpty()) {
                if (frasi.contains(numero)) {
                    numeroInteressante = true;
                    break;
                }
            }
            // check palindromo
            StringBuilder sb = new StringBuilder(String.valueOf(number));
            if (numero.contentEquals(sb.reverse())) {
                numeroInteressante = true;
                break;
            }

            // se contiene solo zeri
            boolean soloZero = true;
            for (int i = 1; i < numero.length(); i++) {
                if (numero.charAt(i) != '0') {
                    soloZero = false;
                    break;
                }
            }
            if (soloZero) {
                numeroInteressante = true;
                break;
            }

            // se contiene tutti numeri uguali (forse è inutile dato che il palindromo check fa la stessa cosa)
            char primoNumero = numero.charAt(0);
            boolean tuttiUguali = true;
            for (int i = 1; i < numero.length(); i++) {
                if (primoNumero != numero.charAt(i)) {
                    tuttiUguali = false;
                    break;
                }
            }
            if (tuttiUguali) {
                numeroInteressante = true;
                break;
            }

//            se è in ordine crescente
            boolean ordineCrescente = true;
            for (int i = 1; i < numero.length(); i++) {
                int dietro = Integer.parseInt(String.valueOf(numero.charAt(i - 1)));
                int corrente = Integer.parseInt(String.valueOf(numero.charAt(i)));
                if (corrente == 0 && dietro != 9) {
                    ordineCrescente = false;
                    break;
                }
                if (corrente == 0 && dietro == 9) {
                    continue;
                }
                if (corrente - dietro != 1) {
                    ordineCrescente = false;
                    break;
                }
            }
            if (ordineCrescente) {
                numeroInteressante = true;
                break;
            }

//            se è in ordine decrescente
            boolean ordineDecrescente = true;
            for (int i = 1; i < numero.length(); i++) {
                int dietro = Integer.parseInt(String.valueOf(numero.charAt(i - 1)));
                int corrente = Integer.parseInt(String.valueOf(numero.charAt(i)));
                if (corrente == 0 && dietro != 1) {
                    ordineDecrescente = false;
                    break;
                }
                if (dietro - corrente != 1) {
                    ordineDecrescente = false;
                    break;
                }

            }
            if (ordineDecrescente) {
                numeroInteressante = true;
                break;
            }
            number++;
            tentativo++;
        }
        if (tentativo == 0 && numeroInteressante) {
            return 2; // vittoria al primo tentativo
        }
        if (tentativo > 0 && numeroInteressante) {
            return 1; // vittoria in max 2 tentativi
        }
        return 0;
    }
}
