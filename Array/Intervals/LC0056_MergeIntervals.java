package Array.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC0056_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            // If result is empty or no overlap, just add the interval
            if(res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]){// The end of the last merged interval is less than the start of the current interval → so, no overlap.
                res.add(interval);
            }else {
                // Overlapping intervals: merge by updating the end
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }

        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        LC0056_MergeIntervals sol = new LC0056_MergeIntervals();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = sol.merge(intervals);
        System.out.println(Arrays.deepToString(res));
    }
}
