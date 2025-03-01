package CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
public class CodeWars_ArrayDifference {
    public static int[] arrayDiff(int[] a, int[] b) {
        ArrayList<Integer> primo = new ArrayList<>(Arrays.stream(a).boxed().toList()); // convertire i due array in arraylist
        ArrayList<Integer> secondo = new ArrayList<>(Arrays.stream(b).boxed().toList()); // per accedere alla funzione .contains()
        ArrayList<Integer> buono = new ArrayList<>();
        for(int num : primo){
            if(!secondo.contains(num)){
                buono.add(num);
            }
        }
        return buono.stream().mapToInt(Integer::intValue).toArray();
    }
}
