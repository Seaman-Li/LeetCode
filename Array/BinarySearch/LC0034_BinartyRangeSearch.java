package Array.BinarySearch;

public class LC0034_BinartyRangeSearch {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = findLeft(nums, target);
        int rightIndex = findRight(nums, target);
        return new int[]{leftIndex, rightIndex};
    }

    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
//        为什么 findLeft() 直接返回 left？终止时，left == right，即 left 指向 第一个 ≥ target 的索引。如果 target 存在，left 刚好是 target 的起始索引。如果 target 不存在，left 会指向插入 target 的位置（但 nums[left] != target）。
//        如果 target 不存在，搜索左侧边界的二分搜索返回的索引是大于 target 的最小索引

        // 此时 target 比所有数都大，返回 -1
        if (left == nums.length) return -1;
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
//        为什么 findRight() 返回 left - 1？终止时，left == right，但 left 指向第一个比 target 大的元素。left - 1 就是 最后一个 target 出现的位置。
//        和left_bound 相反：如果 target 不存在，搜索右侧边界的二分搜索返回的索引是小于 target 的最大索引
        // 判断 target 是否存在于 nums 中
        // left - 1 索引越界的话 target 肯定不存在
        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left - 1] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 6;
        LC0034_BinartyRangeSearch sol = new LC0034_BinartyRangeSearch();
        int[] res = sol.searchRange(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
