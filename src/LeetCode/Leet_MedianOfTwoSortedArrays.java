package LeetCode;
import java.util.*;

public class Leet_MedianOfTwoSortedArrays {
    public static void main(String[] args) {

//        Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//        The overall run time complexity should be O(log (m+n)).
//
//        Example 1:
//        Input: nums1 = [1,3], nums2 = [2]
//        Output: 2.00000
//        Explanation: merged array = [1,2,3] and median is 2.

//        Example 2:
//        Input: nums1 = [1,2], nums2 = [3,4]
//        Output: 2.50000
//        Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // all'inizio pensavo volesse la media aritmetica, invece vuole la mediana.
        // unisco le liste e le metto in ordine crescente, poi se il numeri degli elementi è dispari la media è l'elemento centrale, altrimenti
        // se sono pari, la media è la somma dei 2 elementi centrali / 2
        List<Integer> numeri = new ArrayList<>();
        for(int n : nums1){
            numeri.add(n);
        }
        for(int n : nums2){
            numeri.add(n);
        }
        Collections.sort(numeri);
        if(numeri.size() % 2 == 0){
            int centro = numeri.size() / 2;
            return (double)(numeri.get(centro) + numeri.get(centro - 1)) / 2;
        }else{
            return (double) numeri.get(numeri.size() / 2);
        }
    }
}
