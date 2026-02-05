package LeetCode;

import java.util.*;

public class Leet_TopKFrequentElements {
    public static void main(String[] args) {

//        https://leetcode.com/problems/top-k-frequent-elements/
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)) + " Expected --> " + Arrays.toString(new int[]{1, 2}));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2)) + " Expected --> " + Arrays.toString(new int[]{1, 2}));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1}, 1)) + " Expected --> " + Arrays.toString(new int[]{1}));
        System.out.println(Arrays.toString(topKFrequent(new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6},
                10)) + " Expected --> " + Arrays.toString(new int[]{1,2,5,3,6,7,4,8,10,11}));


    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> mappa = new HashMap<>();
        for(int n : nums){
            mappa.computeIfAbsent(n, chiave -> 0);
            mappa.computeIfPresent(n, (chiave, v) -> v + 1);
        }
        List<Integer> ret = new ArrayList<>();

        while(ret.size() != k) {
            int max = 0, chiave = 0;
            for (Map.Entry<Integer, Integer> entry : mappa.entrySet()) {
                if(entry.getValue() > max){
                    max = entry.getValue();
                    chiave = entry.getKey();
                }
            }
            ret.add(chiave);
            mappa.remove(chiave);
        }

        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}


