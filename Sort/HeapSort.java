package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class HeapSort {
    public void sort(int[] nums) {
        int n = nums.length;

        // Build heap (rearrange array)
        // 从i = n / 2 - 1开始i--,根据完全二叉树的结构特性：对于数组中的任何一个位置 i，它的子节点（如果存在）必定位于 2i + 1 和 2i + 2。因此，只有那些索引小于或等于 (n-1)/2 的节点可能有子节点。
        //实际上，最后一个可能有子节点的位置是 (n-1)/2 的下取整，这是最后一个非叶子节点。因此，数组中最后一个非叶子节点的索引是 n / 2 - 1。
        //PS: 这一步是建立初始堆,即每个父节点的值都大于其子节点。这个过程保证了数组的第一个元素（根节点）是当前最大的元素
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(nums, n, i);
            System.out.println("heapify parents nodes");
            System.out.println(Arrays.toString(nums));
        }

        // One by one extract an element from heap，将堆顶（最大元素）与堆的最后一个元素交换，并对剩余的堆进行重新调整以保持最大堆的性质
        //交换堆顶与堆尾元素(即把堆头最大的元素移到最后，这个最大值可以不用参与后面的循环了) ——>缩减堆的大小并重新调整堆结构 ——>重复以上步骤直到堆的大小减少到1
        //注意这里即使 数组已经变成了有序，循环依然会继续执行
        //PS: 通过将最大的元素逐个移至数组末尾，并不断减小未排序的部分（即最大堆的大小），可以确保数组的末尾总是有序的。由于最大堆的性质保证了堆顶总是当前未排序部分的最大值，因此这种方法能有效地将数组从小到大排序。
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(nums, 0, i);
            System.out.println("swap"+Arrays.toString(nums));
            // call max heapify on the reduced heap,这里i对应的就是堆的大小heapSize
            heapify(nums, i, 0);
            System.out.println("heapify"+Arrays.toString(nums));
        }
    }

    // To heapify a subtree rooted with node i which is an index in nums[]
    // 在一个完全二叉树的层序遍历序列中，左子节点：2i + 1（<length），右子节点：2i + 2(<length)
    // 这个方法保证了构造的是完全二叉树，不会存在数值上：子节点>父节点 的情况
    void heapify(int[] nums, int heapSize, int root) {
        int largest = root; // Initialize largest as root
        int left = 2 * root + 1; // left = 2*i + 1
        int right = 2 * root + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < heapSize && nums[left] > nums[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < heapSize && nums[right] > nums[largest])
            largest = right;

        // If largest is not root
        if (largest != root) {
            swap(nums,root,largest);
            // Recursively heapify the affected sub-tree
            heapify(nums, heapSize, largest);
        }
    }

    public void Heapsort(int[] arr) {
        //PriorityQueue 默认是一个最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        int index = 0;
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }

    public void HeapsortReverse(int[] arr) {
        // 创建最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 将所有元素添加到最大堆中
        for (int value : arr) {
            maxHeap.add(value);
        }

        // 从最大堆中依次取出所有元素
        int index = 0;
        while (!maxHeap.isEmpty()) {
            arr[index++] = maxHeap.poll();
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    public static void main(String[] args) {
        int[] arr = {0, 4, 5, 1, 3, 2};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println("Sorted array is");
        for (int i : arr) System.out.print(i + " ");
    }
}
