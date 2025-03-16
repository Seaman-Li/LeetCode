package Array;

import java.util.Arrays;

public class LC0189_RotateArray {

//    Reverse the entire array.
//    Reverse the first k elements.
//    Reverse the last n-k elements.
//    Example
//    For nums = [1,2,3,4,5,6,7], k = 3:
//
//    Reverse entire array → [7,6,5,4,3,2,1]
//    Reverse first k elements → [5,6,7,4,3,2,1]
//    Reverse remaining n-k elements → [5,6,7,1,2,3,4]
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;// Handle k > n case

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k > n

        // Convert array to string (space-separated)when using Arrays.toString(nums), the output automatically includes brackets and commas.
        String str = Arrays.toString(nums).replaceAll("[\\[\\],]", "").replace(" ", "");
        System.out.println(str);
        // Extract rotated parts
        String rotatedPart = str.substring(n - k);  // Last k elements
        String remainingPart = str.substring(0, n - k);  // First n-k elements

        // Combine rotated parts
        String rotatedString = rotatedPart + remainingPart;

        // Convert string back to array
        for (int i = 0; i < n; i++) {
            nums[i] = rotatedString.charAt(i) - '0'; // Convert char to int
        }
    }




    public static void main(String[] args) {
        LC0189_RotateArray sol = new LC0189_RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        sol.rotate2(nums, 3);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
