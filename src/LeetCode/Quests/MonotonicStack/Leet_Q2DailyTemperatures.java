package LeetCode.Quests.MonotonicStack;

import java.util.*;

public class Leet_Q2DailyTemperatures {
    public static void main(String[] args) {

        // https://leetcode.com/problems/daily-temperatures/description/?envType=problem-list-v2&envId=dsa-linear-shoal-monotonic-stack


        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) + " | Expected: " + Arrays.toString(new int[]{1, 1, 4, 2, 1, 1, 0, 0}));

    }
    public static int[] dailyTemperatures(int[] temperatures) {

        // O(n)
        int[] ret = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int prevIndex = stack.pop();
                ret[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ret;
    }
    public int[] vecchiaSoluzione(int[] temperatures) {
        // O(N2)
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            boolean found = false;
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    ret[i] = j - i;
                    found = true;
                    break;
                }
            }
            if(!found){
                ret[i] = 0;
            }
        }
        return ret;
    }
}
