package Backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC0046_Permutations {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {

        if(track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return ;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i])
                continue;
            used[i] = true;
            track.addLast(nums[i]);
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        LC0046_Permutations sol = new LC0046_Permutations();
        System.out.println(sol.permute(nums));
    }
}
