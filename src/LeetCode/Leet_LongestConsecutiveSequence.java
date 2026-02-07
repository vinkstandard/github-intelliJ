package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Leet_LongestConsecutiveSequence {
    public static void main(String[] args) {

        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}) + " Expected --> 4");
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}) + " Expected --> 9");
        System.out.println(longestConsecutive(new int[]{1, 2, 6, 7, 8}) + " Expected --> 3");

    }

    public static int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int lunghezzaMax = 0;
        for (int n : set) {
            int lunghezzaAttuale = 1;

            // cerchiamo i numeri che possono iniziare una sequenza, un numero N non può essere un inizio di sequenza se esiste N - 1 nell'array
            if (!set.contains(n - 1)) {
                int incremento = 1;
                while (set.contains(n + incremento)) {
                    lunghezzaAttuale++;
                    incremento++;
                }
            }
            if (lunghezzaAttuale > lunghezzaMax) lunghezzaMax = lunghezzaAttuale;

        }
        return lunghezzaMax;

    }
}
