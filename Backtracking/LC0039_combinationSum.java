package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0039_combinationSum {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();// 记录回溯的路径
    int trackSum = 0;    // 记录 track 中的元素之和

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        // 先排序，让相同的元素靠在一起
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return res;
    }

    // 回溯算法主函数
    void backtrack(int[] nums, int start, int target) {
        // base case，达到目标和，找到符合条件的组合
        if(trackSum == target){
            res.add(new LinkedList<>(track));
            return;
        }
        // base case，超过目标和，直接结束
        if(trackSum > target) return;

        for(int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            trackSum += nums[i];
            // 递归遍历下一层回溯树
            backtrack(nums, i, target);
            // 撤销选择
            track.removeLast();
            trackSum -= nums[i];
        }
    }


    public static void main(String[] args) {
        LC0039_combinationSum sol = new LC0039_combinationSum();
        System.out.println(sol.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
