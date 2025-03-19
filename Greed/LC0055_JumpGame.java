package Greed;

//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//Return true if you can reach the last index, or false otherwise.
//Example 1:
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.


public class LC0055_JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {//Since the loop guarantees that maxReach always grows, i > maxReach will never be true unless we are stuck at a 0
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);// Update max reach
            if (maxReach >= nums.length - 1) {// If we reach the last index
                return true;
            }
        }
        return false;//It will never reach the final return true outside the loop
    }


    public boolean canJump2(int[] nums) {
        int goal = nums.length - 1;// Start from the last index
        for (int i = nums.length - 2; i >= 0; i--) {// Iterate from right to left
            if (i + nums[i] >= goal) {// Can reach the goal from this index?
                goal = i;// Move goal to the current position
            }
        }
        return goal == 0;// If goal reaches the first index, return true
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        LC0055_JumpGame sol = new LC0055_JumpGame();

        System.out.println(sol.canJump(nums));
    }


}
