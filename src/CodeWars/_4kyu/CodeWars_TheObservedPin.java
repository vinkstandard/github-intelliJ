package CodeWars._4kyu;

import java.util.*;

public class CodeWars_TheObservedPin {
    public static void main(String[] args) {
        // https://www.codewars.com/kata/5263c6999e0f40dee200059d/train/java

        Map<String, List<String>> map = new HashMap<>() {{
            put("8", Arrays.asList("5", "7", "8", "9", "0"));
            put("11", Arrays.asList("11", "21", "41", "12", "22", "42", "14", "24", "44"));
        }};
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(getPINs(entry.getKey()) + " | Expected: " + entry.getValue());
        }
    }
    /*

    1 2 3
    4 5 6
    7 8 9
      0

     */
    public static List<String> getPINs(String observed) {
        Map<Character, List<String>> map = new HashMap<>() {{
            put('1', Arrays.asList("1", "2", "4"));
            put('2', Arrays.asList("1", "2", "3", "5"));
            put('3', Arrays.asList("2", "3", "6"));
            put('4', Arrays.asList("1", "4", "5", "7"));
            put('5', Arrays.asList("2", "4", "5", "6", "8"));
            put('6', Arrays.asList("3", "5", "6", "9"));
            put('7', Arrays.asList("4", "7", "8"));
            put('8', Arrays.asList("5", "7", "8", "9", "0"));
            put('9', Arrays.asList("6", "8", "9"));
            put('0', Arrays.asList("0", "8"));

        }};
        List<String> accumulator = List.of("");
        for (char digit : observed.toCharArray()) {
            List<String> currentNumVariations = map.get(digit);
            List<String> newAccumulator = new ArrayList<>();
            for (String s : accumulator) {
                for (String variation : currentNumVariations) {
                    newAccumulator.add(s + variation);
                }
            }
            accumulator = newAccumulator;
        }
        return accumulator;
    }
}
