package Array;

public class LC238_ProductofArrayExceptSelf {
//初始化两个数组：left 和 right。left[i] 存储索引 i 左侧所有元素的乘积，right[i] 存储索引 i 右侧所有元素的乘积。
//填充 left 数组：从左到右遍历原数组，使得 left[i] 等于 i 左侧所有元素的乘积。
//填充 right 数组：从右到左遍历原数组，使得 right[i] 等于 i 右侧所有元素的乘积。
//计算结果数组：对于每个索引 i，通过乘以 left[i] 和 right[i] 来计算结果。即res[i] = left[i] * right[i]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    //暴力法
    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }

        return result;
    }

    public static void main(String[] args) {
        LC238_ProductofArrayExceptSelf solution = new LC238_ProductofArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        int[] res = solution.productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
