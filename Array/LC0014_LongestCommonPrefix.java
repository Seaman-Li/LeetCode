package Array;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//LeetCode 14 - Longest Common Prefix requires us to find the longest common prefix among an array of strings.

public class LC0014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];// Start with the first word as prefix
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {// Check if prefix matches the beginning,Returns -1 (not found) if it doesn't match and then trim prefix(prefix.length - 1)
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) throws InterruptedException, ExecutionException {
        if (strs == null || strs.length == 0) return "";

        int numThreads = strs.length - 1; // We compare adjacent pairs
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        Future<String>[] futures = new Future[numThreads];

        // Submit parallel tasks to find prefix between adjacent strings
        for (int i = 0; i < numThreads; i++) {
            final int index = i;
            futures[i] = executor.submit(() -> findCommonPrefix(strs[index], strs[index + 1]));
        }

        // Collect results from futures
        String prefix = futures[0].get();  // Start with the first computed result
        for (int i = 1; i < numThreads; i++) {
            if (prefix.isEmpty()) break;  // If prefix becomes empty, exit early
            prefix = findCommonPrefix(prefix, futures[i].get());
        }

        executor.shutdown();  // Shut down executor after processing
        return prefix;
    }

    // Function to find common prefix between two strings
    private String findCommonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLength);
    }

//    Vertical Scanning
//    Compare character by character vertically across all strings.
//    Stop when characters don’t match or reach the end of any string.
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);  // Take the i-th character of the first string
            for (int j = 1; j < strs.length; j++) {
                // If i exceeds the length of a string or characters mismatch, stop
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];  // If loop completes, first word is the prefix
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LC0014_LongestCommonPrefix sol = new LC0014_LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(sol.longestCommonPrefix3(strs));
    }

}
