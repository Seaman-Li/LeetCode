package Array;

import java.util.ArrayList;
import java.util.List;

public class LC448_findMissingNumbers {

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findMissingNumbers(nums));

    }

//    利用数组本身作为哈希表来记录信息
//    标记数组元素：遍历数组，对于每个元素 nums[i]，将数组中的位置 nums[nums[i] - 1] 标记为负数。这意味着数字 nums[i] 出现过。
//    检查非负位置：再次遍历数组，检查每个位置是否为正数。如果 nums[j] 是正数，表示数字 j + 1 没有出现过。
    public static List<Integer> findMissingNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        // 第一次遍历，标记出现过的数字
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;  //要加绝对值，例如本例中第一次遍历到的元素为4，把标记为4-1=3的下标元素7变为了-7，下一次遍历到-7时先转为7
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // 第二次遍历，找出未标记的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
