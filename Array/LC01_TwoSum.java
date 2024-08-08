package Array;


import java.util.HashMap;
import java.util.Map;




public class LC01_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        // 测试暴力法
        long startBrute = System.nanoTime();
        int[] resultBrute = twoSum(nums, target);
        long endBrute = System.nanoTime();
        System.out.println("Brute Force result: " + resultBrute[0] + ", " + resultBrute[1]);
        System.out.println("Brute Force time: " + (endBrute - startBrute) + " nanoseconds");

        // 测试哈希表法
        long startHash = System.nanoTime();
        int[] resultHash = twoSum_HashMap(nums, target);
        long endHash = System.nanoTime();
        System.out.println("Hash Map result: " + resultHash[0] + ", " + resultHash[1]);
        System.out.println("Hash Map time: " + (endHash - startHash) + " nanoseconds");
    }

    // 暴力法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //hash
    public static int[] twoSum_HashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}



