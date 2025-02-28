package Array.Intervals;

import java.util.ArrayList;
import java.util.List;
//Initialize start = nums[0] (first element).
//Loop through nums, checking if nums[i] != nums[i-1] + 1:
//If consecutive, continue.
//If not consecutive, add "start->end" to res.
//Update start to the new number.
//After the loop, add the last range.
public class LC0228_SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1] + 1){//not consecutive, add "start->end" to res.
                res.add(formatRange(start, nums[i - 1]));
                start = nums[i];// Start a new range
            }
        }
        // Add the last range
        res.add(formatRange(start, nums[nums.length-1]));
        return res;
    }

    private String formatRange(int start, int end) {
        return start == end ? String.valueOf(start) : start + "->" + end;
    }


    public static void main(String[] args) {
        LC0228_SummaryRanges s = new LC0228_SummaryRanges();
        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
