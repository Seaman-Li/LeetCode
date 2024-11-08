package Sort;

import java.util.Arrays;


public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // partitionIndex 是排序后基准元素的正确位置
            int partitionIndex = partition(arr, low, high);

            System.out.println("After partition around pivot index " + partitionIndex + ": " + Arrays.toString(arr)+"\n");

            System.out.println("quickSort(arr, low："+low+", partitionIndex - 1:"+(partitionIndex - 1)+")");
            // 递归排序基准元素左边的子数组
            quickSort(arr, low, partitionIndex - 1);

            System.out.println("quickSort(arr, partitionIndex + 1:"+(partitionIndex + 1)+", high:"+high+");");
            // 递归排序基准元素右边的子数组
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private static int randomPartition(int[] arr, int low, int high) {
        int range = high - low + 1;
        int randomIndex = low + (int)(Math.random() * range);
        swap(arr, randomIndex, high);  // 将随机选的元素换到最后
        System.out.println("Random partition:(randomIndex:"+randomIndex+")"+Arrays.toString(arr));
        return partition(arr, low, high);
    }

    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = arr[high];
        System.out.println("pivot " + pivot);
        int i = (low - 1); // 分区指示，i 起始值设置为 low - 1，这样第一次递增后 i 将指向 low 位置，即数组的开始位置。i 追踪的是最后一个已经放置在基准左侧的元素的位置。

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于 pivot
            if (arr[j] <= pivot) {
                i++;
                // 交换 arr[i] 和 arr[j]
                swap(arr, i, j);

                System.out.println("交换步骤:第"+i+"位和第"+j+"位交换："+Arrays.toString(arr));
            }

        }
        // 交换 arr[i+1] 和 arr[high] (或 pivot)使得pivot左边都是小于pivot，其右边都是大于pivot的元素
        swap(arr, i + 1, high);
        return i + 1;
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试快速排序
    public static void main(String[] args) {
        int[] arr = {5,9,3,4,0,6,7,1,11};
        int n = arr.length;

        System.out.println("Original array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}