package Sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {11,9,3,4,0,6,7,1,5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
//开始：将第一个元素视为已排序。
//取出下一个元素：从未排序的部分取出下一个元素，暂存于一个变量中（记为 key）。
//找到插入位置：将 key 与已排序部分的元素从后向前逐一比较。
//移位：如果已排序的元素大于 key，则将该元素移动到下一位置。
//插入元素：重复步骤3和步骤4，直到找到 key 的正确位置，然后将其放置在那里。
//重复：重复步骤2~5，直到整个数组排序完成。
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            System.out.println("第"+(i)+"轮："+Arrays.toString(arr));
        }
    }
}
