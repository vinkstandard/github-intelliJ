package LeetCode;

import java.util.*;

public class Leet_DailyTemperatures {
    public static void main(String[] args) {
//        https://leetcode.com/problems/daily-temperatures/description/
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) + " Expected --> " + Arrays.toString(new int[]{1, 1, 4, 2, 1, 1, 0, 0}));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})) + " Expected --> " + Arrays.toString(new int[]{1, 1, 1, 0}));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})) + " Expected --> " + Arrays.toString(new int[]{1, 1, 0}));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{2, 1, 1, 3})) + " Expected --> " + Arrays.toString(new int[]{3, 2, 1, 0}));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int vecchioIndice = stack.pop();
                ret[vecchioIndice] = i - vecchioIndice;
            }
            stack.push(i);
        }
        return ret;
    }
}
