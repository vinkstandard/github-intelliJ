package LeetCode;
import java.util.*;

public class Leet_DailyTemperatures {
    public static void main(String[] args) {
//        https://leetcode.com/problems/daily-temperatures/description/
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})) + " Expected --> " + Arrays.toString(new int[]{1,1,4,2,1,1,0,0}));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,40,50,60})) + " Expected --> " + Arrays.toString(new int[]{1,1,1,0}));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})) + " Expected --> " + Arrays.toString(new int[]{1,1,0}));
    }
    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        List<Integer> lista = new ArrayList<>();

        for(int n : temperatures){
            if(stack.isEmpty() || stack.peek() < n){
                stack.push(n);
            } else {


            }
        }
        return null;
    }
}
