package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC413_ArithmeticSlices {
//    dp[2] = 1
//            [0, 1, 2]
//    dp[3] = dp[2] + 1 = 2
//            [0, 1, 2, 3], // [0, 1, 2] 之后加一个 3
//            [1, 2, 3]     // 新的递增子区间
//    dp[4] = dp[3] + 1 = 3
//            [0, 1, 2, 3, 4], // [0, 1, 2, 3] 之后加一个 4
//            [1, 2, 3, 4],    // [1, 2, 3] 之后加一个 4
//            [2, 3, 4]        // 新的递增子区间
//    定义状态：令 dp[i] 表示以第i 个元素为结尾的等差子数组的数量。
//    状态转移方程：如果 nums[i] - nums[i-1] == nums[i-1] - nums[i-2]（即当前三个元素构成等差数列），则：
//    dp[i]=dp[i−1]+1
//    dp[i-1] 表示以 nums[i-1] 为结尾的等差子数组数量。
//    加 1 是因为新加入的 nums[i] 和前两个元素 nums[i-1]、nums[i-2] 构成了新的等差子数组。
//    否则：dp[i]=0
//    总计结果：最终答案是所有 dp[i] 的总和。
//    初始条件：对于数组的前两个元素，无法构成等差子数组，因此：
//    dp[0]=dp[1]=0
    public static int numberOfArithmeticSlices(int[] nums){
        if(nums.length < 3) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int total = 0;

        for(int i = 2; i < n; i++){
            if( nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                dp[i] = dp[i - 1] + 1;
                System.out.println("i: "+i+"  "+"dp[i]: "+dp[i]);
                total += dp[i];
            }
        }
        return total;
    }

//    二维数组结构：
//    使用一个列表（List<int[]>）来保存所有的等差子数组。
//    每个等差子数组用一个长度为 2 的数组表示，分别保存等差子数组的起点和终点的索引。
//    检测等差子数组：
//
//    如果当前三个元素构成等差数列，就保存当前等差子数组的起点和终点。
//    构造二维数组：
//
//    遍历过程中，将每个找到的等差子数组的起点和终点记录到列表中。
    public static int numberOfArithmeticSlices2(int[] nums){
        if(nums.length < 3) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        int total = 0;
        int current = 0;
        List<int[] > arithmeticSlices = new ArrayList<>();

        for(int i = 2; i < n; i++){
            if( nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]){
                current += 1; // 当前以 nums[i] 结尾的等差子数组数量
                total += current;
                // 保存等差子数组
                for (int k = 0; k < current; k++) {
                    arithmeticSlices.add(new int[]{i - 2 - k, i});
                }
            }else{
                current = 0;
            }
        }
        //print start and end indices of arithmeticSlices
        for(int[] arr : arithmeticSlices){
            System.out.println(Arrays.toString(arr));
        }

        return total;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(nums));
    }

}
