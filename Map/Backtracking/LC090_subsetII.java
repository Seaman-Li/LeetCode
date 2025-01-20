package Map.Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC090_subsetII {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));// 前序位置，每个节点的值都是一个子集

        for(int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);// 选择当前元素
            backtrack(nums, i + 1); // 递归进入下一层，从下一个索引开始选择
            track.removeLast();// 回溯，撤销选择
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        LC090_subsetII sol = new LC090_subsetII();
        System.out.println(sol.subsetsWithDup(nums));
    }
}
