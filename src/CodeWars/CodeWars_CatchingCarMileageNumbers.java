package CodeWars;
import java.util.*;
public class CodeWars_CatchingCarMileageNumbers {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java
        int[] awesomePhrases = {1337, 256};
        int numero = 11207;
        int risultato = isInteresting(numero,awesomePhrases);
        System.out.println(risultato);
    }
    public static int isInteresting(int number, int[] awesomePhrases) {


        ArrayList<String> frasi = new ArrayList<>();
        for (int n : awesomePhrases) {
            frasi.add(String.valueOf(n));
        }

        boolean numeroInteressante = false;

        // se è miniore di 3 cifre e non lo può diventare con un +2
        if(number <= 97){
            System.out.println("minore di 98");
            return 0;
        }
        int tentativo = 0;
        int incrementoDiUno = 1;

        while(tentativo < 3){
            int numeroDaControllare = number + tentativo; // Usa una variabile separata
            String numero = String.valueOf(numeroDaControllare);
            // check frasi
            if(!frasi.isEmpty()){
                if(frasi.contains(numero)){
                    System.out.println("E' NELLE FRASI");
                    numeroInteressante = true;
                    break;
                }
            }
            // check palindromo
            StringBuilder sb = new StringBuilder(String.valueOf(number));
            if(numero.contentEquals(sb.reverse())){
                numeroInteressante = true;
                System.out.println("E' PALINDROMO");
                break;
            }

            // se contiene solo zeri
            boolean soloZero = true;
            for(int i = 1; i < numero.length(); i++){
                if(numero.charAt(i) != '0'){
                    soloZero = false;
                    break;
                }
            }
            if(soloZero){
                System.out.println("SOLO ZERO");
                numeroInteressante = true;
                break;
            }

            // se contiene tutti numeri uguali (forse è inutile dato che il palindromo check fa la stessa cosa)
            char primoNumero = numero.charAt(0);
            boolean tuttiUguali = true;
            for(int i = 1; i < numero.length(); i++){
                if(primoNumero != numero.charAt(i)){
                    tuttiUguali= false;
                    break;
                }
            }
            if(tuttiUguali){
                System.out.println("TUTTI UGUALI");
                numeroInteressante = true;
                break;
            }

//            se è in ordine crescente
            int numeroUno = Integer.parseInt(String.valueOf(primoNumero));
            boolean ordineCrescente = true;
            for(int i = 1; i < numero.length(); i++){
                if(numeroUno > Integer.parseInt(String.valueOf(numero.charAt(i)))){
                    ordineCrescente = false;
                    break;
                }
                numeroUno = Integer.parseInt(String.valueOf(numero.charAt(i)));
            }
            if(ordineCrescente){
                System.out.println("ORDINE CRESCENTE");
                numeroInteressante = true;
                break;
            }

//            se è in ordine decrescente
            numeroUno = Integer.parseInt(String.valueOf(primoNumero)); // reset
            boolean ordineDecrescente = true;
            for(int i = 1; i < numero.length(); i++){
                if(numeroUno < Integer.parseInt(String.valueOf(numero.charAt(i)))){
                    ordineDecrescente = false;
                    break;
                }
                numeroUno = Integer.parseInt(String.valueOf(numero.charAt(i)));
            }
            if(ordineDecrescente){
                System.out.println("ORDINE DECRESCENTE");
                numeroInteressante = true;
                break;
            }
            tentativo++;
        }

        if(tentativo == 0 && numeroInteressante){
            return 2; // vittoria al primo tentativo
        }
        if(tentativo > 0 && numeroInteressante){
            return 1; // vittoria in max 2 tentativi
        }
        return 0;
    }
}
