import java.util.*;
import java.io.*;
import java.io.IOException;
public class CodeAbbey_Anagrams {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        File file = new File("C:\\Users\\Mary\\Desktop\\testiJava\\words.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        ArrayList<String> dizionario = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            if (!st.isEmpty()) {
                dizionario.add(st);
            }
        }
        System.out.println("Quanti anagrammi vuoi cercare?");
        int numeroRicerca = scanner.nextInt();
        scanner.nextLine();
        for (int m = 0; m < numeroRicerca; m++) {
            String test = scanner.next();
            int[] lettereContate = contaLettere(test);
            int conto = 0;
            for (String parola : dizionario) {
                if (parola.length() != test.length()) { // gli anagrammi devono avere la stessa lunghezza
                    continue;
                }
                if (parola.equals(test)) {
                    continue;
                }
                int[] lettereConfronto = contaLettere(parola);
                if (Arrays.equals(lettereContate, lettereConfronto)) {
                    conto++;
                    System.out.println("Anagramma trovato: " + parola);
                }
            }
            System.out.println("Numero totale di anagrammi trovati: " + conto);
        }
    }

    public static int[] contaLettere(String s) {

        int[] alfabeto = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c >= 'a' && c <= 'z') {  // c >= 'a' && c <= 'z' è solo un check per controllare se si tratta di lettere o no, sempre utilizzando l'ASCII code delle lettere
                alfabeto[c - 'a']++;
            }
        }
//        la lettera 'a' ha un valore numerico specifico in ASCII: 97
//
//        supponiamo di avere un carattere c = 'c'  il suo valore in ASCII è 99
//
//        se facciamo c - 'a', stiamo in realtà facendo questa operazione matematica: 99 - 97 = 2
//
//        quindi otteniamo 2, che corrisponde alla posizione della lettera 'c' nell'alfabeto (0 per 'a', 1 per 'b', 2 per 'c', etc.etc.).
        return alfabeto;
    }
}
