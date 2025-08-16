package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Leet_SearchInsertPosition {
    public static void main(String[] args) {
//        https://leetcode.com/problems/search-insert-position/description/
//        Given a sorted array of distinct integers and a target value, return the index if the target is found.
//        If not, return the index where it would be if it were inserted in order.
//        You must write an algorithm with O(log n) runtime complexity.
//
//        Example 1:
//
//        Input: nums = [1,3,5,6], target = 5
//        Output: 2
//        Example 2:
//
//        Input: nums = [1,3,5,6], target = 2
//        Output: 1
//        Example 3:
//
//        Input: nums = [1,3,5,6], target = 7
//        Output: 4
//
//
//        Constraints:
//
//        1 <= nums.length <= 104
//        -104 <= nums[i] <= 104
//        nums contains distinct values sorted in ascending order.
//        -104 <= target <= 104

        System.out.println("Testacase 1: " + searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println("Testacase 2: " + searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println("Testacase 3: " + searchInsert(new int[]{1,3,5,6}, 7));
    }
    public static int searchInsert(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        if(list.contains(target)) return list.indexOf(target);
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > target){
                return i;
            }
        }
        return list.size();
    }
}
