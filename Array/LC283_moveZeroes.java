package Array;

import java.util.Arrays;

public class LC283_moveZeroes {
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) { // 先把所有非0的数移到前一个0的位置
            if(nums[i] != 0) nums[j++] = nums[i];
        }
        for (int i = j; i < nums.length; i++) { // 后面几位全部赋值为0
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
