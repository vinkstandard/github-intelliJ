package LeetCode.Quests.Stack;

import java.util.ArrayList;
import java.util.List;

public class Leet_Q1BuildAnArrayWithStackOperations {
    public static void main(String[] args) {
        // https://leetcode.com/problems/build-an-array-with-stack-operations/description/?envType=problem-list-v2&envId=dsa-linear-shoal-stack

        System.out.println(buildArray(new int[]{1, 3}, 3) + " | Expected: " + List.of("Push", "Push", "Pop", "Push"));
        System.out.println(buildArray(new int[]{1, 2, 3}, 3) + " | Expected: " + List.of("Push", "Push", "Push"));
        System.out.println(buildArray(new int[]{1, 2}, 4) + " | Expected: " + List.of("Push", "Push"));
    }

    public static List<String> buildArray(int[] target, int n) {

        List<String> ret = new ArrayList<>();
        int currentIndex = 0;
        for (int i = 1; i <= n; i++) {
            if(currentIndex == target.length) break;
            if (target[currentIndex] == i) {
                ret.add("Push");
                currentIndex++;
            } else {
                ret.add("Push");
                ret.add("Pop");
            }
        }
        return ret;
    }
}
