package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

public class Leet_NextGreaterElement {
    public static void main(String[] args) {

        // https://leetcode.com/problems/next-greater-element-i/

        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})) + " | Expected: " + Arrays.toString(new int[]{-1, 3, -1}));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // O(N + M)
        int[] ret = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for(int i = 0; i < nums1.length; i++){
            ret[i] = map.getOrDefault(nums1[i], -1);

        }
        return ret;
    }
    public static int[] vecchiaSoluzione(int[] nums1, int[] nums2) {

        // O(N1 * N2)
        int[] ret = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        for(int i = 0; i < nums1.length; i++){
            boolean flag = false;
            int startingIndex = map.get(nums1[i]);
            for(int j = startingIndex + 1; j < nums2.length; j++){
                if(nums1[i] < nums2[j]){
                    flag = true;
                    ret[i] = nums2[j];
                    break;
                }
            }
            if(!flag){
                ret[i] = -1;
            }
        }
        return ret;
    }
}

