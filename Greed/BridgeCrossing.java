package Greed;

import java.util.Arrays;
//排序时间数组：让最快的人先带人过桥，减少来回时间浪费。
//两种策略：
//两最慢的人一起过桥（速度快，但可能拖慢时间）。
//最快的先带最慢的过去，然后最快的再返回（减少拖慢）。
//贪心策略：
//最优策略：
//让最慢的人尽可能减少独立过桥的次数（因为他们太慢）。
//让最快的人尽可能多次往返带人（因为他们很快）。
public class BridgeCrossing {
    public static int minTimeToCross(int[] times) {
        Arrays.sort(times); // 先排序，最小的在前
        int n = times.length;
        if (n == 1) return times[0]; // 只有 1 个人直接返回时间

        int totalTime = 0;
        int remainingPeople = n; // 记录剩余未过桥的人数

        while (remainingPeople > 3) {
            // 两种策略计算
            int strategy1 = 2 * times[1] + times[0] + times[remainingPeople - 1];
            int strategy2 = 2 * times[0] + times[remainingPeople - 1] + times[remainingPeople - 2];

            totalTime += Math.min(strategy1, strategy2);
            remainingPeople -= 2; // 最慢的两个人已经过桥
        }

        // 处理最后的 2~3 个人
        if (remainingPeople == 3) {
            totalTime += times[0] + times[1] + times[2]; // 3 个人时，最慢的需要最小的接送
        } else if (remainingPeople == 2) {
            totalTime += times[1]; // 2 个人时，最快的直接带过去
        }

        return totalTime;
    }

    public static void main(String[] args) {
        int[] times = {1, 2, 99, 100}; // 示例输入
        System.out.println("最短过桥时间: " + minTimeToCross(times));
    }
}
