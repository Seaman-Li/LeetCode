package Sort.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC0373_KPairsWithMinSum {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0|| k == 0)
            return res;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (!minHeap.isEmpty() && res.size() < k) {
            int[] top = minHeap.poll();
            int u = top[0], v = top[1],index = top[2];
            res.add(Arrays.asList(u, v));

            if(index + 1 < nums2.length){
                minHeap.offer(new int[]{u, nums2[index + 1], index + 1});
            }
        }
        return res;
    }


    public static void main(String[] args) {
        LC0373_KPairsWithMinSum solution = new LC0373_KPairsWithMinSum();
        int[] nums1 = new int[]{1,7,11};
        int[] nums2 = new int[]{2,4,6};
        System.out.println(solution.kSmallestPairs(nums1, nums2, 3));
    }
}
