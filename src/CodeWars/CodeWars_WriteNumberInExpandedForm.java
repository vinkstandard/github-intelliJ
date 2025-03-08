package CodeWars;
import java.util.*;
public class CodeWars_WriteNumberInExpandedForm {
    public static void main(String[] args) {

//       https://www.codewars.com/kata/5842df8ccbd22792a4000245/java
//       12 --> "10 + 2"
//       45 --> "40 + 5"
//       70304 --> "70000 + 300 + 4"
        int n = 2345543;
        System.out.println(expandedForm(n));
    }
    public static String expandedForm(int num) {
        ArrayList<String> numeri = new ArrayList<>();
        String numero = String.valueOf(num);
        int progressione = 0;

        while(progressione != numero.length()){

            StringBuilder sb = new StringBuilder();
            // check prima posizione
            if (progressione == 0) {
                if (numero.charAt(0) != '0') {
                    sb.append(numero.charAt(0));
                    while (sb.length() != numero.length()) {
                        sb.append("0");
                    }
                    numeri.add(sb.toString());
                }
            }
            // check per il resto delle posizioni
            if(progressione > 0){
                String stringaSplit = numero.substring(progressione);
                if (stringaSplit.charAt(0) != '0') {
                    sb.append(stringaSplit.charAt(0));
                    while(sb.length() != numero.length() - progressione){
                        sb.append("0");
                    }
                    numeri.add(sb.toString());
                }
            }
            progressione++;
        }
        StringBuilder sbb = new StringBuilder();
        for(String s : numeri){
            sbb.append(s).append(" + ");
        }
        sbb.deleteCharAt(sbb.length()-1); // rimuove lo spazio
        sbb.deleteCharAt(sbb.length()-1); // rimuove il +
        return sbb.toString();
    }
}
