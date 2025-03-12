package CodeWars;

import java.util.*;

public class CodeWars_SortTheOdd {
    public static void main(String[] args) {
//        [7, 1]  =>  [1, 7]
//        [5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
//        [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
//        https://www.codewars.com/kata/578aa45ee9fd15ff4600090d
        int[]nums = {5, 8, 6, 3, 4};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
    public static int[] sortArray(int[] array) {

        ArrayList<Integer> dispari = new ArrayList<>();
        for(int n : array){
            if(n % 2 != 0){
                dispari.add(n);
            }
        }
        Collections.sort(dispari);
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                array[i] = dispari.getFirst();
                dispari.removeFirst();
            }
        }
        return array;
    }
}
