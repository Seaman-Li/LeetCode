package Array.SlidingWindow;

public class LC209_MinSubarraySum {

//    Why is the Output Unique?
//    The algorithm always finds the smallest valid subarray because:
//    It only shrinks the window when sum >= target.
//    The first valid subarray found for a given right pointer is the shortest possible subarray for that position.
//    If another shorter subarray existed, it would have been found before due to the shrinking process.
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
//        Initialize variables:
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
//        Expand right boundary (right pointer):
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];// Remove leftmost element
                left++;//Shrink from the left (left pointer):
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        LC209_MinSubarraySum sol = new LC209_MinSubarraySum();
        System.out.println(sol.minSubArrayLen(7, nums));
    }


}
