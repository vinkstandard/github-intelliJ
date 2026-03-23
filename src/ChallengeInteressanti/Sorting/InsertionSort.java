package ChallengeInteressanti.Sorting;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class InsertionSort {
    static DecimalFormat df = new DecimalFormat();
    public static void main(String[] args) {

        // time complexity O(n²)

        df.setMaximumFractionDigits(9);

        ArrayList<Integer> lista = new ArrayList<>(List.of(12, 11, 13, 5, 6));
        ArrayList<Integer> listaMedia = new ArrayList<>(List.of(
                7, 81, 7, 60, 50, 90, 18, 12, 94, 3, 56, 20, 91, 80, 19, 36, 49, 68,
                88, 2, 27, 13, 75, 54, 23, 15, 38, 69, 83, 63, 55, 53, 51, 46, 93, 21, 84, 35,
                70, 9, 62, 48, 34, 28, 44, 82, 25, 32, 31, 79, 10, 52, 30, 5, 43, 66, 11, 87,
                41, 37, 33, 86, 95, 97, 57, 99, 22, 61, 58, 100, 47, 42, 1, 24, 92, 65, 29, 17,
                64, 76, 89, 4, 73, 16, 39, 72, 59, 96, 26, 74, 85, 78, 71, 6, 77, 14, 98, 40, 45, 8));
        sorta(lista);
        sorta(listaMedia);



    }

    public static void sorta(ArrayList<Integer> lista){
        long inizio = System.nanoTime();
        for (int i = 1; i < lista.size(); i++) {
            int chiave = lista.get(i);
            int j = i - 1;


            while (j >= 0 && lista.get(j) > chiave) {
                lista.set(j + 1, lista.get(j));
                j = j - 1;
            }
            lista.set(j + 1, chiave);
        }
        long fine = System.nanoTime();
        double tempo = (double)(fine - inizio) / 1_000_000_000;

        System.out.println("Numero di elementi: " + lista.size() + " | Tempo: " + df.format(tempo) + " secondi");

        System.out.println(lista);
    }

}
