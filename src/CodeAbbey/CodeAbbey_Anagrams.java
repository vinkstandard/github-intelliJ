package CodeAbbey;

import java.util.*;
import java.io.*;
import java.io.IOException;
public class CodeAbbey_Anagrams {
    public static void main(String[] args) throws IOException {

//        https://www.codeabbey.com/index/task_view/anagrams
//        In many natural languages we can find some pairs of words which could be transformed to each other by changing the order of letters.
//        I.e. they consist of the same set of letters, for example:
//        cat - act take - teak ate - eat - tea
//
//        Such words are called anagrams and as we see in the third example sometimes there are more than two words.
//        Your task is to find out the amount of anagrams for given word by the dictionary.
//        Dictionary file contains a list of english words, one per line. It was taken from Ubuntu linux distribution and stripped of words containing capital letters, apostrophes and non-english letters.
//
//        Input data will contain the number of test-cases in the first line.
//        Next lines will contain a single word each.
//        Answer should contain the number of anagrams for each word (not including the word itself).
//
//        Example:
//
//        input data:
//        3
//        bat
//        coal
//        lots
//
//        answer:
//        1 1 2

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
            if (c >= 'a' && c <= 'z') {
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
