package DP;

import java.util.Arrays;

public class LC0303_NumArray {
    private int[] sum;

    public LC0303_NumArray(int[] nums) {
        sum = new int[nums.length + 1]; // sum[0] = 0
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 5, 6, 7};
        LC0303_NumArray numArray = new LC0303_NumArray(nums);
        System.out.println( Arrays.toString(numArray.sum) );
        System.out.println(numArray.sumRange(0, 2));
    }


}


