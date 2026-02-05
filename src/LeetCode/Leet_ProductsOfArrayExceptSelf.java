package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

public class Leet_ProductsOfArrayExceptSelf {
    public static void main(String[] args) {
        //    https://leetcode.com/problems/product-of-array-except-self/description/


        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})) + " Expected --> " + Arrays.toString(new int[]{24,12,8,6}));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})) + " Expected --> " + Arrays.toString(new int[]{0,0,9,0,0}));
    }
    public static int[] productExceptSelf(int[] nums) {

        // fallisce per il tempo limite, la logica è giusta però
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            List<Integer> lista = Arrays.stream(nums).boxed().toList();
            int totale = 1;
            for(int j = 0; j < lista.size(); j++){
                if(j == i) continue;
                totale *= lista.get(j);
            }
            ret[i] = totale;
        }
        return ret;
    }
}
