package Mathmatics;

public class AmicableNum {
    // 计算一个数的真因子和
    public static int sumOfDivisors(int num) {
        int sum = 1; // 1 是所有数的因子
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) { // 避免平方数重复添加
                    sum += num / i;
                }
            }
        }
        return sum;
    }

    // 查找小于 n 的所有亲密数对（去重）
    public static void findAmicablePairs(int n) {
        System.out.println("Amicable Pairs less than " + n + ":");
        for (int a = 2; a < n; a++) {
            int b = sumOfDivisors(a);
            if (a < b && b < n && sumOfDivisors(b) == a) { // 仅当 a < b 时输出,去重
                System.out.println("(" + a + ", " + b + ")");
            }
        }
    }

    public static void main(String[] args) {
        int n = 10000; // 查找小于 n 的亲密数对
        findAmicablePairs(n);
    }

}
