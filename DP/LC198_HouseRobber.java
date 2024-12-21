package DP;

public class LC198_HouseRobber {

//    对于第 i 个房子，小偷有两个选择：
//
//    ①不偷第 i 个房子，那么他能偷到的最大金额就是到第 i-1 个房子为止的最大金额，即 dp[i-1]。
//    ②偷第 i 个房子，那么他不能偷第 i-1 个房子，所以他能偷到的最大金额是第 i 个房子里的金额加上到第 i-2 个房子为止的最大金额，即 nums[i] + dp[i-2]。
//    因此，状态转移方程为：
//    dp[i] = max(dp[i-1], nums[i] + (i >= 2 ? dp[i-2] : 0))

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

//    由于每一步的 dp 值只依赖于前两个值 (dp[i-1] 和 dp[i-2])，我们可以用两个变量来存储这些值而不是使用整个数组，从而将空间复杂度从 O(n) 降低到 O(1)。
    public static int rob2(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main(String[] args){
        int[] nums = {0, 1, 2, 3, 4, 1};
        System.out.println(rob2(nums));
    }
}
