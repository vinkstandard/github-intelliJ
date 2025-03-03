package CodeWars;
import java.util.*;
public class CodeWars_SumOfIntervals {
    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // ordino in base al valore
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
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
    public static void main(String[] args) {
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
}
