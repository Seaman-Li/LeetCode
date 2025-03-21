package Backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//Example 1:
//Input: nums = [1,1,2]
//Output:
//        [[1,1,2],
//        [1,2,1],
//        [2,1,1]]
public class LC0047_PermutationsII {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);  // Sort to handle duplicates
        backtrack(nums);
        return res;
    }

    public void backtrack(int[] nums){
        if(track.size() == nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i])
                continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1])// we only use the first 1 unless the previous one is used, preventing us from re-choosing the same element in the same recursive branch.
                continue;
            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            used[i] = false;
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        LC0047_PermutationsII sol = new LC0047_PermutationsII();
        sol.permuteUnique(nums);
        for(List<Integer> list : sol.res){
            System.out.println(list);
        }
    }

}
