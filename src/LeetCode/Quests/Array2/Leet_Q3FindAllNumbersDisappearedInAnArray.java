package LeetCode.Quests.Array2;


import java.util.ArrayList;
import java.util.List;

public class Leet_Q3FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {

        // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?envType=problem-list-v2&envId=dsa-linear-shoal-array-ii
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}) + " | Expected: [5,6]");
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        boolean[] flags = new boolean[nums.length + 1];
        for (int num : nums) {
            flags[num] = true;
        }
        for (int i = 1; i < flags.length; i++) {
            if (!flags[i]) ret.add(i);
        }
        return ret;
        // per nerdarci un po' in piu, leet consiglia di pensare a una soluzione che non usi spazio extra(nel mio caso l'array di booleani), hell no.
        // 3ms
    }
}
//    List<Integer> ret = new ArrayList<>();
//    List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
//        Collections.sort(list);
//        for(int i = 1; i <= nums.length; i++){
//        if(list.get(i - 1) != i && !list.contains(i)) ret.add(i);
//    }
//        return ret;
// troppo lento O(n2)
