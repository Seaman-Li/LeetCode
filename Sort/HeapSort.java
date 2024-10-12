package Sort;

public class HeapSort {
    public void sort(int[] nums) {
        int n = nums.length;

        // Build heap (rearrange array)
        // 从i = n / 2 - 1开始i--,根据完全二叉树的结构特性：对于数组中的任何一个位置 i，它的子节点（如果存在）必定位于 2i + 1 和 2i + 2。因此，只有那些索引小于或等于 (n-1)/2 的节点可能有子节点。
        //实际上，最后一个可能有子节点的位置是 (n-1)/2 的下取整，这是最后一个非叶子节点。因此，数组中最后一个非叶子节点的索引是 n / 2 - 1。
        //这一步是建立初始堆
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, n, i);

        // One by one extract an element from heap，将堆顶（最大元素）与堆的最后一个元素交换，并对剩余的堆进行重新调整以保持最大堆的性质
        //交换堆顶与堆尾元素 ——>缩减堆的大小并重新调整堆结构 ——>重复以上步骤直到堆的大小减少到1
        //注意这里即使 数组已经变成了有序，循环依然会继续执行
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // call max heapify on the reduced heap,这里i对应的就是堆的大小heapSize
            heapify(nums, i, 0);
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
            int temp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(nums, heapSize, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 4, 5, 1, 3, 2};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println("Sorted array is");
        for (int i : arr) System.out.print(i + " ");
    }
}
