package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leet_ContainsDuplicate {
    public static void main(String[] args) {

//        https://leetcode.com/problems/contains-duplicate/

        System.out.println(containsDuplicate(new int[]{1,2,3,1}) + " Expected --> true");
        System.out.println(containsDuplicate(new int[]{1,2,3,4}) + " Expected --> false");
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}) + " Expected --> true");

    }
    public static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}
