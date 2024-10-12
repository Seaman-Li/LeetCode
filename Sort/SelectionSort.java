package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,9,3,4,0,6,7,1,9};
        System.out.println("Original array:"+ Arrays.toString(arr));

        System.out.println();
        selectionSort(arr);
        System.out.println("\nSorted array:"+ Arrays.toString(arr));

    }

//    在未排序的序列中找到最小元素，将其存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到已排序序列的末尾。
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 找到未排序部分的最小元素的索引
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 将未排序部分的最小元素交换到已排序部分的末尾
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            System.out.println("第"+(i+1)+"轮："+ Arrays.toString(arr));
        }
    }

}
