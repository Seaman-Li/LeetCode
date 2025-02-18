package Array.TwoPointers;

public class LC0027_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0; // 慢指针

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast]; // 将非 val 元素移动到前面
                slow++;                 // 慢指针前进
            }
        }
        return slow; // slow 表示新数组的长度
    }

    public static void main(String[] args) {
        LC0027_RemoveElement removeElement = new LC0027_RemoveElement();
        int[] nums = {3,2,2,3};
        System.out.println(removeElement.removeElement(nums, 2));
    }
}
