package LeetCode;

import java.util.Arrays;

public class Leet_TwoSum {
    public static void main(String[] args) {

//        https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)) + " Expected --> " + Arrays.toString(new int[]{1,2}));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 3, 4}, 6)) + " Expected --> " + Arrays.toString(new int[]{1,3}));
        System.out.println(Arrays.toString(twoSum(new int[]{-1,0}, -1)) + " Expected --> " + Arrays.toString(new int[]{1,2}));
    }
    public static int[] twoSum(int[] numbers, int target) {

//        bruteforce, crasha per il tempo
//        for(int i = 0; i < nums.length; i++){
//            for(int j = 0; j < nums.length; j++){
//                if(i == j){
//                    continue;
//                }
//                if(nums[i] + nums[j] == target){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;

        // algoritmo two pointers, con 1ms di runtime
        int somma = Integer.MIN_VALUE, min = 0, max = numbers.length - 1;
        while(somma != target){
            System.out.println("Sinistra: " + numbers[min] + "\tDestra: " + numbers[max]);
            somma = numbers[min] + numbers[max];
            if(somma > target){
                max--;
            } else {
                min++;
            }
        }
        return new int[]{min, max + 1};
    }
}
