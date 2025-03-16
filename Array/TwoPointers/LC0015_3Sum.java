package Array.TwoPointers;

import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//Notice that the solution set must not contain duplicate triplets.
//Example 1:
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]

public class LC0015_3Sum {

//    Sort the array first.
//    Fix one element (nums[i]), then apply the two-pointer approach to find two numbers that sum to -nums[i].
//    Move inward:
//    If sum < target, move left rightward (left++).
//    If sum > target, move right leftward (right--).
//    If sum == 0, store the triplet and skip duplicates.
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])//Skips duplicate values for the first number (nums[i]). Ensures we don't process the same nums[i] multiple times.
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

//                    Skips duplicate values for the second number (nums[left]) and the third number (nums[right]).
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }

//    Use HashSet to avoid duplicate triplets instead of skipping values.
//    Store pairs in a set instead of manually checking duplicates.
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums); // Step 1: Sort array

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }


    public static void main(String[] args) {
        LC0015_3Sum sol = new LC0015_3Sum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = sol.threeSum(nums);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
