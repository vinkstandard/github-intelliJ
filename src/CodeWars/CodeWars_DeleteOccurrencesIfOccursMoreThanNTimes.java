package CodeWars;
import java.util.*;

public class CodeWars_DeleteOccurrencesIfOccursMoreThanNTimes {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/554ca54ffa7d91b236000023/train/java

        int[] elements = {1, 2, 3, 1, 2, 1, 2, 3};
        int maxOccurences = 2;
        int[] blabla = deleteNth(elements, maxOccurences);
        System.out.println(Arrays.toString(blabla));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        ArrayList<Integer> contoElementiUsciti = new ArrayList<>();
        ArrayList<Integer> ritorno = new ArrayList<>();

        if (maxOccurrences == 0) {
            return ritorno.stream().mapToInt(Integer::intValue).toArray();
        }
        for (int elemento : elements) {
            if (piazzabile(elemento, maxOccurrences, contoElementiUsciti)) {
                ritorno.add(elemento);
                contoElementiUsciti.add(elemento);
            }
        }
        return ritorno.stream().mapToInt(Integer::intValue).toArray();
    }

    public static boolean piazzabile(int elemento, int maxOccurrences, ArrayList<Integer> contoElementiUsciti) {
        int contoElemento = 0;
        if (contoElementiUsciti.isEmpty()) {
            return true;
        }
        for (int n : contoElementiUsciti) {
            if (n == elemento) {
                contoElemento++;
            }
        }
        return contoElemento < maxOccurrences;
    }
}