package Array.TwoPointers;

//The main difference between LeetCode 1 (Two Sum) and LeetCode 167 (Two Sum II - Input Array Is Sorted)
//is that LeetCode 167 guarantees a sorted array, which allows us to use the two-pointer approach for an efficient O(n) solution.
//It's better for Leetcode 1 to use HashMap

import java.util.HashMap;

public class LC0167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Convert to 1-based index
            }else if (sum < target) {// Increase sum
                left++;
            }else {// Decrease sum
                right--;
            }
        }
        return new int[]{-1, -1};// Should never be reached due to problem constraints
    }

    public int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement) + 1, i + 1}; // 1-based index
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1}; // Should never be reached due to problem constraints
    }

    public static void main(String[] args) {
        LC0167_TwoSumII solution = new LC0167_TwoSumII();
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
