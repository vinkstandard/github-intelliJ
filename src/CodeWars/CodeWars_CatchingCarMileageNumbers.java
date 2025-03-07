package CodeWars;
import java.util.*;
public class CodeWars_CatchingCarMileageNumbers {
    public static void main(String[] args) {

        // https://www.codewars.com/kata/52c4dd683bfd3b434c000292/train/java
        int[] awesomePhrases = {1337, 256};
        int numero = 1234;
        int risultato = isInteresting(numero,awesomePhrases);
        System.out.println(risultato);
    }
    public static int isInteresting(int number, int[] awesomePhrases) {


        String numero = String.valueOf(number);
        ArrayList<String> frasi = new ArrayList<>();
        for (int n : awesomePhrases) {
            frasi.add(String.valueOf(n));
        }
        int tentativo = 0;
        boolean numeroInteressante = false;

        // se è miniore di 3 cifre e non lo può diventare con un +2
        if(number <= 97){
            System.out.println("minore di 98");
            return 0;
        }

        cercando:
        while(tentativo <= 2){

            // check frasi
            if(!frasi.isEmpty()){
                if(frasi.contains(numero)){
                    System.out.println("E' NELLE FRASI");
                    numeroInteressante = true;
                    break cercando;
                }
            }
            // check palindromo
            StringBuilder sb = new StringBuilder(numero);
            if(numero.contentEquals(sb.reverse())){
                numeroInteressante = true;
                System.out.println("E' PALINDROMO");
                break cercando;
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
                break cercando;
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
                break cercando;
            }

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
                break cercando;
            }


        }










        return 0;
    }
}
