package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,9,3,4,0,6,7,1,9};
        System.out.println("Original array:"+ Arrays.toString(arr));

        System.out.println();
        bubbleSort(arr);
        System.out.println("\nSorted array:"+ Arrays.toString(arr));

    }

//    重复地遍历要排序的列表，比较每对相邻项，并将它们顺序错误的项进行交换。过程重复直到没有需要交换的项为止。
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"轮："+Arrays.toString(arr));
        }
    }
}
