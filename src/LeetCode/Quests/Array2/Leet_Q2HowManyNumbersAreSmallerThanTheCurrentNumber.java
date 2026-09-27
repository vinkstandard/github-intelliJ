package LeetCode.Quests.Array2;

import java.util.Arrays;

public class Leet_Q2HowManyNumbersAreSmallerThanTheCurrentNumber {
    public static void main(String[] args) {
       // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/?envType=problem-list-v2&envId=dsa-linear-shoal-array-ii

        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})) + " | Expected: " + Arrays.toString(new int[]{4, 0, 1, 1, 3}));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[nums.length];
        int[] count = new int[101]; // 0 - 100
        for(int num : nums){
            count[num]++;
        }
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                ret[i] = 0;
            } else {
                ret[i] = count[nums[i] - 1];
            }
        }
        return ret;
    }

//    int[] ret = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//        int counter = 0;
//        for(int j = 0; j < nums.length; j++){
//            if(j == i) continue;
//            if(nums[j] < nums[i]) counter++;
//        }
//        ret[i] = counter;
//    }
//        return ret;
    // 10 ms
}
