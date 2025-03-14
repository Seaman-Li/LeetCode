package Array;

public class PortalGame {
    public static void main(String[] args) {
        int n = 5;
        int[] portals = {1, -4, 10, -30, 2};
        int[] portals2 = {1, 1, -1 , 1};
        System.out.println(maxDistance2(4, portals2));
    }

    private static int maxDistance(int n, int[] portals) {
        int maxDistance = 0;
        int currentPosition = 0;

        // 不使用“反转”技能时的最远距离
        for (int p : portals) {
            currentPosition += p;
            maxDistance = Math.max(maxDistance, Math.abs(currentPosition));
        }

        // 使用“反转”技能的情况，考虑在每个位置后使用反转技能
        for (int i = 0; i < n; i++) {
            // 使用反转前的位置累加
            currentPosition = 0;
            for (int j = 0; j <= i; j++) {
                currentPosition += portals[j];
                maxDistance = Math.max(maxDistance, Math.abs(currentPosition));
            }

            // 使用反转后，反向累加余下的传送门
            int reversePosition = currentPosition;
            for (int j = i + 1; j < n; j++) {
                reversePosition -= portals[j];
                maxDistance = Math.max(maxDistance, Math.abs(reversePosition));
            }
        }

        return maxDistance;
    }

    private static int maxDistance2(int n, int[] portals) {
        int maxDistance = 0;
        int currentPosition = 0;
        int[] forwardSum = new int[n]; // 存储每步的正向累积和

        // 第一遍：计算正向累积和，记录最大距离
        for (int i = 0; i < n; i++) {
            currentPosition += portals[i];
            forwardSum[i] = currentPosition;
            maxDistance = Math.max(maxDistance, Math.abs(currentPosition));
        }

        // 第二遍：尝试在每个位置使用反转技能，并计算可能的最大距离
        for (int i = 0; i < n; i++) {
            int reverseSum = 0; // 反向累积和
            int localMax = 0; // 本地最大距离

            // 反转后，计算新的累积和和最大距离
            for (int j = i + 1; j < n; j++) {
                reverseSum -= portals[j];
                localMax = Math.max(localMax, Math.abs(reverseSum));
            }

            // 计算此位置反转前后的最大值
            maxDistance = Math.max(maxDistance, Math.max(Math.abs(forwardSum[i]), localMax + Math.abs(forwardSum[i])));
        }

        return maxDistance;
    }
}


