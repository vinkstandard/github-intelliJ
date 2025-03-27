package CodeWars._4kyu;
import java.util.*;

public class CodeWars_MostFrequentlyUsedWordsInAText {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/51e056fe544cf36c410000fb/train/java
        // ho dovuto scrivere i test case così, perché ci sono diverse eccezioni.

        ArrayList<String> casi = new ArrayList<>();
        casi.add("a a a  b  c c  d d d d  e e e e e e e e e ddd ddd ddd: ddd ddd aa aa aa, bb cc cc e e e"); // RISULTATO: [e, ddd, d]
        casi.add("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"); // RISULTATO: [e, ddd, aa]
        casi.add("e e e e ddd ddd ddd: ddd ddd aa aa aa, bb cc cc e e e"); // RISULTATO: [e, ddd, aa]
        casi.add("  wont won't won't"); // RISULTATO: [won't, wont]
        casi.add("'a 'a 'a' a'a' a'a'"); // RISULTATO: ['a, a'a', 'a']
        casi.add("   '  "); // RISULTATO: []
        casi.add("   '''  "); // RISULTATO: []
        casi.add(" ''b '','','','' ' '.''B, x''x"); // RISULTATO: [''b, x''x]

        for (String s : casi) {
            List<String> lista = top3(s);
            System.out.println("PAROLA: " + s + "  RISULTATO: " + lista);
        }
    }

    public static List<String> top3(String s) {
        if (s.isEmpty()) {return Collections.emptyList();}

        String cleanText = s.replaceAll("[^a-zA-Z' ]", " ").toLowerCase(); // rimuove tutto quello che non è una lettera(e l'apostrofo) e abbassa tutto a lowercase
        String[] paroleSeparate = cleanText.split("\\s+");
        HashMap<String, Integer> mappa = new HashMap<>();

        // inizio a popolare la mappa
        for (String parola : paroleSeparate) {
            if (!contieneLettere(parola)) {
                continue;
            } // nel caso in cui il primo carattere della stringa è uno spazio oppure non contiene neanche una lettera
            if (!mappa.containsKey(parola)) {
                mappa.put(parola, 1);
            } else {
                mappa.put(parola, mappa.get(parola) + 1);
            }
        }
        // copiamo la mappa in una list, per accedere alla funzione .sort(Map.Entry.comparingByValue()); che ordina la mappa in base ai valori, in ordine crescente
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(mappa.entrySet());
        lista.sort(Map.Entry.comparingByValue());
        List<String> top = new ArrayList<>();

        // scorriamo la mappa al contrario(da destra a sinistra)
        for (int i = lista.size() - 1; i >= 0; i--) {
            Map.Entry<String, Integer> entry = lista.get(i);
            String key = entry.getKey();
            top.add(key);
            if (top.size() == 3) { // se abbiamo 3 elementi, abbiamo quindi la nostra top 3, ci fermiamo
                break;
            }
        }
        return top;
    }

    public static boolean contieneLettere(String parola) {
        for (int i = 0; i < parola.length(); i++) {
            if (Character.isAlphabetic(parola.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
