package example;


import java.util.Arrays;
import java.util.Scanner;

public class bestPlacetoAborad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // 小区数
        int M = scanner.nextInt();  // 上车点数
        int[] locations = new int[N];

        for (int i = 0; i < N; i++) {
            locations[i] = scanner.nextInt();
        }

        // 对小区位置排序
        Arrays.sort(locations);

        // 二分查找D的最小值
        int left = 0, right = locations[N - 1] - locations[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canPlaceBusStops(locations, M, mid)) {
                right = mid;  // 尝试更小的距离
            } else {
                left = mid + 1;  // 增大距离
            }
        }

        System.out.println(left);
        scanner.close();
    }

    // 判断在给定距离D的情况下，是否可以放置M个上车点
    private static boolean canPlaceBusStops(int[] locations, int M, int D) {
        int count = 1;  // 第一个上车点放在第一个小区
        int lastPosition = locations[0];

        for (int i = 1; i < locations.length; i++) {
            if (locations[i] - lastPosition > D) {
                count++;
                lastPosition = locations[i];
            }
            if (count > M) return false;
        }

        return count <= M;
    }
}
