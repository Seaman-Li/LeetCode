package Greed;


//Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
//A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
//A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
//Example 3:
//Input: nums = [-3,-2,-3]
//Output: -2
//Explanation: Subarray [-2] has maximum sum -2.

public class LC0918_MaxSubarrayCircular {
    //The maximum circular subarray is either:
    //A normal subarray, without wrapping (use Kadane’s algorithm)
    //A circular subarray, which means:
    //total sum of array - minimum subarray sum (the part we skip in the middle)
    //Use Kadane's Algorithm to find:
    //maxSum = max subarray sum (standard way)
    //minSum = min subarray sum
    //totalSum = sum of the entire array

    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxSum = nums[0], curMax = 0;
        int minSum = nums[0], curMin = 0;

        for(int num: nums){
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            total += num;
        }
        // If all numbers are negative, total == minSum → return maxSum
        return maxSum > 0? Math.max(maxSum, total - minSum) : maxSum;
    }

    public static void main(String[] args) {
        LC0918_MaxSubarrayCircular solution = new LC0918_MaxSubarrayCircular();
        int[] nums = {-3,-2,-3};
        int[] nums2 = {5,-3,5};
        System.out.println(solution.maxSubarraySumCircular(nums2));
    }

}
