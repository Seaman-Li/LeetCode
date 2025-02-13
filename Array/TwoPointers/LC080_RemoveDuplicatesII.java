package Array.TwoPointers;

public class LC080_RemoveDuplicatesII {
//    题目描述： 给定一个 有序数组 nums，要求 原地 删除重复项，使得每个元素最多 出现两次，并返回新数组的长度。
//    要求：
//    不使用额外的空间，空间复杂度O(1)
//    元素的相对顺序 保持不变。


//    使用 快指针 fast 遍历数组。
//    使用 慢指针 slow 记录去重后的数组位置。
//    nums[fast] 只有在 它和 slow-2 位置的元素不同时，才放入 nums[slow]，否则跳过。
//    为什么是 slow-2？
//    因为允许最多 保留 2 个相同元素，如果 nums[fast] == nums[slow-2]，说明出现了 超过 2 次，应该跳过。


//    fast：遍历整个数组
//    slow：标记去重后数组的最后一个元素，slow 只会在发现 新元素或合法的重复元素 时才前进。
//    slow-2：检查是否已超过两次，slow-2 指向当前可保留的元素的前两位。如果 nums[fast] == nums[slow-2]，说明 fast 遍历到的是第三个相同的元素，跳过。


    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int slow = 2;
        for (int fast = 2; fast < nums.length; fast++) {
             if(nums[fast] != nums[slow - 2]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        LC080_RemoveDuplicatesII sol = new LC080_RemoveDuplicatesII();
        System.out.println(sol.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
