package LeetCode;

import java.util.*;
import java.util.stream.Collectors;


public class Leet_TopKFrequentElements {
    public static void main(String[] args) {

//        https://leetcode.com/problems/top-k-frequent-elements/
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)) + " Expected --> " + Arrays.toString(new int[]{1, 2}));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)) + " Expected --> " + Arrays.toString(new int[]{1, 2}));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)) + " Expected --> " + Arrays.toString(new int[]{1}));


    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> mappa = new HashMap<>();
        for (int n : nums) {
            mappa.computeIfPresent(n, (chiave, v) -> v - 1);
            mappa.computeIfAbsent(n, v -> 1);
        }
        return null;
        // da finire
    }
}


