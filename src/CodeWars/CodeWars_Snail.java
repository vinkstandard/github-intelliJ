package CodeWars;
import java.util.*;
public class CodeWars_Snail {
    public static void main(String[] args) {
//        https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1
//        Snail Sort
//        Given an n x n array, return the array elements arranged from outermost elements to the middle element, traveling clockwise.
//
//        array = [[1,2,3],
//                 [4,5,6],
//                 [7,8,9]]
//        snail(array) #=> [1,2,3,6,9,8,7,4,5]
//
//        For better understanding, please follow the numbers of the next array consecutively:
//        array = [[1,2,3],
//                 [8,9,4],
//                 [7,6,5]]
//        snail(array) #=> [1,2,3,4,5,6,7,8,9]
//
//        NOTE: The idea is not sort the elements from the lowest value to the highest;
//        the idea is to traverse the 2-d array in a clockwise snailshell pattern.
//
//        NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(snail(array)));
    }
    public static int[] snail(int[][] array) {
        int top = 0, bottom = array.length - 1;
        int left = 0, right = array[0].length - 1;
        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // da sinistra a destra
            for (int i = left; i <= right; i++) {
                result.add(array[top][i]);
            }
            top++;
            // dal sopra a sotto
            for (int i = top; i <= bottom; i++) {
                result.add(array[i][right]);
            }
            right--;
            // da destra a sinistra, se ancora ci sono righe
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(array[bottom][i]);
                }
                bottom--;
            }
            // da sotto a sopra, se ancora ci sono righe
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(array[i][left]);
                }
                left++;
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}