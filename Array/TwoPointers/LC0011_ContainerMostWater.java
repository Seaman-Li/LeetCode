package Array.TwoPointers;

public class LC0011_ContainerMostWater {

    public int maxAreaGeneral(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;

        for (int i = left; i <= right; i++) {
            for (int j = i + 1; j <= right; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }

        return max;
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = Integer.MIN_VALUE;
        while (left < right) {
            int minHeight=Math.min(height[left],height[right]);
            int water=minHeight*(right-left);
            maxWater=Math.max(maxWater,water);
//Skip consecutive smaller/equal heights before moving pointers:This avoids unnecessary recalculations of areas that we know are smaller.
            while(height[left]<=minHeight && left<right){
                left++;
            }
            while(height[right]<=minHeight && left<right){
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        LC0011_ContainerMostWater solution = new LC0011_ContainerMostWater();
        System.out.println(solution.maxArea(height));
    }
}
