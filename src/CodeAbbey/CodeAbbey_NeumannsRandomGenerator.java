package CodeAbbey;
import java.util.*;

public class CodeAbbey_NeumannsRandomGenerator {
    public static void main(String[] args) {

        int numeroBlock = 4100, conto = 0;
        int numero = 4100;
        ArrayList<Integer> numeri = new ArrayList<>();

        while(!numeri.contains(numeroBlock)){
            int n = numero * numero;
            String numeroConv = String.valueOf(n);
            String numeroC = " ";
            for(int i = 2; i < 6; i++){
                numeroC += numeroConv.charAt(i);
            }
            if(numeroConv.length() < 8){
                for(int i = numeroConv.length(); i < 8; i++){
                    numeroConv = numeroConv + "0";
                }
            }
            int numeroConvertito = Integer.parseInt(numeroC.trim());
            System.out.println(numeroConvertito);
            numeri.add(numeroConvertito);
            numero = numeroConvertito;
            conto++;
        }
        System.out.println(conto);
    }
}
