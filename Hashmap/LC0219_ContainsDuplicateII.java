package Hashmap;

import java.util.HashMap;
import java.util.Map;


//Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
//Example 1:
//Input: nums = [1,2,3,1], k = 3
//Output: true

public class LC0219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (map.containsKey(val) && i-map.get(val)<=k) {
                return true;
            }
            map.put(val,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        LC0219_ContainsDuplicateII solution = new LC0219_ContainsDuplicateII();
        System.out.println(solution.containsNearbyDuplicate(nums, 3));
    }
}
