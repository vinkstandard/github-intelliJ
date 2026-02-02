package CodeWars._5kyu;
import java.math.BigInteger;
import java.util.*;

public class CodeWars_StringIncrementer {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/54a91a4883a7de5d7800009c/train/java
        List<String> lista = List.of("foo", "foobar23", "foo0043", "foo9", "foo099", "foobar000", "mostro123213123123123123213");
        for(String elem : lista){
            System.out.println("Risultato: " +incrementString(elem) + "\n");
        }


    }
    public static String incrementString(String str) {
        if (str.isEmpty()) return "1";
        if(!Character.isDigit(str.charAt(str.length() - 1))) return str + "1";
        if(str.charAt(str.length() - 1) == '0'){
            StringBuilder sb = new StringBuilder(str);
            return sb.replace(sb.length() - 1, sb.length(), "1").toString();
        }
        System.out.println("Parte numerica: " + getParteNumerica(str));

        String parteNumerica = getParteNumerica(str), numeroZeri = parteNumerica.replaceAll("[1-9]", ""), testo = str.replaceAll("[1-9-0]", "");

        BigInteger numero = new BigInteger(getParteNumerica(str));
        BigInteger risultato = numero.add(BigInteger.ONE);
        String numeroIncrementato = risultato.toString();


        StringBuilder nuovoNum = new StringBuilder();
        if(numeroIncrementato.length() > numero.toString().length()){
            nuovoNum.append(testo);
            nuovoNum.append(numeroZeri.replaceFirst("0", ""));
            nuovoNum.append(numeroIncrementato);
        } else {
            nuovoNum.append(testo).append(numeroZeri).append(numeroIncrementato);
        }


        return nuovoNum.toString();
    }
    public static String getParteNumerica(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i > 0; i--){
            if(Character.isDigit(str.charAt(i))){
             sb.append(str.charAt(i));
            } else{
                break;
            }
        }
        return sb.reverse().toString();

    }
}
