package CodeWars;
import java.util.*;
public class CodeWars_SumOfIntervals {
    public static void main(String[] args) {

//        https://www.codewars.com/kata/52b7ed099cdc285c300001cd
//        Write a function called sumIntervals/sum_intervals that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.
//
//        Intervals:
//        Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
//
//        Overlapping Intervals
//        List containing overlapping intervals:
//
//       [[1, 4],
//        [7, 10],
//        [3, 5]]
//        The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
//
//        Examples:
//        sumIntervals(
//       [[1, 2],
//        [6, 10],
//        [11, 15]] ) => 9
//
//        sumIntervals(
//       [[1, 4],
//        [7, 10],
//        [3, 5]] ) => 7
//
//        sumIntervals(
//       [[1, 5],
//        [10, 20],
//        [1, 6],
//        [16, 19],
//        [5, 11]] ) => 19
//
//        sumIntervals(
//       [[0, 20],
//        [-100000000, 10],
//        [30, 40]] ) => 100000030
//        Tests with large intervals
//        Your algorithm should be able to handle large intervals. All tested intervals are subsets of the range [-1000000000, 1000000000].

        // casi da provare
        int[][] intervals1 = {{1, 2}, {6, 10}, {11, 15}};
        int[][] intervals2 = {{1, 4}, {7, 10}, {3, 5}};
        int[][] intervals3 = {{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}};
        int[][] intervals4 = {{0, 20}, {-100000000, 10}, {30, 40}};

        // debug
        System.out.println(sumIntervals(intervals1));
        System.out.println(sumIntervals(intervals2));
        System.out.println(sumIntervals(intervals3));
        System.out.println(sumIntervals(intervals4));

    }

    public static int sumIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return 0;
        // ordino in base al valore
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // grazie gpt per questa perla
        // unisco i sovrapposti
        int totalLength = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if (newStart <= end) {
                // se si sovrappongono
                end = Math.max(end, newEnd);
            } else {
                // se non si sovrappongono
                totalLength += end - start;
                start = newStart;
                end = newEnd;
            }
        }
        totalLength += end - start;
        return totalLength;
    }
}