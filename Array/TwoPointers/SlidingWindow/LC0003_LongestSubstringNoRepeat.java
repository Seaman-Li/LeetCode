package Array.TwoPointers.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LC0003_LongestSubstringNoRepeat {
//    Use a HashSet to track unique characters in the window.
//    Move right pointer to expand the window.
//    If a duplicate is found, move left pointer until no duplicates remain.
//    Update maxLen with the maximum window size found.

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));// Remove leftmost character to maintain uniqueness
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LC0003_LongestSubstringNoRepeat sol = new LC0003_LongestSubstringNoRepeat();
        System.out.println(sol.lengthOfLongestSubstring(s));
    }
}
