package ChallengeInteressanti.Sorting;

import java.util.*;
public class SelectionSort {
    public static void main(String[] args) {


        ArrayList<Integer> lista = new ArrayList<>(List.of(
                7, 81, 7, 60, 50, 90, 18, 12, 94, 3, 56, 20, 91, 80, 19, 36, 49, 68,
                88, 2, 27, 13, 75, 54, 23, 15, 38, 69, 83, 63, 55, 53, 51, 46, 93, 21, 84, 35,
                70, 9, 62, 48, 34, 28, 44, 82, 25, 32, 31, 79, 10, 52, 30, 5, 43, 66, 11, 87,
                41, 37, 33, 86, 95, 97, 57, 99, 22, 61, 58, 100, 47, 42, 1, 24, 92, 65, 29, 17,
                64, 76, 89, 4, 73, 16, 39, 72, 59, 96, 26, 74, 85, 78, 71, 6, 77, 14, 98, 40, 45, 8));

        long inizio = System.nanoTime();
        List<Integer> listaOrdinata = new ArrayList<>();

        while (!lista.isEmpty()) {
            int min = Collections.min(lista), indiceDaRimuovere = lista.indexOf(min);
            lista.remove(indiceDaRimuovere);
            listaOrdinata.add(min);
        }

        long fine = System.nanoTime();
        System.out.println("Tempo: " + (fine - inizio) / 1_000_000_000_000.0 + " secondi");

    }

}
