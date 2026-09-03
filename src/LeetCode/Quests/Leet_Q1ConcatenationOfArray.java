package LeetCode.Quests;

import java.util.Arrays;

public class Leet_Q1ConcatenationOfArray {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 3, 2, 1})));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] combined = Arrays.copyOf(nums, nums.length * 2);
        System.arraycopy(nums, 0, combined, nums.length, nums.length);
        return combined;
    }
}
