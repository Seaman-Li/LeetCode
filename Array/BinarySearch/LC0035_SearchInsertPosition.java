package Array.BinarySearch;

public class LC0035_SearchInsertPosition {

    //findLeft,find the index of target, if target doesn't exist, return the index where target should be inserted
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;// Left points to the first position >= target
    }

    public static void main(String[] args) {
        int[]nums = {1,3,5,6};
        LC0035_SearchInsertPosition search = new LC0035_SearchInsertPosition();
        System.out.println(search.searchInsert(nums, 3));
    }
}
