package Sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    //分解：将当前的数组分为两半，这是一个明确的二分过程。你继续递归地将这两半再分为更小的部分，直到每个部分只包含一个元素或没有元素，此时认为每个部分都已经“排序”好了。
    //解决：递归地对这两半进行归并排序。
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort first and second halves

            mergeSort(array, left, mid);

            mergeSort(array, mid + 1, right);

            System.out.println("left divide："+left+", "+mid);
            System.out.println("right divide："+(mid+1)+", "+right);
            // Merge the sorted halves
            merge(array, left, mid, right);
            System.out.println("after merge:"+ Arrays.toString(array));
        }
    }

    //合并：将两个排序好的半部分合并成一个排序好的整体。合并过程本身是归并排序的核心，需要比较来自两个半部分的元素，以按正确的顺序放入合并后的数组。
    private static void merge(int[] array, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = array[mid + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 0, 4, 3, 2, 1, 6};
        System.out.println("origin array:"+Arrays.toString(nums));
        sortArray(nums);
    }
}
