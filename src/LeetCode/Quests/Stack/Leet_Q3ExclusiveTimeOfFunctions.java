package LeetCode.Quests.Stack;

import java.util.*;

public class Leet_Q3ExclusiveTimeOfFunctions {
    public static void main(String[] args) {

        // https://leetcode.com/problems/exclusive-time-of-functions/description/?envType=problem-list-v2&envId=dsa-linear-shoal-stack
        System.out.println(Arrays.toString(exclusiveTime(2, List.of("0:start:0","1:start:2","1:end:5","0:end:6"))));

        // fn 0, inizia/finisce, timestamp
        // 0:start:0
    }
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n == 0 || logs == null || logs.isEmpty()) {
            return result;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] logParts = log.split(":");
            int curTime = Integer.parseInt(logParts[2]);

            if ("start".equals(logParts[1])) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += curTime - prevTime;
                }
                stack.push(Integer.parseInt(logParts[0]));
                prevTime = curTime;
            } else {
                result[stack.pop()] += curTime - prevTime + 1;
                prevTime = curTime + 1;
            }
        }
        return result;
    }

}
