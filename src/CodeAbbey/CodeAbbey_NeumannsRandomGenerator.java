package CodeAbbey;
import java.util.*;

public class CodeAbbey_NeumannsRandomGenerator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int conto = 0; conto < n; conto++){
            int numeroIterazioni = 1;
            List<String> numeriUsciti = new ArrayList<>();
            int numero = scanner.nextInt();
            numeriUsciti.add(String.valueOf(numero));

            while(true){
                numero *= numero;
                String numeroStringa = String.valueOf(numero);

                // se tocca aggiungere gli zeri all'inizio
                if(numeroStringa.length() < 8){
                    int differenza = 8 - numeroStringa.length();
                    numeroStringa = "0".repeat(differenza) + numeroStringa;
                }

                numeroStringa = "" + numeroStringa.charAt(2) + numeroStringa.charAt(3) + numeroStringa.charAt(4) + numeroStringa.charAt(5);

                if(numeriUsciti.contains(numeroStringa)){
                    System.out.println(numeroIterazioni + " ");
                    break;
                } else {
                    numeriUsciti.add(numeroStringa);
                    numero = Integer.parseInt(numeroStringa);
                    numeroIterazioni++;
                }
            }
        }

    }
}
