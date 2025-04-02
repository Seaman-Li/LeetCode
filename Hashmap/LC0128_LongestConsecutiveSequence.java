package Hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            // Only start counting if num is the beginning of a sequence,in other words, find the minimum num
            if (!set.contains(num - 1)) {
                int currNum = num;
                int count = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LC0128_LongestConsecutiveSequence solution = new LC0128_LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }

}
