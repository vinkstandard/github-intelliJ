package CodeWars._4kyu;
import java.util.*;
import java.math.BigInteger;
public class CodeWars_StringIncrementer {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/54a91a4883a7de5d7800009c
//        Your job is to write a function which increments a string, to create a new string.
//        If the string already ends with a number, the number should be incremented by 1.
//        If the string does not end with a number. the number 1 should be appended to the new string.
//        Examples:

//        foo -> foo1
//
//        foobar23 -> foobar24
//
//        foo0042 -> foo0043
//
//        foo9 -> foo10
//
//        foo099 -> foo100

//        foo000 -> foo001

//        TH7C00531186083868581986599
//        String s = "qRQc`ZX=Fc{~g~:Y}L00000000000000526516850603957344743";
//        non funziona con una stringa come ">a;MmesQi$^I8r{$#/wDy0000000000000035197936982565672774821" dove ci sono numeri prima della parte numerica. tocca riscrivere di nuovo.
        String s = "foobar99";
        System.out.println(incrementString(s));

    }
    public static String incrementString(String str) {

        // se non c'è un numero alla fine
        if(!Character.isDigit(str.charAt(str.length() - 1))){
            return str + "1";
        }
        // se il numero alla fine è '0'
        if(str.charAt(str.length() - 1) == '0'){
            StringBuilder bs = new StringBuilder(str);
            bs.replace(bs.length()-1, bs.length(), "1" );
            return bs.toString();
        }
        BigInteger bg1 = BigInteger.ONE;
        StringBuilder parteNonNumerica = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        // scorro fino a trovare la fine della parte numerica
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                parteNonNumerica.append(c);
            }
        }
        String numeroDaIncrementare = sb.reverse().toString();
        System.out.println(numeroDaIncrementare + " lunghezza: " + numeroDaIncrementare.length());

        // ottengo un numero senza gli zeri all'inizio e salvo gli zeri in un'altra variabile
        String numeroSenzaZeri = "";
        StringBuilder zeri = new StringBuilder();

        for(int i = 0; i < numeroDaIncrementare.length(); i++){
            char c = numeroDaIncrementare.charAt(i);
            if(c == '0'){
                zeri.append(c);
            }else{
                numeroSenzaZeri += numeroDaIncrementare.substring(i);
                break;
            }
        }
        System.out.println(numeroSenzaZeri);
        BigInteger bg2 = new BigInteger(numeroSenzaZeri);
        BigInteger bg3 = bg2.add(bg1);
        System.out.println("Nuovo num: " +bg3);
        System.out.println("Nuovo parte non numerica: " +parteNonNumerica);
        String nuovoNumero = String.valueOf(bg3);

        // se il +1 non cambia la lunghezza del numero
        if(nuovoNumero.length() == numeroSenzaZeri.length()){
            StringBuilder finale = new StringBuilder();
            finale.append(parteNonNumerica.reverse()).append(zeri).append(nuovoNumero);
            System.out.println("FINALE: " + finale);
            return finale.toString();
        }
        if(nuovoNumero.length() > numeroSenzaZeri.length()){
            StringBuilder finale = new StringBuilder();
            if(zeri.isEmpty()){
             finale.append(parteNonNumerica.reverse()).append(nuovoNumero);
             return finale.toString();
            }
            else{
                int differenzaLunghezza = nuovoNumero.length() - numeroSenzaZeri.length();
                for(int i = 0; i < differenzaLunghezza; i++ ){
                    zeri.deleteCharAt(0);
                }
                finale.append(parteNonNumerica.reverse()).append(zeri).append(nuovoNumero);
                return finale.toString();
            }
        }

        return null;
}

//        vecchia logica
//
//    public static String incrementString(String str) {
//        System.out.println(str);
//        if(!str.matches(".*\\d$")){
//            return str + "1";
//        }
//
//        StringBuilder soloNumero = new StringBuilder();
//        int fineNum = 0;
//        int lunghezzaStringa = str.length();
//        for(int i = lunghezzaStringa - 1; i >= 0; i--){
//            char c = str.charAt(i);
//            if(Character.isDigit(c)){
//                soloNumero.append(c);
//            }else{
//                fineNum = i + 1;
//                break;
//            }
//        }
//        System.out.println(soloNumero);
//        BigInteger bg1 = BigInteger.ONE;
//        BigInteger bg2 = new BigInteger(soloNumero.toString());
//        BigInteger somma = bg2.add(bg1);
//        soloNumero = new StringBuilder(String.valueOf(somma));
//        System.out.println(somma);
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < str.length(); i++){
//            if(i == fineNum){
//                sb.append(soloNumero);
//                break;
//            }
//            sb.append(str.charAt(i));
//        }
//        System.out.println(sb);
//        return sb.toString();
//
//    }
}
