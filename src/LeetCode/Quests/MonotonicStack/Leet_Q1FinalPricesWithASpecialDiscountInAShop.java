package LeetCode.Quests.MonotonicStack;

import java.util.Arrays;
public class Leet_Q1FinalPricesWithASpecialDiscountInAShop {
    public static void main(String[] args) {

        // https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/?envType=problem-list-v2&envId=dsa-linear-shoal-monotonic-stack
        System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})) + " | Expected: " + Arrays.toString(new int[]{4, 2, 4, 2, 3}));
    }

    public static int[] finalPrices(int[] prices) {


        int[] ret = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            boolean found = false;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] <= prices[i]){
                    ret[i] = prices[i] - prices[j];
                    found = true;
                    break;
                }
            }
            if(!found){
                ret[i] = prices[i];
            }
        }
        return ret;
    }
}
