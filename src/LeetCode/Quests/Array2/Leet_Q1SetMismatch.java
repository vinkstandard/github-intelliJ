package LeetCode.Quests.Array2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leet_Q1SetMismatch {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})) + " | Expected: " + Arrays.toString(new int[]{2, 3}));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})) + " | Expected: " + Arrays.toString(new int[]{1, 2}));
        System.out.println(Arrays.toString(findErrorNums(new int[]{2, 2})) + " | Expected: " + Arrays.toString(new int[]{2, 1}));
    }

    public static int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int dupeNumber = Integer.MIN_VALUE, perfectSum = nums.length * (nums.length + 1) / 2, partialSum = 0;
        for (int num : nums) {
            if (set.contains(num)) {
                dupeNumber = num;
            } else {
                set.add(num);
                partialSum += num;
            }
        }
        return new int[]{dupeNumber, (perfectSum - partialSum)};
        /*
        Ci ho messo più di quanto mi piace ammettere.
        Avevo letto male la descrizione, pensavo che i valori all'interno dell input fossero casuali, invece hanno una constraint ben precisa:
        "Se l'array ha 3 elementi, il numero maggiore può essere max "3" oppure "2" se il 3 non c'è.
        Quindi maxNum <= arr.length

        Con questa info, otteniamo la somma del NUMERO degli elementi tramite questa formula (nums.length * (nums.length + 1) / 2)
        che è la sintetizzazione di:

        for (int i = 1; i <= lunghezzaArray; i++){
        sommaIpotetica += i;
        }
        ottenuta la somma ipotetica, ci serve sapere la somma degli elementi escluso l'unico elemento duplicato
        con questi due dati, andiamo a fare, somma ipotetica - somma degli elementi, e il risultato sarà il numero mancante
        */
    }
}
