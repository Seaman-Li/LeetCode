package Array.BinarySearch;

public class LC704_BinarySearch {
    // 标准的二分搜索框架，搜索目标元素的索引，若不存在则返回 -1


//    (left + right) / 2 可能溢出.当 left 和 right 都很大时，left + right 可能会超过 int 的最大值 2^31 - 1，导致 整数溢出（overflow）。在 Java 中，int 溢出会变成负数，导致错误的索引计算。
//    left + (right - left) / 2 不会溢出。right - left 先计算，不会超过 int 最大值。最坏情况：right - left = Integer.MAX_VALUE，但 Integer.MAX_VALUE / 2 仍然小于 Integer.MAX_VALUE，不会溢出。
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 9;
        LC704_BinarySearch obj = new LC704_BinarySearch();
        System.out.println(obj.search(nums, target));
    }

}
