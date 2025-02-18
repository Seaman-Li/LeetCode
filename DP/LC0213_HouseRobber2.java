package DP;

//由于房屋呈环形排列，问题可以分解为两个子问题：
//不偷第一个房子（从第二个房子到最后一个房子），求能偷到的最大金额。
//不偷最后一个房子（从第一个房子到倒数第二个房子），求能偷到的最大金额。
//然后，从这两个子问题中的解中选择最大的一个。

public class LC0213_HouseRobber2 {
    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    private static int rob(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
