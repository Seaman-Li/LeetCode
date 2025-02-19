package Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC0078_subset {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();// 记录回溯算法的递归路径

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));// 前序位置，每个节点的值都是一个子集
//        start 参数决定了每次递归时，从输入数组中可以选择的起始索引。在每一层递归中，for 循环从 start 开始遍历，确保当前递归只能选择未被处理的元素。结果：所有子集的生成路径是基于排列顺序的，避免了重复的组合。
        //i是集合元素的数量
        for(int i = start; i < nums.length; i++) {
            track.add(nums[i]);// 选择当前元素
            backtrack(nums, i + 1); // 递归进入下一层，从下一个索引开始选择
            track.removeLast();// 回溯，撤销选择
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LC0078_subset sol = new LC0078_subset();
        System.out.println(sol.subsets(nums));
    }

}
