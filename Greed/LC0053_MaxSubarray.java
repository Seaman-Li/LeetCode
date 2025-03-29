package Greed;

public class LC0053_MaxSubarray {

//    Kadane’s Algorithm (Greedy / Dynamic Programming)
//    We scan the array and keep track of:
//    currentSum: maximum sum ending at the current position
//    maxSum: global max found so far
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
//            If currentSum + nums[i] >= nums[i] →
//            ✅ Extend the current subarray (add nums[i] to currentSum)
//            If currentSum + nums[i] < nums[i] →
//            ❌ Abandon the current subarray —
//            🔁 Start a new subarray from nums[i] instead

            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LC0053_MaxSubarray sol = new LC0053_MaxSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(sol.maxSubArray(nums));
    }

}
