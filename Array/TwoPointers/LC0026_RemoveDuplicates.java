package Array.TwoPointers;

public class LC0026_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0; // 慢指针，指向去重后的最后一个元素

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;               // 扩展去重后的区域
                nums[slow] = nums[fast]; // 将新的不重复元素放入正确位置
            }
        }
        return slow + 1; // 数组长度为索引 + 1
    }

    public static void main(String[] args) {
        LC0026_RemoveDuplicates lc = new LC0026_RemoveDuplicates();
        int[] nums = {1, 1, 2, 2, 3, 3, 4};
        System.out.println(lc.removeDuplicates(nums));
    }

}
