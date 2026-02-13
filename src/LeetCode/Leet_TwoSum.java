package LeetCode;

import java.util.Arrays;

public class Leet_TwoSum {
    public static void main(String[] args) {

//        https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//        Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//        You can return the answer in any order.
//
//        Example 1:
//
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        Example 3:
//
//        Input: nums = [3,3], target = 6
//        Output: [0,1]
//
//
//        Constraints:
//
//        2 <= nums.length <= 104
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109
//        Only one valid answer exists.

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
