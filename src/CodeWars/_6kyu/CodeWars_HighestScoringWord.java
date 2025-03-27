package CodeWars._6kyu;
import java.util.*;

public class CodeWars_HighestScoringWord {
    public static void main(String[] args) {
//    https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/train/java
//        "man i need a taxi up to ubud";  == taxi
//        "what time are we climbing up to the volcano"; == volcano
//        "take me to semynak"; == semynak

        String s = "what time are we climbing up to the volcano";
        String nuova = high(s);
        System.out.println(nuova);
    }

    public static String high(String s) {
        ArrayList<Character> alfabeto = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alfabeto.add(c);
        }
        String[] parole = s.split(" ");
        ArrayList<Integer> valori = new ArrayList<>();
        for (String parola : parole) {
            int valoreStringa = 0;
            for (int i = 0; i < parola.length(); i++) {
                char c = Character.toLowerCase(parola.charAt(i));
                if (alfabeto.contains(c)) {
                    valoreStringa += alfabeto.indexOf(c) + 1;
                }
            }
            valori.add(valoreStringa);
        }
        System.out.println(valori);
        int valoreMaggiore = valori.getFirst();
        for (int n = 1; n < valori.size(); n++) {
            if (valoreMaggiore < valori.get(n)) {
                valoreMaggiore = valori.get(n);
            }
        }
        return parole[valori.indexOf(valoreMaggiore)];
    }
}