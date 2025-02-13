package Array;

import java.util.Arrays;
import java.util.HashMap;

public class LC169_MajorityElement {

//    Boyer-Moore 投票法的核心思想
//    在数组 nums 中寻找 出现次数超过 n/2 的元素。
//    投票法的核心规则：
//    候选人（candidate）：假设 candidate 是当前的多数元素。
//    计数器（count）：
//    遇到 candidate，count++（认为是支持票）。
//    遇到非 candidate，count--（认为是反对票）。
//    count == 0 时，说明当前 candidate 被完全抵消，需要选择新的候选人。
//    最终的 candidate 就是多数元素，因为它的票数超过所有其他元素的总和。
//    多数元素的定义：
//    多数元素出现次数 > n/2，意味着：
//    其他所有元素的总和 ≤ n/2。
//    也就是说，多数元素的票数一定大于其他所有元素的总和。
//    为什么 candidate 最终是多数元素？
//    由于 candidate 只在 count == 0 时更新，而 count 由多数元素的数量主导，所以最终 candidate 必然是 多数元素。
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;// 设定新的候选多数元素
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2]; // 中位数一定是多数元素
    }

    public int majorityElement3(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > nums.length / 2){
                return num;
            }
        }
        return -1;
    }




    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        LC169_MajorityElement sol = new LC169_MajorityElement();
        System.out.println(sol.majorityElement(nums));
    }

}
