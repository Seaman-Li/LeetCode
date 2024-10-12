package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1431_KidswithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        if (candies == null || candies.length == 0) return result;
        int maxCandies = 0;

        // 第一次遍历找到最大糖果数
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // 第二次遍历确定每个孩子是否可以成为糖果数最多的
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        result.forEach(System.out::println);
//        for (Boolean b : result) {
//            System.out.println(b);
//        }
    }
}
