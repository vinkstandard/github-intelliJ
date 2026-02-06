package LeetCode;

import java.util.*;

public class Leet_ProductsOfArrayExceptSelf {
    public static void main(String[] args) {
        //    https://leetcode.com/problems/product-of-array-except-self/description/

        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})) + " Expected --> " + Arrays.toString(new int[]{24,12,8,6}));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})) + " Expected --> " + Arrays.toString(new int[]{0,0,9,0,0}));
    }
    public static int[] productExceptSelf(int[] nums) {

        int[] ret = new int[nums.length];

        List<Integer> prefissi = new ArrayList<>(), suffissi = new ArrayList<>();
        int prefisso = 1, suffisso = 1;
        prefissi.add(prefisso); suffissi.add(suffisso); // aggiungiamo uno perché a sinistra i[0] non c'è niente, e neanche a destra di i[nums.length - 1]

        for(int i = 0; i < nums.length - 1; i++){
            prefisso *= nums[i];
            prefissi.add(prefisso);
        }
        for(int i = nums.length -1; i > 0; i--){
            suffisso *= nums[i];
            suffissi.add(suffisso);
        }
        suffissi = suffissi.reversed();
        for(int i = 0; i < nums.length; i++){
            ret[i] = (prefissi.get(i) * suffissi.get(i));
        }

        return ret;
    }
}
