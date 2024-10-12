package Sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {1,9,3,4,0,6,7,1,9};
        System.out.println("arr.length = " + arr.length);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

//    希尔排序通过引入一个间隔序列（gap sequence），来将数组分成多个子序列，然后每个子序列使用插入排序算法排序。间隔序列的最后一个间隔值必须为1，以确保整个数组最终是有序的。
    public static void shellSort(int[] array) {
        int n = array.length;
        // 开始间隔设为数组长度的一半
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // 对每个子数组进行插入排序
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            System.out.println("gap="+gap+":"+Arrays.toString(array));
        }

    }
}
