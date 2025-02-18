package Array;

import java.util.Arrays;

public class LC0204_CountPrimes {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        //0和1不是素数
        isPrime[0] = false;
        isPrime[1] = false;

        //条件：i * i < n， 如果 i 是一个合数，并且有一个因子大于 √i，那么另一个因子必定小于 √i
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                //内层循环从 i * i 开始，这是因为小于 i * i 的倍数已经被更小的素数筛选过。例如，当 i = 3 时，3*2 = 6 已经在 i = 2 的循环中被标记了。
                //步长为 i，意味着跳过所有不是当前素数 i 的倍数的数，只标记那些是 i 倍数的数。
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }

        return count;
    }
}
