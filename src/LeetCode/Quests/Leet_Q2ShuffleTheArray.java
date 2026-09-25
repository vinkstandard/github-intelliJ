package LeetCode.Quests;

import java.util.Arrays;

public class Leet_Q2ShuffleTheArray {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)) + " | Expected: " + Arrays.toString(new int[]{2, 3, 5, 4, 1, 7}));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] newArr = new int[n * 2];
        for(int k = 0, i = 0, j = n; k < (n * 2); j++, i++){
            newArr[k++] = nums[i];
            newArr[k++] = nums[j];
        }
        return newArr;
        // O(N)
    }
}
