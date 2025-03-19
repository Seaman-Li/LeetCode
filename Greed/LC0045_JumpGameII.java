package Greed;

import java.util.Arrays;


//You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:0 <= j <= nums[i] and
//i + j < n
//Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
//Example 1:
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

//nums[i] → Maximum jump length from index i.
public class LC0045_JumpGameII {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//the minimum number of jumps needed to reach index i.
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Start at index 0, no jumps needededfrwwes3
        for (int i = 0; i < n; i++) {//Iterate through the array, and for each index i, check all possible jumps (nums[i]) that can reach future positions.
            for(int j = 1; j<=nums[i] && i+j<n; j++){//Can we jump j steps? (We cannot jump beyond nums[i]) Is the jump within bounds? (Avoid jumping beyond the array size)
                dp[i+j] = Math.min(dp[i+j],dp[i]+1);//Update dp[j] = min(dp[j], dp[i] + 1) for all reachable positions j = i + 1 to i + nums[i].
            }
        }
        return dp[n - 1];
    }


//    Track jumps, current reach, and next farthest reach.
//    Iterate through nums and expand reach.
//    When i reaches currentReach, we must jump and update currentReach.
    public int jump2(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int jumps = 0;// Total jumps taken
        int currentReach = 0;//The maximum index we can reach before making another jump.
        int maxReach = 0;//The maximum index we could reach if we decide to jump.
        for (int i = 0; i < nums.length-1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == currentReach){//currentReach tells us how far we can go before needing a jump.
                jumps++;//i == currentReach, it means we've reached the end of our jump range, so we must jump again.
                currentReach = maxReach;//We then update currentReach = maxReach, which gives us the new maximum range after the jump.
            }

        }
        return jumps;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        LC0045_JumpGameII sol = new LC0045_JumpGameII();
        System.out.println(sol.jump(nums));
    }
}
