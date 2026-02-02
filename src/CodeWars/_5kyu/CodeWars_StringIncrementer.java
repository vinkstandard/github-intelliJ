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
        System.out.println("Big test\nRisultato:\n" + incrementString("SG#OiW~*ZP288Kn0[R2038303947819371546") + "\nSG#OiW~*ZP288Kn0[R2038303947819371547  PREVISTO");

    }
    public static String incrementString(String str) {
        if (str.isEmpty()) return "1";
        if (!Character.isDigit(str.charAt(str.length() - 1))) return str + "1";
        if (str.charAt(str.length() - 1) == '0') return str.substring(0,str.length() - 1) + "1";

        int inizioParteNumerica = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(str.charAt(i))) {
                inizioParteNumerica = i + 1;
                break;
            }
        }
        String parteNumerica = str.substring(inizioParteNumerica), parteTesto = str.substring(0, inizioParteNumerica);
        System.out.println("\nSubs: " + parteNumerica + "\tParte non numerica: " + parteTesto);

        StringBuilder zeroIniziali = new StringBuilder();
        for (char c : parteNumerica.toCharArray()) {
            if (c == '0') {
                zeroIniziali.append("0");
            } else {
                break;
            }
        }

        BigInteger numero = new BigInteger(parteNumerica);
        BigInteger risultato = numero.add(BigInteger.ONE);
        String numeroIncrementato = risultato.toString();
        StringBuilder nuovoNum = new StringBuilder();

        if (numeroIncrementato.length() > numero.toString().length()) {
            if (zeroIniziali.isEmpty()) {
                nuovoNum.append(parteTesto).append(numeroIncrementato);
            } else {
                nuovoNum.append(parteTesto).append(zeroIniziali.deleteCharAt(zeroIniziali.length() - 1)).append(numeroIncrementato);
            }
        } else {
            nuovoNum.append(parteTesto).append(zeroIniziali).append(numeroIncrementato);
        }

        return nuovoNum.toString();
    }
}
