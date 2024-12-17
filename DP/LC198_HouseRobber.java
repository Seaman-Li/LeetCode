package DP;

public class LC198_HouseRobber {
    public static int rob(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 2, 3, 4, 1};
        System.out.println(rob(nums));
    }
}
