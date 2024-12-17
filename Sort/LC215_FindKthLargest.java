package Sort;

import java.util.PriorityQueue;

public class LC215_FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        // 最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k + 1);

        for (int num : nums) {
            heap.add(num);
            System.out.println(heap);
//            if (heap.size() > k) {
//                heap.poll(); // 维持堆的大小为 k
//            }
        }

        System.out.println("final heap"+heap);

        for (int i = 0; i < nums.length-k; i++) {
            heap.poll();
        }

        return heap.peek(); // 堆顶元素是第 k 大的元素
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,1,4,4,6,7,3,0};
        System.out.println(findKthLargest(nums, 3));
    }
}
