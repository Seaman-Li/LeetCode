package Recursive;
import java.util.HashMap;
import java.util.Map;


public class LC070_ClimbStairs {
    private static final Map<Integer, Integer> storeMap = new HashMap<>();

    public static void main(String[] args){
        int stairNum = 10;
        System.out.println(climbStairsWithRecursion(stairNum));
        System.out.println(climbStairsWithLoop(stairNum));
    }

//    自顶向下
    public static int climbStairsWithRecursion(int n){

        // 检查map中是否已经有计算过的结果
        if (storeMap.containsKey(n)) {
            return storeMap.get(n);
        }
        // n为1和2的基本情况
        if (n == 1) {
            storeMap.put(1, 1);
            return 1;
        }
        if (n == 2) {
            storeMap.put(2, 2);
            return 2;
        }

        // 使用递归计算结果，并存储到map中
        int result = climbStairsWithRecursion(n - 1) + climbStairsWithRecursion(n - 2);
        storeMap.put(n, result);
        return result;
    }

//    自底向上
    public static int climbStairsWithLoop(int n){
        if (n == 1) { return 1; }
        if (n == 2) { return 2; }
        int result = 0;
        int pre = 1;
        int prePre = 2;
        for(int i = 3; i <= n; i++){
            result = pre + prePre;
            pre = prePre;
            prePre = result;
        }
        return result;
    }

    public static int fibonacci(int n){
        if(n == 0){ return 0;}
        if(n == 1){ return 1;}
        return fibonacci(n-1) + fibonacci(n-2);
    }
}


