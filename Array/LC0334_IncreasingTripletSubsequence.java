package Array;

public class LC0334_IncreasingTripletSubsequence {
//解题思路
//这个问题的核心是能否在数组中找到三个数，它们的大小关系是严格递增的。一种有效的解决方法是使用贪心算法，维护两个变量来追踪最小值和次小值，然后查找是否存在一个比这两个值都大的数。
//
//具体步骤
//初始化两个变量：定义两个变量 first 和 second 分别来追踪遇到的最小值和次小值。初始化为正无穷，以便任何元素都能更新它们。
//遍历数组：遍历整个数组，对于每个元素：
//如果当前元素比 first 小或等于，则更新 first。
//否则，如果当前元素比 second 小或等于，则更新 second。
//否则，如果当前元素比 second 大，则说明找到了一个满足条件的递增三元组，直接返回 true。
//检查结果：如果整个数组遍历完成都没有返回 true，说明不存在满足条件的三元组，返回 false。
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num; // 更新最小值
            } else if (num <= second) {
                second = num; // 更新次小值
            } else {
                return true; // 找到第三个值，比first和second都大
            }
        }
        return false; // 没有找到满足条件的三元组
    }

    public static void main(String[] args) {
        LC0334_IncreasingTripletSubsequence solution = new LC0334_IncreasingTripletSubsequence();
        int[] nums = {2,1,5,0,4,6};
        System.out.println(solution.increasingTriplet(nums));
    }
}
