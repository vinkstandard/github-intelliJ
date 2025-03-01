package CodeWars;
import java.util.*;
public class CodeWars_Snail {
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