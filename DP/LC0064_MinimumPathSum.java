package DP;

import java.util.*;

public class LC0064_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static List<int[]> minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] parent = new int[m][n];  // 用于追踪路径

        dp[0][0] = grid[0][0];
        // 初始化第一行和第一列
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
            parent[0][j] = 0;  // 来自左边，对于 parent[0][j] 的赋值为 0，表示路径是从左边的格子来的。这里的 0 是一个标记，用于在回溯路径时指示从左边移动。
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            parent[i][0] = 1;  // 来自上面，对于 parent[i][0] 的赋值为 1，表示路径是从上方的格子来的。这里的 1 也是一个标记，用于在回溯路径时指示从上方移动
        }

        // 填充dp表和parent表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    parent[i][j] = 1;  // 来自上面
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    parent[i][j] = 0;  // 来自左边
                }
            }
        }

        for(int[] arr: parent){
            System.out.println(Arrays.toString(arr));
        }


//        // 回溯找路径
//        List<int[]> path = new ArrayList<>();
//        int i = m - 1, j = n - 1;
//        while (i > 0 || j > 0) {
//            path.add(new int[]{i, j});
//            if (parent[i][j] == 1) { // 上面
//                i--;
//            } else { // 左边
//                j--;
//            }
//        }
//        path.add(new int[]{0, 0});  // 添加起始点
//        Collections.reverse(path);  // 翻转路径为从起点到终点

        return findPathWithStack(parent, m - 1, n - 1);
    }

    private static List<int[]> findPathWithStack(int[][] parent, int endRow, int endCol) {
        Deque<int[]> stack = new ArrayDeque<>(); // 使用栈
        int i = endRow, j = endCol;

        while (i > 0 || j > 0) {
            stack.push(new int[]{i, j}); // 压入栈顶
            if (parent[i][j] == 1) {
                i--; // 来自上方
            } else {
                j--; // 来自左侧
            }
        }
        stack.push(new int[]{0, 0}); // 添加起点

        // 将栈中的路径转为列表
        return new ArrayList<>(stack);
    }




    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
        for(int[] arr : minPathSum2(grid)) {
            System.out.println(Arrays.toString(arr));
        }
    }

}

//为什么推荐 Deque：
//
//Deque 是现代集合框架的一部分，灵活高效。
//Stack 是基于过时设计的类，线程安全开销较大，现代开发中应尽量避免使用。
//选择 Deque 实现类：
//
//推荐 ArrayDeque：高效、轻量，适用于大多数场景。
//LinkedList：适合特定需要链表特性的场景。
//现代 Java 开发中，用 Deque 替代 Stack 是最佳实践。

//Deque栈方法总结
//方法	     描述	              等效方法
//push(E e)	将元素压入栈顶	        addFirst(E e)
//pop()	    移除并返回栈顶的元素	removeFirst()
//peek()	返回栈顶的元素但不移除	getFirst()

//双端队列扩展功能
//由于 Deque 是双端队列，它还支持从两端进行插入和删除操作，因此还有以下方法：
//
//从队列头部操作
//方法	描述
//addFirst(E e)	将元素添加到队列头部
//offerFirst(E e)	将元素添加到队列头部
//removeFirst()	移除并返回队列头部的元素
//pollFirst()	移除并返回队列头部的元素，队列为空返回 null
//getFirst()	返回队列头部的元素但不移除
//peekFirst()	返回队列头部的元素但不移除，队列为空返回 null
//从队列尾部操作
//方法	描述
//addLast(E e)	将元素添加到队列尾部
//offerLast(E e)	将元素添加到队列尾部
//removeLast()	移除并返回队列尾部的元素
//pollLast()	移除并返回队列尾部的元素，队列为空返回 null
//getLast()	返回队列尾部的元素但不移除
//peekLast()	返回队列尾部的元素但不移除，队列为空返回 null


//动态规划：
//全局最优。
//通过子问题的最优解递归地构建全局最优解。
//适合需要考虑全局路径的场景。

//贪心算法：
//局部最优。
//每一步只基于当前最优选择，不考虑全局。
//仅适用于满足贪心选择性质的问题。

//什么时候可以用贪心？
//贪心算法适用于那些满足 贪心选择性质 的问题。例如：
//活动选择问题：选择不重叠的活动中最多的活动。
//最小生成树问题（Kruskal 或 Prim 算法）。
//最短路径问题（Dijkstra 算法，权值非负时）。
